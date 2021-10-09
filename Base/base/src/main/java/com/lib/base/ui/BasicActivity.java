package com.lib.base.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import com.lib.base.utils.ActivityUtils;
import com.lib.base.viewmodel.BaseViewModel;

/**
 * @author :huangguofeng
 * date    :2021/3/6
 * package :com.lib.base.ui
 * desc    :
 */
public abstract class BasicActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Bundle defaultBundle = null;
    protected Activity mActivity;
    protected final static String BUNDLE_DEFAULT = "isDefault";

    public Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            handlerMsg(msg);
        }
    };

    protected void handlerMsg(Message msg){ }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = this;
        ActivityUtils.get().add(getClass().getName(),this);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        if(getIntent() != null && getIntent().getExtras() != null){
            defaultBundle = getIntent().getExtras();
        }else{
            defaultBundle = new Bundle();
            defaultBundle.putBoolean(BUNDLE_DEFAULT,true);
        }
    }

    protected FragmentManager getFm() {
        return fragmentManager;
    }

    protected FragmentTransaction getFt(){
        return fragmentTransaction;
    }

    /**
     * 无需判空的从bundle中取数据，用于获取intent传递的数据
     *
     * @return : 非空的Bundle
     */
    protected Bundle getBundle() {
        return defaultBundle;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityUtils.get().remove(getClass().getName());
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (isFullScreen() && hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    protected boolean isFullScreen(){
        return false;
    }
}
