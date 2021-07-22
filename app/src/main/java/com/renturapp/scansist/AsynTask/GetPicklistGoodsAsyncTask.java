package com.renturapp.scansist.AsynTask;

import android.os.AsyncTask;

import com.renturapp.scansist.MyAsyncBus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by wayne on 15/10/16.
 * This is used to download data from movesist.com
 */

//Async Task to Fetch Picklist Goods
public class GetPicklistGoodsAsyncTask extends AsyncTask<String, String, String> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... strings) {
        try {

            String jsonGetString;

            URL url = new URL(strings[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuffer stringBuffer = new StringBuffer();
            while ((jsonGetString = bufferedReader.readLine()) != null) {
                stringBuffer.append(jsonGetString + "\n");
            }

            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return stringBuffer.toString().trim();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        MyAsyncBus.getInstance().post(new GetPicklistGoodsAsyncTaskResultEvent(result));
    }
}