package com.example.h119230.cognitive;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class MainActivity extends ActionBarActivity {


    ListView list;
    public ListAdapter adapter;

    ArrayList<HashMap<String, String>> ar;
    JSONObject jsonobject;
    JSONArray jsonarray;

    public static String TITLE = "title";
    public static String RATING = "rating";
    public static String TAG = "tags";
    public static String LINK = "link";
    public static String IMAGE = "imageJson";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ar = new ArrayList<>();
        list = (ListView) findViewById(R.id.listView);
        new DownloadJson().execute();





    }


    public class DownloadJson extends AsyncTask<Void,Void,Void> {


        protected void onPreExecute() {
            super.onPreExecute();
            // Create a progressdialog

        }


        @Override
        protected Void doInBackground(Void... voids) {

            ar = new ArrayList<HashMap<String, String>>();
            // Retrieve JSON Objects from the given URL address
            jsonobject = JSONFunction
                    .getJSONfromURL("https://api.stackexchange.com/2.2/questions/unanswered?tagged=android&order=desc&sort=activity&site=stackoverflow&access_token=S1FTJ3yJwkCgrALtlPGuTg))&key=daCDafP)IeEkXyiKZKZtVg(( ");


            try {
                // Locate the array name in JSON
                jsonarray = jsonobject.getJSONArray("items");

                for (int i = 0; i < jsonarray.length(); i++) {
                    HashMap<String, String> map = new HashMap<String, String>();
                    jsonobject = jsonarray.getJSONObject(i);
                    // Retrive JSON Objects
                    map.put("title", jsonobject.getString("title"));
                   // map.put("Rating", jsonobject.getString("Rating"));
                    map.put("link", jsonobject.getString("link"));
                    //map.put("flag", jsonobject.getString("flag"));
                    // Set the JSON Objects into the array
                    ar.add(map);
                }
            } catch (JSONException e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return null;


        }

        protected void onPostExecute(Void args) {
            // Locate the listview in listview_main.xml

            // Close the progressdialog
            adapter = new ListAdapter(MainActivity.this, ar);
            list.setAdapter(adapter);


        }
    }




}



