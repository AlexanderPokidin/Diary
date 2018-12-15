package com.pokidin.a.diary.common;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        App.sContext = getApplicationContext();
    }

    public static Context getAppContext() {
        return App.sContext;
    }
}
