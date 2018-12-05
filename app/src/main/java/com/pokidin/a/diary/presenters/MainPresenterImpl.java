package com.pokidin.a.diary.presenters;

import android.content.Intent;

import com.pokidin.a.diary.LoginActivity;
import com.pokidin.a.diary.views.MainActivity;
import com.pokidin.a.diary.contracts.MainContract;

public class MainPresenterImpl implements MainContract.MainPresenter {
    private MainActivity mView;

    public MainPresenterImpl(MainActivity view) {
        mView = view;

        initPresenter();
    }

    private void initPresenter() {
        mView.initView();
    }

    @Override
    public void openLoginView() {
        Intent intent = new Intent(mView, LoginActivity.class);
        mView.startActivity(intent);
        mView.showToast("Login view opened");
    }

    @Override
    public void openRegisterView() {
        mView.showToast("Register view opened");
    }


}
