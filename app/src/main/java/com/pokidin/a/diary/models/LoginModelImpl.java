package com.pokidin.a.diary.models;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.AsyncTask;

import com.pokidin.a.diary.common.UserData;
import com.pokidin.a.diary.contracts.LoginContract;
import com.pokidin.a.diary.database.DbHelper;
import com.pokidin.a.diary.database.UserTable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginModelImpl implements LoginContract.LoginModel {

    private DbHelper mDbHelper;

    public LoginModelImpl(DbHelper dbHelper) {
        mDbHelper = dbHelper;
    }

    @Override
    public void checkUser() {

    }

    @Override
    public void registerUser(ContentValues values, CompleteCallback callback) {
        AddUserTask addUserTask = new AddUserTask(callback);
        addUserTask.execute(values);
    }


    @Override
    public void loadUsers(LoadUserCallback callback) {
        LoadUsersTask loadUsersTask = new LoadUsersTask(callback);
        loadUsersTask.execute();
    }

    class AddUserTask extends AsyncTask<ContentValues, Void, Void> {
        private CompleteCallback mCallback;

        public AddUserTask(CompleteCallback callback) {
            mCallback = callback;
        }

        @Override
        protected Void doInBackground(ContentValues... params) {
            ContentValues values = params[0];
            mDbHelper.getWritableDatabase().insert(UserTable.TABLE, null, values);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if (mCallback != null) {
                mCallback.onComplete();
            }
        }
    }

    class LoadUsersTask extends AsyncTask<String, Void, List<UserData>> {
        private LoadUserCallback mCallback;

        public LoadUsersTask(LoadUserCallback callback) {
            mCallback = callback;
        }

        @Override
        protected List<UserData> doInBackground(String... params) {
            List<UserData> users = new ArrayList<>();
            String email = params[0];
            Cursor cursor = mDbHelper.getReadableDatabase().query(UserTable.TABLE,
                    new String[]{"EMAIL", "PASS"},
                    "EMAIL = ?",
                    new String[]{email},
                    null, null, null);
            while (cursor.moveToNext()) {
                UserData user = new UserData();
                user.setEmail(cursor.getString(1));
                user.setPassword(cursor.getString(2));
                users.add(user);
            }
            cursor.close();
            return users;
        }

        @Override
        protected void onPostExecute(List<UserData> users) {
            if (mCallback != null) {
                mCallback.onLoad(users);
            }
        }
    }
}
