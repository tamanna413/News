package com.example.user.fakenewsapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.view.View;

import com.example.networkutil.NetworkUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;


public class Main2Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    String id;
    String API_KEY = "ed53b9b5396d4a8a8fbe46cfee2c3799";
    String URL = "https://newsapi.org/v2/top-headlines?sources=";
    String data;
    Adapter adapter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main2 );
        progressBar = findViewById ( R.id.progressbar );
        recyclerView = findViewById ( R.id.recyclerView );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );


        Intent intent = getIntent ();
        id = intent.getStringExtra ( "id" );

        adapter = new Adapter ( this );
        recyclerView.setAdapter ( adapter );

        new FetchNews ().execute ();
    }

    class FetchNews extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            String finalURL = URL + id + "&apiKey=ed53b9b5396d4a8a8fbe46cfee2c3799";
            data = NetworkUtil.makeServiceCall ( finalURL );
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute ();
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute ( aVoid );
            progressBar.setVisibility ( View.INVISIBLE );

            ArrayList<News> newsArrayList = new ArrayList<> ();

            if (data == null) {
                Toast.makeText ( Main2Activity.this, "No data returned", Toast.LENGTH_SHORT ).show ();
            } else {
                try {
                    JSONObject jsonData = new JSONObject ( data );
                    JSONArray articleArray = jsonData.getJSONArray ( "articles" );

                    for (int i = 0; 1 < articleArray.length (); i++) {
                        JSONObject news = articleArray.getJSONObject ( i );

                        String title = news.getString ( "title" );
                        String description = news.getString ( "description" );
                        String imgUrl = news.getString ( "urlToImage" );

                        newsArrayList.add ( new News ( title, description, imgUrl ) );

                    }
                } catch (JSONException e) {
                    e.printStackTrace ();
                }
            }
                adapter.swap ( newsArrayList );
            }

        }

}
