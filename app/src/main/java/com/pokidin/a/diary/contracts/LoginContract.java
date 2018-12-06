package com.pokidin.a.diary.contracts;

import com.pokidin.a.diary.common.UserData;

public interface LoginContract {

    interface LoginModel{
        void checkUser();
        void registerUser();
        void loadUsers();
    }

    interface LoginView{
        void initView();
        UserData getUserData();
        void showUsers();
        void showToast(String message);
        void showProgress();
        void hideProgress();
    }

    interface LoginPresenter{
        void signInBtnClicked();
        void registerUser();
        void loadUsers();
        void loginUser();
        void onDestroy();
    }
}
