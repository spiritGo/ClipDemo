package com.example.spirit.clipdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class ProgressDemo extends Activity {
    private ProgressBar pbProgress;
    private Button btnClick;
    private int progress = 0;
    private int secondaryProgress = 0;
    private Timer timer;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        initView();

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timer == null) {
                    timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            if (progress >= 10000) {
                                timer.cancel();
                                timer = null;
                                secondaryProgress = 0;
                                progress = 0;
                            }
                            pbProgress.setProgress(progress += 6);
                            if (secondaryProgress - progress <= 1000) {
                                pbProgress.setSecondaryProgress(secondaryProgress += 100);
                            }
                        }
                    }, 0, 10);
                }
            }
        });
    }

    private void initView() {
        pbProgress = findViewById(R.id.pb_progress);
        btnClick = findViewById(R.id.btn_click);
    }
}
