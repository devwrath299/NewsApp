package com.example.newsapp;

import android.content.Context;
import android.widget.Toast;

import java.net.ContentHandler;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RequestManager {

    Context context;

    Retrofit  retrofit =new Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public void getNewsHeadlines(onFetchDataListner listner,String category,String query)
    {
        CallNewsApi callNewsApi =retrofit.create(CallNewsApi.class);
        Call<News_ApiResponse>call =callNewsApi.callHeadlines("in",category,query, context.getString(R.string.api));

        try{
            call.enqueue(new Callback<News_ApiResponse>() {
                @Override
                public void onResponse(Call<News_ApiResponse> call, Response<News_ApiResponse> response) {
                    if(!response.isSuccessful())
                        Toast.makeText(context, "Eroor!!", Toast.LENGTH_SHORT).show();

                    listner.onFetchData(response.body().getArticles(),response.message());

                }

                @Override
                public void onFailure(Call<News_ApiResponse> call, Throwable t) {
                  listner.onError("Request Failed!");
                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public RequestManager(Context context) {
        this.context = context;
    }

    public interface CallNewsApi{
        @GET("top-headlines")
        Call<News_ApiResponse> callHeadlines(

                @Query("country")String country,
                @Query("category")String category,
                @Query("q")String query,
                @Query("apiKey") String api_key

                );
    }
}
