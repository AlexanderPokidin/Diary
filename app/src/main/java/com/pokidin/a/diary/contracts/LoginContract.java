package com.pokidin.a.diary.contracts;

public interface LoginContract {

    interface LoginModel{
        void checkUser();
        void registerUser();
        void loadUsers();
    }

    interface LoginView{
        void initView();
        void getUserData();
        void showUsers();
        void showToast();
        void showProgress();
        void hideProgress();
    }

    interface LoginPresenter{
        void registerUser();
        void loadUsers();
        void checkUser();
    }
}
