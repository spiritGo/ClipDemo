package com.example.spirit.clipdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

public abstract class BaseActivity extends Activity {
    private Button btnClick;
    private static String btnText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button_layout);
        initView();

        init();
        btnClick.setText(btnText);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click();
            }
        });
    }

    private void initView() {
        btnClick = findViewById(R.id.btn_click);
    }

    public abstract void click();

    public static void setBtnText(String btnText) {
        BaseActivity.btnText = btnText;
    }

    public abstract void init();
}
