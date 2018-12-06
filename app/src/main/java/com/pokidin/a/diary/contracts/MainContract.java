package com.pokidin.a.diary.contracts;

import android.view.View;

public interface MainContract {

    interface MainView {
        void initView();

        void showToast(String message);

        void openRegisterView();
    }

    interface MainPresenter {
        void loginBtnClicked(View view);

        void registerBtnClicked(View view);

        void onDestroy();
    }
}
