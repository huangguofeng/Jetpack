package com.hgf.jetpack.ui.activity;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.hgf.jetpack.databinding.ActivityWelcomeBinding;
import com.hgf.jetpack.lifecycle.callback.LifecycleCallback;
import com.hgf.jetpack.lifecycle.observer.ActivityLifecycleObserver;
import com.hgf.jetpack.ui.base.BaseActivity;
import com.hgf.jetpack.utils.ILog;

/**
 * @author :huangguofeng
 * date    :2020/6/22
 * package :com.hgf.jetpack.ui.activity
 * desc    :欢迎页
 */
public class WelcomeActivity extends BaseActivity {
    private static final String TAG = "WelcomeActivity -->";
    private ActivityLifecycleObserver lifecycleObserver;
    private LifecycleCallback lifecycleCallback;
    private ActivityWelcomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {
        binding = ActivityWelcomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.lottie.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                ILog.logInfo(TAG + "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ILog.logInfo(TAG + "onAnimationEnd");
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                WelcomeActivity.this.finish();
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                ILog.logInfo(TAG + "onAnimationCancel");
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                WelcomeActivity.this.finish();
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                ILog.logInfo(TAG + "onAnimationRepeat");
            }
        });

        binding.lottie.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                // TODO 属性值animation.getAnimatedValue()范围 0~1,基本上只到0.99，用于更新进度条
            }
        });

        binding.lottie.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() {
            @Override
            public void onCompositionLoaded(LottieComposition composition) {
                // TODO 动画加载完成
                ILog.logInfo(TAG + "onCompositionLoaded " + composition.getDuration());
                ILog.logInfo(TAG + "onCompositionLoaded " + binding.lottie.getDuration() + " " + binding.lottie.getSpeed());
                binding.skip.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void initData() {
        lifecycleCallback = new LifecycleCallback() {
            @Override
            public void create() {
                ILog.logInfo(TAG + "onCreate");
                binding.lottie.setAnimation("logo/logo2.json");
                binding.lottie.setRepeatMode(LottieDrawable.RESTART);
                binding.lottie.setRepeatCount(0);
                binding.lottie.playAnimation();
            }

            @Override
            public void start() {
                ILog.logInfo(TAG + "onStart");
            }

            @Override
            public void resume() {
                ILog.logInfo(TAG + "onResume");
            }

            @Override
            public void pause() {
                ILog.logInfo(TAG + "onPause");
            }

            @Override
            public void stop() {
                ILog.logInfo(TAG + "onStop");
            }

            @Override
            public void destroy() {
                ILog.logInfo(TAG + "onDestroy");
            }
        };

        lifecycleObserver = new ActivityLifecycleObserver(this, getLifecycle(), lifecycleCallback);
    }

    public void go(View view) {
        if (binding.lottie.isAnimating()) {
            binding.lottie.cancelAnimation();
        }
    }
}