package com.pokidin.a.diary.presenters;

import android.view.View;

import com.pokidin.a.diary.contracts.MainContract;

public class MainPresenterImpl implements MainContract.MainPresenter {
    private MainContract.MainView mView;

    public MainPresenterImpl(MainContract.MainView view) {
        mView = view;
    }

    @Override
    public void loginBtnClicked() {
        if (mView != null) {
            mView.openLoginView();
            mView.showToast("Login view opened");
        }
    }

    @Override
    public void registerBtnClicked(View view) {
        if (mView != null) {
            mView.openRegisterView();
            mView.showToast("Register view opened");
        }
    }

    @Override
    public void onDestroy() {
        mView = null;
    }
}
