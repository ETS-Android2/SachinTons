package com.adityay.sachintons.interfaces;

import com.adityay.sachintons.models.Century;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoints {

    @GET("match_list")
    Call<List<Century>> getCenturyList();
}
