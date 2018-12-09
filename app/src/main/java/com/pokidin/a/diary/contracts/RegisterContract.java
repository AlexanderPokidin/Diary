package com.pokidin.a.diary.contracts;

import com.pokidin.a.diary.common.UserData;

public interface RegisterContract {

    interface RegisterModel {

    }

    interface RegisterView {
        void initView();

        UserData getUserData();

        void showToast(String message);

        void showProgress();

        void hideProgress();
    }

    interface RegisterPresenter {

        void registerBtnClicked();

        void registerUser();

        void onDestroy();
    }
}
