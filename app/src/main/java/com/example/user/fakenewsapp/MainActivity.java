package com.example.user.fakenewsapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity  implements ItemClick{

    //ListView listView;
    RecyclerView recyclerView;
    String [] channelId = {"abc-news","the-times-of-india","national-geographic","daily-mail","google-news","time","news24","mtv-news","nbc-news","hacker-news"};
    NewsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //listView = findViewById(R.id.channelList);
        recyclerView = findViewById ( R.id.recyclerView2 );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );

        adapter = new NewsAdapter (this  );
        recyclerView.setAdapter ( adapter );


    }

    @Override
    public void newClick(int position) {


        String chid = channelId[position];
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        intent.putExtra("id",chid);
        startActivity(intent);

    }
}