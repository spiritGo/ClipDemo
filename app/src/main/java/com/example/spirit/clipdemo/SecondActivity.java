package com.example.spirit.clipdemo;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.spirit.clipdemo.utils.DesityUtil;
import com.example.spirit.clipdemo.utils.Util;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.view.ViewHelper;

import java.util.Timer;
import java.util.TimerTask;

public class SecondActivity extends Activity {
    private RelativeLayout rlContainer;
    private Button btnClick;
    private ImageView ivClip;
    private int clip = 1000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();

        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewHelper.setTranslationY(rlContainer, DesityUtil.dp2px(getApplicationContext(),
                        -50));
                Drawable background = ivClip.getBackground();
                background.setLevel(10000);
                timerAnim(background);
            }
        });
    }

    private void timerAnim(final Drawable background) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Util.runOnUI(new Runnable() {
                    @Override
                    public void run() {
                        rlAnimation();
                    }
                });
            }
        }, 1000);

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Util.runOnUI(new Runnable() {
                    @Override
                    public void run() {
                        ValueAnimator valueAnimator = ValueAnimator.ofInt(10000, 0);
                        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener
                                () {
                            @Override
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                int animatedValue = (int) valueAnimator.getAnimatedValue();
                                background.setLevel(animatedValue);
                                System.out.println(animatedValue);
                            }
                        });

                        valueAnimator.setDuration(5000);
                        valueAnimator.start();
                    }
                });
            }
        }, 2000);
    }

    private void rlAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(DesityUtil.dp2px
                (getApplicationContext(), -50), DesityUtil.dp2px(getApplicationContext(),
                0));
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int animatedValue = (int) valueAnimator.getAnimatedValue();
                ViewHelper.setTranslationY(rlContainer, DesityUtil.dp2px
                        (getApplicationContext(), animatedValue));
            }
        });
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.start();
    }

    private void initView() {
        rlContainer = findViewById(R.id.rl_container);
        btnClick = findViewById(R.id.btn_click);
        ivClip = findViewById(R.id.iv_clip);
    }
}
