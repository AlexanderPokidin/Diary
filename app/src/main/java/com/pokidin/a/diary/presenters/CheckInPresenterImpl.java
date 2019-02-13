package com.pokidin.a.diary.presenters;

import android.util.Log;

import com.pokidin.a.diary.common.UserData;
import com.pokidin.a.diary.contracts.EntryContract;
import com.pokidin.a.diary.models.CheckInModelImpl;

public class CheckInPresenterImpl extends EntryPresenterImpl {
    private static final String TAG = CheckInPresenterImpl.class.getSimpleName();

    private EntryContract.EntryView mView;
    private EntryContract.EntryModel mModel;
    private UserData mUserData;

    public CheckInPresenterImpl(EntryContract.EntryView view) {
        super(view);
        mView = view;
    }

    @Override
    public void entryUser() {
        mModel = new CheckInModelImpl();
        Log.d(TAG, "Registration started successfully");
        mView.showToast("Registration started successfully");

        if (mModel != null) {
            mModel.getAccess(mUserData, this);
            Log.d(TAG, "entryUser: started");
        } else {
            Log.d(TAG, "Model is NULL");
        }
    }

    @Override
    public void entryBtnClicked() {
        mUserData = mView.getUserData();
        if (checkEntryData(mUserData)) {
            entryUser();
        }
    }

    @Override
    protected boolean checkEntryData(UserData userData) {
        super.checkEntryData(userData);
        if (userData.getName().isEmpty()) {
            Log.d(TAG, "Name field cannot be empty");
            mView.showToast("Name field cannot be empty");
            return false;
        } else if (userData.getSurname().isEmpty()) {
            Log.d(TAG, "Surname field cannot be empty");
            mView.showToast("Surname field cannot be empty");
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
}
