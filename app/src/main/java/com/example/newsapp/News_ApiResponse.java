package com.example.newsapp;

import java.io.Serializable;
import java.util.List;

public class News_ApiResponse implements Serializable {

    String status;
    int totalResults;
    List<News_headlines> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<News_headlines> getArticles() {
        return articles;
    }

    public void setArticles(List<News_headlines> articles) {
        this.articles = articles;
    }
}
