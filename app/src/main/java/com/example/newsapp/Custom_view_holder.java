package com.example.newsapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class Custom_view_holder extends RecyclerView.ViewHolder {

    TextView text_title,text_sources;
    ImageView img_headline;
    CardView cardView;
    public Custom_view_holder(@NonNull View itemView) {
        super(itemView);
        text_title=itemView.findViewById(R.id.title);
        text_sources=itemView.findViewById(R.id.text_source);
        img_headline=itemView.findViewById(R.id.img);
        cardView=itemView.findViewById(R.id.container);
    }
}
