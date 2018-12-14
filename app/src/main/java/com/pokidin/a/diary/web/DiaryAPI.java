package com.pokidin.a.diary.web;

import com.pokidin.a.diary.common.UserLogin;
import com.pokidin.a.diary.common.UserLoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface DiaryAPI {

    @POST("/login")
    Call<UserLoginResponse> loginUser(
            @Body UserLogin userLogin
    );
}
