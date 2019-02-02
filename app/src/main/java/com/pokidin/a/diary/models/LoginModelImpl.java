package com.pokidin.a.diary.models;

import android.util.Log;

import com.pokidin.a.diary.common.UserData;
import com.pokidin.a.diary.common.UserLogin;
import com.pokidin.a.diary.common.UserLoginResponse;
import com.pokidin.a.diary.contracts.LoginContract;
import com.pokidin.a.diary.web.DiaryAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//public class LoginModelImpl implements LoginContract.LoginModel {
//    private static final String TAG = LoginModelImpl.class.getSimpleName();
//
//    private UserLoginResponse mLoginResponse;
//
//    public LoginModelImpl() {
//    }
//
//    @Override
//    public void sendLoginUserData(UserData userData) {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(DiaryAPI.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        DiaryAPI diaryAPI = retrofit.create(DiaryAPI.class);
//
//        UserLogin userLogin = new UserLogin(userData.getEmail(), userData.getPassword());
//        Call<UserLoginResponse> call = diaryAPI.loginUser(userLogin);
//
//        call.enqueue(new Callback<UserLoginResponse>() {
//            @Override
//            public void onResponse(Call<UserLoginResponse> call, Response<UserLoginResponse> response) {
//                if (response.isSuccessful()) {
//                    Log.d(TAG, "Response is Successful, " + response.code() + ", " + response.message());
//                    mLoginResponse = response.body();
//                    assert mLoginResponse != null;
//                    Log.d(TAG, "mLoginResponse: " + mLoginResponse.getUserName() + ", Token: " + mLoginResponse.getToken());
//
//                } else {
//                    Log.d(TAG, "Response is Failed, " + response.code() + ", " + response.message());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<UserLoginResponse> call, Throwable t) {
//                Log.d(TAG, "onFailure: " + t.getMessage());
//            }
//        });
//    }
//}
