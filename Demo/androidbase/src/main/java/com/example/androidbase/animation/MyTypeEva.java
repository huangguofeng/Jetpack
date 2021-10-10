package com.example.androidbase.animation;

import android.animation.TypeEvaluator;

/**
 * @author :huangguofeng
 * date    :2021/8/3
 * package :com.example.androidbase.animation
 * desc    :
 */
public class MyTypeEva implements TypeEvaluator<Point> {
    @Override
    public Point evaluate(float fraction, Point startValue, Point endValue) {
        return new Point((fraction * 3f) * 200, (fraction * 3f) * (fraction * 3f) * 200);
    }
}
