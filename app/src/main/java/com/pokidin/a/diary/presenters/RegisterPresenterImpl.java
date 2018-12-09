package com.pokidin.a.diary.presenters;

import com.pokidin.a.diary.common.UserData;
import com.pokidin.a.diary.contracts.RegisterContract;

public class RegisterPresenterImpl implements RegisterContract.RegisterPresenter {
    private RegisterContract.RegisterView mView;
    private RegisterContract.RegisterModel mModel;
    private UserData mUserData;

    public RegisterPresenterImpl(RegisterContract.RegisterView view) {
        mView = view;
    }

    @Override
    public void registerBtnClicked() {

    }

    @Override
    public void registerUser() {

    }

    @Override
    public void onDestroy() {

    }
}
