package com.pokidin.a.diary.contracts;

import com.pokidin.a.diary.common.UserData;

public interface EntryContract {
    interface EntryModel {
        void getAccess(UserData userData, OnFinishedListener listener);

        interface OnFinishedListener {
            void onFinished(String string);
        }
    }

    interface EntryView {
        void initView();

        UserData getUserData();

        void showToast(String message);

        void openRecordsList();

        void showProgress();

        void hideProgress();
    }

    interface EntryPresenter {
        void entryBtnClicked();

        void entryUser();

        void onDestroy();
    }
}
