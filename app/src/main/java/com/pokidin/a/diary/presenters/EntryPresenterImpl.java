package com.pokidin.a.diary.presenters;

import android.util.Log;
import android.util.Patterns;

import com.pokidin.a.diary.common.App;
import com.pokidin.a.diary.common.UserData;
import com.pokidin.a.diary.contracts.EntryContract;
import com.pokidin.a.diary.models.EntryModelImpl;
import com.pokidin.a.diary.storage.Preferences;

public class EntryPresenterImpl implements EntryContract.EntryPresenter, EntryContract.EntryModel.OnFinishedListener {
    private static final String TAG = EntryPresenterImpl.class.getSimpleName();

    private EntryContract.EntryView mView;
    private EntryContract.EntryModel mModel;
    private UserData mUserData;

    public EntryPresenterImpl(EntryContract.EntryView view) {
        mView = view;
    }

    @Override
    public void entryBtnClicked() {
        mUserData = mView.getUserData();
        if (checkEntryData(mUserData)) {
            entryUser();
        }
    }

    @Override
    public void entryUser() {
        mModel = new EntryModelImpl();
        Log.d(TAG, "Login started successfully");
        mView.showToast("Login started successfully");

        if (mModel != null) {
            mModel.getAccess(mUserData, this);

            Log.d(TAG, "entryUser: started");

        } else {
            Log.d(TAG, "Model is NULL");
        }
    }

    // Validation of the specified data
    protected boolean checkEntryData(UserData userData) {
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
    public void onDestroy() {
        mView = null;
        mModel = null;
    }

    @Override
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
