package com.pokidin.a.diary.presenters;

import android.util.Log;
import android.util.Patterns;

import com.pokidin.a.diary.common.UserData;
import com.pokidin.a.diary.contracts.RegisterContract;

public class RegisterPresenterImpl implements RegisterContract.RegisterPresenter {
    private static final String TAG = RegisterPresenterImpl.class.getSimpleName();

    private RegisterContract.RegisterView mView;
    private RegisterContract.RegisterModel mModel;
    private UserData mUserData;

    public RegisterPresenterImpl(RegisterContract.RegisterView view) {
        mView = view;
    }

    @Override
    public void registerBtnClicked() {
        mUserData = mView.getUserData();
        if (checkRegisterData(mUserData)) {
            registerUser();
        }
    }

    @Override
    public void registerUser() {
        Log.d(TAG, "Registration started successfully");
        mView.showToast("Registration started successfully");
    }

    @Override
    public void onDestroy() {
        mView = null;
        mModel = null;
    }

    // Validation of the specified data
    private boolean checkRegisterData(UserData userData) {
        if (userData.getName().isEmpty()) {
            Log.d(TAG, "Name field cannot be empty");
            mView.showToast("Name field cannot be empty");
            return false;
        } else if (userData.getSurname().isEmpty()) {
            Log.d(TAG, "Surname field cannot be empty");
            mView.showToast("Surname field cannot be empty");
            return false;
        } else if (userData.getEmail().isEmpty()) {
            Log.d(TAG, "Email field cannot be empty");
            mView.showToast("Email field cannot be empty");
            return false;
        } else if (!isValidEmail(userData.getEmail())) {
            Log.d(TAG, "Email is incorrect");
            mView.showToast("Email is incorrect");
            return false;
        } else if (userData.getPassword().isEmpty()) {
            Log.d(TAG, "Password field cannot be empty");
            mView.showToast("Password field cannot be empty");
            return false;
        } else if (userData.getPassword().length() < 5) {
            Log.d(TAG, "Password cannot be shorter than 5 symbols");
            mView.showToast("Password cannot be shorter than 5 symbols");
            return false;
        } else if (userData.getPasswordConfirm().isEmpty()) {
            Log.d(TAG, "PasswordConfirm field cannot be empty");
            mView.showToast("PasswordConfirm field cannot be empty");
            return false;
        } else if (!userData.getPassword().equals(userData.getPasswordConfirm())) {
            Log.d(TAG, "The entered passwords are different.");
            mView.showToast("The entered passwords are different.");
            return false;
        } else {
            return true;
        }
    }

    private boolean isValidEmail(CharSequence target) {
        return Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
}
