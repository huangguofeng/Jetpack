package com.example.androidbase.animation;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidbase.R;
import com.lib.utils.Logger;

public class AnimationActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        findViewById(R.id.bt1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.startAnimation(translateAnimation);
//                imageView.startAnimation(animationSet);
            }
        });

        findViewById(R.id.bt2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueAni();
            }
        });

        imageView = findViewById(R.id.img);
//        translateAnimation.setDuration(3000);
//        translateAnimation.setInterpolator(new LinearInterpolator());
//        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//                Logger.logDebug("平移动画开始");
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                Logger.logDebug("平移动画结束");
//                imageView.clearAnimation();
//                imageView.startAnimation(scaleAnimation);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//                Logger.logDebug("平移动画重复");
//            }
//        });
//        scaleAnimation.setDuration(3000);
//        scaleAnimation.setStartOffset(500);
//        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//                Logger.logDebug("缩放动画开始");
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                Logger.logDebug("缩放动画结束");
//                imageView.clearAnimation();
//                imageView.startAnimation(rotateAnimation);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//                Logger.logDebug("缩放动画重复");
//            }
//        });
//        rotateAnimation.setInterpolator(new LinearInterpolator());
//        rotateAnimation.setDuration(3000);//设置动画持续时间
//        rotateAnimation.setRepeatCount(0);//设置重复次数
//        rotateAnimation.setFillAfter(false);//动画执行完后是否停留在执行完的状态
//        rotateAnimation.setStartOffset(500);//执行前的等待时间
//        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//                Logger.logDebug("旋转动画开始");
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                Logger.logDebug("旋转动画结束");
//                imageView.clearAnimation();
//                imageView.startAnimation(alphaAnimation);
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//                Logger.logDebug("旋转动画重复");
//            }
//        });
//
//        alphaAnimation.setDuration(3000);
//        alphaAnimation.setStartOffset(500);
//        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//                Logger.logDebug("透明动画开始");
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                Logger.logDebug("透明动画结束");
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//                Logger.logDebug("透明动画重复");
//            }
//        });

        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(rotateAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(alphaAnimation);
        animationSet.setDuration(3000);
        animationSet.setRepeatMode(0);
        animationSet.setStartOffset(500);
    }

    public void valueAni() {
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new MyTypeEva(), new Point(0, 0));
        valueAnimator.setDuration(5000);
        valueAnimator.setInterpolator(new AccelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Point point = (Point) animation.getAnimatedValue();
                imageView.setX(point.x);
                imageView.setY(point.y);
                Logger.logDebug(point.x + "  000  " + point.y);
            }
        });
        valueAnimator.start();
    }

    AnimationSet animationSet = new AnimationSet(true);
    AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1f);
    TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 400, 400);
    ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 2.0f, 1.0f, 2.0f,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
    RotateAnimation rotateAnimation = new RotateAnimation(0f, 360f,
            Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
}