package com.pokidin.a.diary.storage;

import android.content.Context;
import android.content.SharedPreferences;

// A class that encapsulates work with SharedPreferences

public class Preferences {
    private final static String PREF_NAME = "preferences";
    private final static String TOKEN = "token";

    private SharedPreferences mSharedPreferences;

    public Preferences(SharedPreferences sharedPreferences) {
            mSharedPreferences = sharedPreferences;
    }

    public Preferences(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    private SharedPreferences.Editor getEditor() {
        return mSharedPreferences.edit();
    }

    public void setToken(String token) {
        getEditor().putString(TOKEN, token).commit();
    }

    public String getToken() {
        return mSharedPreferences.getString(TOKEN, "");
    }
}
