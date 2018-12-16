package com.pokidin.a.diary.contracts;

import com.pokidin.a.diary.common.UserData;

public interface CheckInContract {

    interface CheckInModel {

    }

    interface CheckInView {
        void initView();

        UserData getUserData();

        void showToast(String message);

        void showProgress();

        void hideProgress();
    }

    interface CheckInPresenter {

        void registerBtnClicked();

        void registerUser();

        void onDestroy();
    }
}
