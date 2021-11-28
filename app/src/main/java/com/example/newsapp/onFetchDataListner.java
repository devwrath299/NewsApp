package com.example.newsapp;

import java.util.List;

public interface onFetchDataListner<News_ApiResponse> {

    void onFetchData(List<News_headlines> list, String message);
    void onError(String message);

}
