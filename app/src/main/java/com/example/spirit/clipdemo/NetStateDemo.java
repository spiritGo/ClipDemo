package com.example.spirit.clipdemo;

import android.widget.Toast;

public class NetStateDemo extends BaseActivity {

    @Override
    public void click() {
        Toast.makeText(getApplicationContext(),"hello",Toast.LENGTH_LONG).show();
    }

    @Override
    public void init() {
        BaseActivity.setBtnText("hello");
    }
}
