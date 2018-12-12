package com.pokidin.a.diary.presenters;

import android.util.Log;
import android.util.Patterns;

import com.pokidin.a.diary.common.UserData;
import com.pokidin.a.diary.contracts.LoginContract;
import com.pokidin.a.diary.models.LoginModelImpl;

import java.util.List;

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
//        mView.showToast("Sign In button is pressed");
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
    public void loadUsers() {
        mModel.loadUsers(new LoginContract.LoginModel.LoadUserCallback() {
            @Override
            public void onLoad(List<UserData> users) {
                mView.showUsers(users);
            }
        });
    }

    @Override
    public void loginUser() {
        mModel = new LoginModelImpl();
        Log.d(TAG, "Login started successfully");
        mView.showToast("Login started successfully");

        if (mModel != null) {
            mModel.sendLoginUserData(mUserData);
        } else {
            Log.d(TAG, "Model is NULL");
        }

//        ContentValues values = new ContentValues();
//        values.put("EMAIL", mUserData.getEmail());
//        values.put("PASS", mUserData.getPassword());
//        mModel.registerUser(values, new LoginContract.LoginModel.CompleteCallback() {
//            @Override
//            public void onComplete() {
//                loadUsers();
//            }
//        });
    }

    @Override
    public void onDestroy() {
        mView = null;
        mModel = null;
    }
}
