package com.pokidin.a.diary.presenters;

import com.pokidin.a.diary.Views.MainActivity;
import com.pokidin.a.diary.contracts.MainContract;

public class MainPresenterImpl implements MainContract.MainPresenter {
    private MainActivity mView;

    public MainPresenterImpl(MainActivity view) {
        mView = view;

        initPresenter();
    }

    @Override
    public void openLoginView() {
        mView.showToast("Login view opened");
    }

    @Override
    public void openRegisterView() {
        mView.showToast("Register view opened");
    }

    private void initPresenter() {
        mView.initView();
    }
}
