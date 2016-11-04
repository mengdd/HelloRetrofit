package com.ddmeng.helloretrofit.data.remote;

import com.ddmeng.helloretrofit.data.models.Endpoints;
import com.ddmeng.helloretrofit.data.models.Repo;
import com.ddmeng.helloretrofit.data.models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface GitHubService {
    @GET
    Call<Endpoints> getAllEndpoints(@Url String url);

    @GET("users/{user}")
    Call<User> getUser(@Path("user") String user);

    @GET("users/{user}/repos")
    Call<List<Repo>> getUserRepos(@Path("user") String user);

    @GET("users/{user}/following")
    Call<List<User>> getUserFollowing(@Path("user") String user);
}
