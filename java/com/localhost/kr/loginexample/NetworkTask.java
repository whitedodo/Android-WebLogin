package com.localhost.kr.loginexample;

import android.content.ContentValues;
import android.os.AsyncTask;

/**
 * Created by lab on 2017-11-27.
 */

public class NetworkTask extends AsyncTask<Void, Void, String> {

    private String url;
    private ContentValues values;

    public NetworkTask(String url, ContentValues values) {
        this.url = url;
        this.values = values;
    }

    @Override
    protected String doInBackground(Void... params) {

        String result;
        RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
        result = requestHttpURLConnection.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.

        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
        //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }

}
