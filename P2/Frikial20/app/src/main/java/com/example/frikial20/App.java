package com.example.frikial20;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;

public class App extends Application {

    private static Context mContext;

    public static Resources getResourcesStatic() {
        return mContext.getResources();
    }

    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }
}