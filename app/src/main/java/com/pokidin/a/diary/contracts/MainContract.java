package com.pokidin.a.diary.contracts;

public interface MainContract {

    interface MainModel {

    }

    interface MainView {
        void showToast(String message);
    }

    interface MainPresenter {
        void openLoginView();

        void openRegisterView();
    }
}
