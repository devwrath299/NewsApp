package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Details extends AppCompatActivity {
   News_headlines headlines;
   TextView text_title,text_author,text_time,text_detail,text_content;
   ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        headlines= (News_headlines) getIntent().getSerializableExtra("data");
        text_title=findViewById(R.id.text_deatil_title);
        text_author=findViewById(R.id.text_detail_author);
        text_time=findViewById(R.id.text_detail_time);
        text_content=findViewById(R.id.text_detail_content);
        text_detail=findViewById(R.id.text_detail_details);
        imageView=findViewById(R.id.image_details);


        text_title.setText(headlines.getTitle());
        text_author.setText(headlines.getAuthor());
        text_time.setText(headlines.getPublishedAt());
        text_detail.setText(headlines.getDescription());
        text_content.setText(headlines.getContent());
        Picasso.get().load(headlines.getUrlToImage()).into(imageView);



    }
}