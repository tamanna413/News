package com.example.user.fakenewsapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.jar.Attributes;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    String [] channelName = {"ABC NEWS","The TIMES OF INDIA","NATIONAL GEOGRAPHIC","Daily Mail","Google News","Time","News24","MTV News","NBC News","Hacker News"};
    String [] channelType = {"abc-news","the-times-of-india","national-geographic","daily-mail","google-news","time","news24","mtv-news","nbc-news","hacker-news"};

    Context context;
    ItemClick itemClick;


    public NewsAdapter(Context context) {
        this.context = context;
        itemClick = (ItemClick) context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        return new ViewHolder (v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.title.setText ( channelName[position] );
        holder.type.setText ( channelType[position] );


        holder.title.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                itemClick.newClick ( position );

            }
        } );

        switch (position){
            case 0:
                Glide.with ( context ).load ( R.drawable.news1 ).into ( holder.newsImage );
                break;
            case 1:
                Glide.with ( context ).load ( R.drawable.news2 ).into ( holder.newsImage );
                break;
            case 2:
                Glide.with ( context ).load ( R.drawable.news3 ).into ( holder.newsImage );
                break;
            case 3:
                Glide.with ( context ).load ( R.drawable.news4).into ( holder.newsImage );
                break;
            case 4:
                Glide.with ( context ).load ( R.drawable.news5 ).into ( holder.newsImage );
                break;
            case 5:
                Glide.with ( context ).load ( R.drawable.news6).into ( holder.newsImage );
                break;
            case 6:
                Glide.with ( context ).load ( R.drawable.news7 ).into ( holder.newsImage );
                break;
            case 7:
                Glide.with ( context ).load ( R.drawable.news8 ).into ( holder.newsImage );
                break;
            case 8:
                Glide.with ( context ).load ( R.drawable.news9).into ( holder.newsImage );
                break;
            case 9:
                Glide.with ( context ).load ( R.drawable.news10 ).into ( holder.newsImage );
                break;
            case 10:
                Glide.with ( context ).load ( R.drawable.news1 ).into ( holder.newsImage );
                break;

        }

    }

    @Override
    public int getItemCount() {
        return channelName.length;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title,type;
        ImageView newsImage;

        public ViewHolder(View itemView) {
            super ( itemView );

            title = itemView.findViewById ( R.id.Title );
            type = itemView.findViewById ( R.id.Type );

            newsImage = itemView.findViewById ( R.id.newsImage );

        }
    }
}
