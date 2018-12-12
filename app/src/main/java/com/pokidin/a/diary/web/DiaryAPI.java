package com.pokidin.a.diary.web;

import com.pokidin.a.diary.common.UserLogin;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface DiaryAPI {

    @POST("/login")
    Call<ResponseBody> loginUser(
            @Body UserLogin userLogin
    );
}
