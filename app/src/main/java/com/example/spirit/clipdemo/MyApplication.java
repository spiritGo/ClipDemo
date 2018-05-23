package com.example.spirit.clipdemo;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

public class MyApplication extends Application {
    private static Handler mHandler;
    private static Context mContext;
    private static int mThreadId;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        mHandler = new Handler();
        mThreadId = android.os.Process.myTid();
    }

    public static Context getmContext() {
        return mContext;
    }

    public static Handler getmHandler() {
        return mHandler;
    }

    public static int getmThreadId() {
        return mThreadId;
    }
}
