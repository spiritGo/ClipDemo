package com.example.spirit.clipdemo;

import android.annotation.SuppressLint;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv_main_clip)
    TextView ivMainClip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        final Drawable drawable = ivMainClip.getBackground();

        @SuppressLint("HandlerLeak") final Handler handler = new Handler() {
            public void handleMessage(Message msg) {
                if (msg.what == 0x1233) {
                    //修改ClipDrawable的level值
                    drawable.setLevel(drawable.getLevel() + 200);
                }
            }
        };
        final Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                Message msg = new Message();
                msg.what = 0x1233;
                //发送消息,通知应用修改ClipDrawable对象的level值
                handler.sendMessage(msg);
                //取消定时器
                if (drawable.getLevel() >= 10000) {
                    timer.cancel();
                }
            }
        }, 0, 100);
    }
}
