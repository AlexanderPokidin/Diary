package com.pokidin.a.diary.presenters;

import com.pokidin.a.diary.contracts.LoginContract;
import com.pokidin.a.diary.models.LoginModelImpl;

public class LoginPresenterImpl implements LoginContract.LoginPresenter {
    private LoginContract.LoginModel mModel;
    private LoginContract.LoginView mView;

    private void initPresenter(){
        mModel = new LoginModelImpl();
        mView.initView();
    }

    @Override
    public void registerUser() {

    }

    @Override
    public void loadUsers() {

    }

    @Override
    public void checkUser() {

    }
}
