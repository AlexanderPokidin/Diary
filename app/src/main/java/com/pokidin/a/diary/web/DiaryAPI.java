package com.pokidin.a.diary.web;

import com.pokidin.a.diary.common.UserLogin;
import com.pokidin.a.diary.common.UserLoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface DiaryAPI {
    String BASE_URL = "https://my-diary-node-api.herokuapp.com";

    @POST("/login")
    Call<UserLoginResponse> loginUser(
            @Body UserLogin userLogin
    );

    @POST("/register")
    Call<UserLoginResponse> checkInUser(
            @Body UserLogin userLogin
    );
}
