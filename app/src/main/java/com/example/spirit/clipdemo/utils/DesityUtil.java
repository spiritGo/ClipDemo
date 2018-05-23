package com.example.spirit.clipdemo.utils;

import android.content.Context;

public class DesityUtil {

    public static int dp2px(Context context, float dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (dp * density + 0.5);
    }
}
