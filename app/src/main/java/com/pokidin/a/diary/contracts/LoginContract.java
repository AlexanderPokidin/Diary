package com.pokidin.a.diary.contracts;

import com.pokidin.a.diary.common.UserData;

public interface LoginContract {

    interface LoginModel {
        void sendLoginUserData(UserData userData);
    }

    interface LoginView {
        void initView();

        UserData getUserData();

        void showToast(String message);

        void showProgress();

        void hideProgress();
    }

    interface LoginPresenter {
        void signInBtnClicked();

        void loginUser();

        void onDestroy();
    }
}
