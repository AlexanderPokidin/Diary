package com.pokidin.a.diary.contracts;

import android.content.ContentValues;

import com.pokidin.a.diary.common.UserData;

import java.util.List;

public interface LoginContract {

    interface LoginModel {
        void checkUser();

        void registerUser(ContentValues values, CompleteCallback callback);

        void loadUsers(LoadUserCallback callback);

        interface CompleteCallback {
            void onComplete();
        }

        interface LoadUserCallback {
            void onLoad(List<UserData> users);
        }
    }

    interface LoginView {
        void initView();

        UserData getUserData();

        void showUsers(List<UserData> users);

        void showToast(String message);

        void showProgress();

        void hideProgress();
    }

    interface LoginPresenter {
        void signInBtnClicked();

        void registerUser();

        void loadUsers();

        void loginUser();

        void onDestroy();
    }
}
