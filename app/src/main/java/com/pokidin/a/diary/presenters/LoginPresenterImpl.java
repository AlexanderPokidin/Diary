package com.pokidin.a.diary.presenters;

import com.pokidin.a.diary.common.UserData;
import com.pokidin.a.diary.contracts.LoginContract;

public class LoginPresenterImpl implements LoginContract.LoginPresenter {
    private LoginContract.LoginView mView;
    private LoginContract.LoginModel mModel;
    private UserData mUserData;

    public LoginPresenterImpl(LoginContract.LoginView view, LoginContract.LoginModel model) {
        mView = view;
        mModel = model;
    }

    @Override
    public void signInBtnClicked() {
        mView.showToast("Sign In button is pressed");
        mUserData = mView.getUserData();
        if (checkUserData(mUserData)) {
            loginUser();
        }
    }

    // Validation of the specified data
    private boolean checkUserData(UserData userData) {
        if (userData.getEmail().isEmpty()) {
            mView.showToast("Email field cannot be empty");
            return false;
        } else if (!userData.getEmail().contains("@")) {
            mView.showToast("Email is incorrect");
            return false;
        } else if (userData.getPassword().isEmpty()) {
            mView.showToast("Password field cannot be empty");
            return false;
        } else if (userData.getPassword().length() < 6) {
            mView.showToast("Password field cannot be shorter than 6 symbols");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void registerUser() {

    }

    @Override
    public void loadUsers() {

    }

    @Override
    public void loginUser() {
// TODO: Send Model to check the User
    }

    @Override
    public void onDestroy() {
        mView = null;
        mModel = null;
    }
}
