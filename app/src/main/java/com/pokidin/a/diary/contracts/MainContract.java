package com.pokidin.a.diary.contracts;

import android.view.View;

public interface MainContract {

    interface MainView {
        void initView();

        void showToast(String message);

        void openRegisterView();

        void openLoginView();
    }

    interface MainPresenter {
        void loginBtnClicked();

        void registerBtnClicked(View view);

        void onDestroy();
    }
}
