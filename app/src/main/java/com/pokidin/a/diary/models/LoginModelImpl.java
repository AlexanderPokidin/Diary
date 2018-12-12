package com.pokidin.a.diary.models;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;

import com.pokidin.a.diary.common.UserData;
import com.pokidin.a.diary.common.UserLogin;
import com.pokidin.a.diary.contracts.LoginContract;
import com.pokidin.a.diary.database.DbHelper;
import com.pokidin.a.diary.database.UserTable;
import com.pokidin.a.diary.web.DiaryAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginModelImpl implements LoginContract.LoginModel {
    private static final String TAG = LoginModelImpl.class.getSimpleName();
    private static final String BASE_URL = "https://my-diary-node-api.herokuapp.com";

    private DbHelper mDbHelper;

    public LoginModelImpl() {
    }

    public LoginModelImpl(DbHelper dbHelper) {
        mDbHelper = dbHelper;
    }

    @Override
    public void sendLoginUserData(UserData userData) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DiaryAPI diaryAPI = retrofit.create(DiaryAPI.class);

        UserLogin userLogin = new UserLogin(userData.getEmail(), userData.getPassword());
        Call<ResponseBody> call = diaryAPI.loginUser(userLogin);
        call.enqueue(new Callback<ResponseBody>() {
                         @Override
                         public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                             if (response.isSuccessful()) {
                                 Log.d(TAG, "Response is Successful, " + response.code() + ", " + response.message() + ", "
                                         + ", " + (response.body() != null ? response.body().source().toString() : "Response is " + null));
                             } else {
                                 Log.d(TAG, "Response is Failed, " + response.code() + ", " + response.message() + ", "
                                         + (response.errorBody() != null ? response.errorBody().source().toString() : "Error is " + null)
                                         + ", " + (response.body() != null ? response.body().toString() : "Response is " + null));
                             }
                         }

                         @Override
                         public void onFailure(Call<ResponseBody> call, Throwable t) {
                             Log.d(TAG, t.getMessage());
                         }
                     }
        );

    }

    //    __________________________ OLD METHODS _________________________
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
                UserData user = UserData.getInstance();
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
