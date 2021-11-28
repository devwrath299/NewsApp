package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class customAdapter extends RecyclerView.Adapter<Custom_view_holder> {

    Context context;
    selectlistner listner;

    public customAdapter(Context context, List<News_headlines> headlines,selectlistner l) {
        this.context = context;
        this.headlines = headlines;
        this.listner=l;
    }

    List<News_headlines>headlines;
    @NonNull
    @Override
    public Custom_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Custom_view_holder(LayoutInflater.from(context).inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Custom_view_holder holder, int position) {
        holder.text_title.setText(headlines.get(position).getTitle());
        holder.text_sources.setText(headlines.get(position).getSource().getName());
        if(headlines.get(position).getUrlToImage()!=null)
        {
            Picasso.get().load(headlines.get(position).getUrlToImage()).into(holder.img_headline);
        }
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listner.onNewsClicked(headlines.get(position));
            }
        });


    }

    @Override
    public int getItemCount() {
        return headlines.size();
    }
}
