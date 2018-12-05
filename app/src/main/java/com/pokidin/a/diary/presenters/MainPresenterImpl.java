package com.pokidin.a.diary.presenters;

import android.view.View;

import com.pokidin.a.diary.contracts.MainContract;

public class MainPresenterImpl implements MainContract.MainPresenter {
    private MainContract.MainView mView;

    public MainPresenterImpl(MainContract.MainView view) {
        mView = view;

        initPresenter();
    }

    private void initPresenter() {
        mView.initView();
    }

    @Override
    public void loginBtnClicked(View view) {
        mView.openRegisterView();
        mView.showToast("Login view opened");
    }

    @Override
    public void registerBtnClicked(View view) {
        mView.showToast("Register view opened");
    }


}
