package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements selectlistner, View.OnClickListener{
RecyclerView recyclerView;
customAdapter adapter;
ProgressDialog dialog;
Button b1,b2,b3,b4,b5,b6,b7;
SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialog=new ProgressDialog(this);
        dialog.setTitle("Fetching News Articles");
        dialog.show();
        searchView=findViewById(R.id.searchview);
        RequestManager manager =new RequestManager(this);
        manager.getNewsHeadlines(listner,"general",null);
        b1=findViewById(R.id.btn1);
        b2=findViewById(R.id.btn2);
        b3=findViewById(R.id.btn3);
        b4=findViewById(R.id.btn4);
        b5=findViewById(R.id.btn5);
        b6=findViewById(R.id.btn6);
        b7=findViewById(R.id.btn7);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.show();
                dialog.setTitle("Fetching News Article of "+query);
                RequestManager manager =new RequestManager(MainActivity.this);
                manager.getNewsHeadlines(listner,"general",query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

  public  final  onFetchDataListner<News_ApiResponse> listner =new onFetchDataListner<News_ApiResponse>() {
        @Override
        public void onFetchData(List<News_headlines> list, String message) {
            if(list.isEmpty())
            {
                Toast.makeText(getApplicationContext(), "No data found!!", Toast.LENGTH_SHORT).show();
            }
            else{
           showNews(list);
           dialog.dismiss();}
        }

        @Override
        public void onError(String message) {
            Toast.makeText(MainActivity.this, "An Error Occured", Toast.LENGTH_SHORT).show();
        }
    };

    private void showNews(List<News_headlines> list) {
        recyclerView =findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        adapter=new customAdapter(this,list,this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onNewsClicked(News_headlines headlines) {
     startActivity(new Intent(MainActivity.this,Details.class)
     .putExtra("data",headlines));
    }

    @Override
    public void onClick(View view) {
        dialog.show();
        Button button=(Button)view;
        String category=button.getText().toString();
        dialog.setTitle("Fetching News Article of "+ category);
        RequestManager manager =new RequestManager(this);
        manager.getNewsHeadlines(listner,category,null);


    }
}