package com.pokidin.a.diary.models;

import android.util.Log;

import com.pokidin.a.diary.common.UserData;
import com.pokidin.a.diary.common.UserLogin;
import com.pokidin.a.diary.common.UserLoginResponse;
import com.pokidin.a.diary.contracts.CheckInContract;
import com.pokidin.a.diary.web.DiaryAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CheckInModelImpl implements CheckInContract.CheckInModel {
    private static final String TAG = CheckInModelImpl.class.getSimpleName();

    private UserLoginResponse mUserLoginResponse;


    @Override
    public void sendCheckInUserData(UserData userData) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DiaryAPI.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DiaryAPI diaryAPI = retrofit.create(DiaryAPI.class);

        UserLogin userLogin = new UserLogin(userData.getName(), userData.getSurname(), userData.getEmail(), userData.getPassword());
        Call<UserLoginResponse> call = diaryAPI.checkInUser(userLogin);

        call.enqueue(new Callback<UserLoginResponse>() {
            @Override
            public void onResponse(Call<UserLoginResponse> call, Response<UserLoginResponse> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "Response is Successful, " + response.code() + ", " + response.message());
                    mUserLoginResponse = response.body();
                    assert mUserLoginResponse != null;
                    Log.d(TAG, "mLoginResponse: " + mUserLoginResponse.getUserName() + ", Token: " + mUserLoginResponse.getToken());
                } else {
                    Log.d(TAG, "Response is Failed, " + response.code() + ", " + response.message());
                }
            }

            @Override
            public void onFailure(Call<UserLoginResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });
    }
}
