package com.pokidin.a.diary.presenters;

import android.util.Log;
import android.util.Patterns;

import com.pokidin.a.diary.common.App;
import com.pokidin.a.diary.common.UserData;
import com.pokidin.a.diary.contracts.CheckInContract;
import com.pokidin.a.diary.contracts.EntryContract;
import com.pokidin.a.diary.models.CheckInModelImpl;
import com.pokidin.a.diary.storage.Preferences;

public class CheckInPresenterImpl implements EntryContract.EntryPresenter, EntryContract.EntryModel.OnFinishedListener {
    private static final String TAG = CheckInPresenterImpl.class.getSimpleName();

    private CheckInContract.CheckInView mView;
    private EntryContract.EntryModel mModel;
    private UserData mUserData;

    public CheckInPresenterImpl(CheckInContract.CheckInView view) {
        mView = view;
    }

    @Override
    public void entryBtnClicked() {
        mUserData = mView.getUserData();
        if (checkRegistrationData(mUserData)) {
            entryUser();
        }
    }

    @Override
    public void entryUser() {
        mModel = new CheckInModelImpl();
        Log.d(TAG, "Registration started successfully");
        mView.showToast("Registration started successfully");

        if (mModel != null) {
            mModel.getAccess(mUserData, this);
        } else {
            Log.d(TAG, "Model is NULL");
        }
    }

    @Override
    public void onDestroy() {
        mView = null;
        mModel = null;
    }

    // Validation of the specified data
    private boolean checkRegistrationData(UserData userData) {
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

    private boolean isValidEmail(CharSequence target) { //YES
        return Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    @Override // YES
    public void onFinished(String string) {
        if (string != null) {
            Preferences preferences = new Preferences(App.getAppContext());
            preferences.setToken(string);
            Log.d(TAG, "onFinished: Token is: " + string);
        } else {
            Log.d(TAG, "onFinished: Token string is empty");
        }
    }
}
