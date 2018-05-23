package com.example.spirit.clipdemo;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.graphics.ColorUtils;
import android.widget.TextView;

public class ForthActivity extends Activity {
    private TextView tvText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view01);
        initView();

        anim(Color.RED, Color.BLUE);
    }

    private void anim(final int start, final int end) {
        com.nineoldandroids.animation.ValueAnimator valueAnimator = com.nineoldandroids.animation
                .ObjectAnimator.ofInt(0, 100);
        valueAnimator.addUpdateListener(new com.nineoldandroids.animation.ValueAnimator
                .AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(com.nineoldandroids.animation.ValueAnimator
                                                  valueAnimator) {
                int animatedValue = (int) valueAnimator.getAnimatedValue();
                float fraction = valueAnimator.getAnimatedFraction();
                tvText.getBackground().setColorFilter(ColorUtils.blendARGB(start, end,
                        fraction), PorterDuff.Mode.SRC_IN);
                if (animatedValue == 100) {
                    anim(end, start);
                }
            }
        });
        valueAnimator.setDuration(5000);
        valueAnimator.start();
    }

    private void initView() {
        tvText = (TextView) findViewById(R.id.tv_text);
    }
}
