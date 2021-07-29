package com.example.androidbase;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.example.androidbase.surfaceview.SurfaceMainActivity;
import com.lib.utils.Logger;

import java.net.HttpURLConnection;

/**
 * @author huangguofeng
 */
public class WelcomeActivity extends AppCompatActivity {
    LottieAnimationView lottie;
    Button skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        lottie = findViewById(R.id.lottie);
        skip = findViewById(R.id.skip);
        HttpURLConnection connection;
        lottie.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Logger.logInfo("onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Logger.logInfo("onAnimationEnd");
                goMain();
                WelcomeActivity.this.finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Logger.logInfo("onAnimationCancel");
                goMain();
                WelcomeActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Logger.logInfo("onAnimationRepeat");
            }
        });

        lottie.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // TODO 属性值animation.getAnimatedValue()范围 0~1,基本上只到0.99，用于更新进度条
            }
        });

        lottie.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() {
            @Override
            public void onCompositionLoaded(LottieComposition composition) {
                // TODO 动画加载完成
                Logger.logInfo("onCompositionLoaded " + composition.getDuration());
                Logger.logInfo("onCompositionLoaded " + lottie.getDuration() + " " + lottie.getSpeed());
                skip.setVisibility(View.VISIBLE);
            }
        });

        lottie.setAnimation("logo/logo2.json");
        lottie.setRepeatMode(LottieDrawable.RESTART);
        lottie.setRepeatCount(0);
        lottie.playAnimation();

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lottie.cancelAnimation();
            }
        });
    }

    private void goMain() {
        startActivity(new Intent(WelcomeActivity.this, SurfaceMainActivity.class));
    }
}