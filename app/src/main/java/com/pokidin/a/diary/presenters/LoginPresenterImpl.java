package com.pokidin.a.diary.presenters;

import android.util.Log;
import android.util.Patterns;

import com.pokidin.a.diary.common.App;
import com.pokidin.a.diary.common.UserData;
import com.pokidin.a.diary.common.UserLoginResponse;
import com.pokidin.a.diary.contracts.LoginContract;
import com.pokidin.a.diary.models.LoginModelImpl;
import com.pokidin.a.diary.storage.Preferences;

public class LoginPresenterImpl implements LoginContract.LoginPresenter {
    private static final String TAG = LoginPresenterImpl.class.getSimpleName();

    private LoginContract.LoginView mView;
    private LoginContract.LoginModel mModel;
    private UserData mUserData;

    public LoginPresenterImpl(LoginContract.LoginView view) {
        mView = view;
    }

    @Override
    public void signInBtnClicked() {
        mUserData = mView.getUserData();
        if (checkLoginData(mUserData)) {
            loginUser();
        }
    }

    // Validation of the specified data
    private boolean checkLoginData(UserData userData) {
        if (userData.getEmail().isEmpty()) {
            mView.showToast("Email field cannot be empty");
            return false;
        } else if (!isValidEmail(userData.getEmail())) {
            mView.showToast("Email is incorrect");
            return false;
        } else if (userData.getPassword().isEmpty()) {
            mView.showToast("Password field cannot be empty");
            return false;
        } else if (userData.getPassword().length() < 5) {
            mView.showToast("Password field cannot be shorter than 5 symbols");
            return false;
        } else {
            return true;
        }
    }

    private boolean isValidEmail(CharSequence target) {
        return Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    @Override
    public void loginUser() {
        mModel = new LoginModelImpl();
        Log.d(TAG, "Login started successfully");
        mView.showToast("Login started successfully");

        if (mModel != null) {
            mModel.sendLoginUserData(mUserData);
            UserLoginResponse userLoginResponse = new UserLoginResponse();
            Preferences preferences = new Preferences(App.getAppContext());
            preferences.setToken(userLoginResponse.getToken());
        } else {
            Log.d(TAG, "Model is NULL");
        }
    }

    @Override
    public void onDestroy() {
        mView = null;
        mModel = null;
    }
}
