package com.example.h119230.cognitive;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Khushbu on 11/28/2016.
 */
public class JSONFunction {

    public static JSONObject getJSONfromURL(String url) {
        InputStream is = null;
        String result = "";
        String content = " ";
        JSONObject jArray = null;


        try {


            URL ur = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) ur.openConnection();
            //urlConnection.setConnectTimeout(CONNECTION_TIMEOUT);
            // urlConnection.setReadTimeout(DATARETRIEVAL_TIMEOUT);
            int statusCode = urlConnection.getResponseCode();
            if (statusCode == HttpURLConnection.HTTP_UNAUTHORIZED) {

            } else if (statusCode != HttpURLConnection.HTTP_OK) {

            }


            //Create Stream Reader to read the content
            BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            //Read the server Response
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + " ");
            }

            //HashMap<String, String> it = new HashMap<String, String>();

            content = sb.toString();

        } catch (Exception e) {
            Log.e("log_tag", "Error in http connection " + e.toString());
        }


        try {

            jArray = new JSONObject(content);
        } catch (JSONException e) {
            Log.e("log_tag", "Error parsing data " + e.toString());
        }

        return jArray;


    }


}