package com.ddmeng.helloretrofit.data.remote;

import com.ddmeng.helloretrofit.data.models.Endpoints;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface GitHubService {
    @GET
    Call<Endpoints> getAllEndpoints(@Url String url);
}
