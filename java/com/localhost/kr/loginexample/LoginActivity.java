package com.localhost.kr.loginexample;

import android.content.ContentValues;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

/**
 * A login screen that offers login via email/password.
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final TextView tvID = (TextView)findViewById(R.id.email);
        final TextView tvPwd = (TextView)findViewById(R.id.password);
        Button button = (Button)findViewById(R.id.email_sign_in_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues contentValues = new ContentValues();


                contentValues.put("email", tvID.getText().toString().trim());
                contentValues.put("pwd", tvPwd.getText().toString().trim());
                NetworkTask networkTask = new NetworkTask("http://192.168.0.1:8080/Member/Check", contentValues);

                try {
                    String result = networkTask.execute().get();
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

