package com.example.spirit.clipdemo.utils;

import android.os.Handler;

import com.example.spirit.clipdemo.MyApplication;

public class Util {

    public static Handler getHandler() {
        return MyApplication.getmHandler();
    }

    public static void runOnUI(Runnable r) {
        getHandler().post(r);
    }
}
