package com.pokidin.a.diary.contracts;

public interface MainContract {

    interface MainView {
        void initView();

        void showToast(String message);

        void openRegisterView();

        void openLoginView();
    }

    interface MainPresenter {
        void loginBtnClicked();

        void registerBtnClicked();

        void onDestroy();
    }
}
