package com.example.retrowire;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface SearchService {

    @GET("/search/{query}")
    Call<SearchResult> results(@Path("query") String query);
}
