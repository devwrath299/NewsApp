package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class customAdapter extends RecyclerView.Adapter<Custom_view_holder> {

    Context context;

    public customAdapter(Context context, List<News_headlines> headlines) {
        this.context = context;
        this.headlines = headlines;
    }

    List<News_headlines>headlines;
    @NonNull
    @Override
    public Custom_view_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Custom_view_holder(LayoutInflater.from(context).inflate(R.layout.list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Custom_view_holder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
