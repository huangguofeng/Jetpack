package com.hgf.jetpack.ui.activity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hgf.jetpack.R;
import com.hgf.jetpack.databinding.ActivityMainBinding;
import com.hgf.jetpack.lifecycle.callback.LifecycleCallback;
import com.hgf.jetpack.lifecycle.observer.ActivityLifecycleObserver;
import com.hgf.jetpack.ui.adapter.MainFragmentPagerAdapter;
import com.hgf.jetpack.ui.base.BaseActivity;
import com.hgf.jetpack.ui.fragment.AdvertFragment;
import com.hgf.jetpack.ui.fragment.InitFragment;
import com.hgf.jetpack.ui.fragment.SettingsFragment;
import com.hgf.jetpack.ui.fragment.data.PayFragment;
import com.hgf.jetpack.ui.fragment.ui.login.LoginFragment;
import com.hgf.jetpack.utils.ILog;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :huangguofeng
 * date    :2020/6/22
 * package :com.hgf.jetpack.ui.activity
 * desc    :主页
 */
public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity -->";
    private ActivityLifecycleObserver lifecycleObserver;

    private ActivityMainBinding binding;
    private ViewPager2 viewPager2;
    private LottieAnimationView lottieAnimationView;
    private BottomNavigationView bottomNavigationView;

    /**
     * 对应底部导航的fragment
     */
    private InitFragment initFragment;
    private AdvertFragment advertFragment;
    private LoginFragment loginFragment;
    private PayFragment payFragment;
    private SettingsFragment settingsFragment;


    private int selectId = -1;

    /**
     * 返回键两次点击，第一次点击的时间
     */
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initData() {
        super.initData();

        lifecycleObserver = new ActivityLifecycleObserver(this, getLifecycle(), new LifecycleCallback() {
            @Override
            public void create() {
                startProgress(1);
            }

            @Override
            public void start() {

            }

            @Override
            public void resume() {

            }

            @Override
            public void pause() {

            }

            @Override
            public void stop() {

            }

            @Override
            public void destroy() {

            }
        });

        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                ILog.logInfo(TAG + "onAnimationStart");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                ILog.logInfo(TAG + "onAnimationEnd");
                lottieAnimationView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                ILog.logInfo(TAG + "onAnimationCancel");
                lottieAnimationView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                ILog.logInfo(TAG + "onAnimationRepeat");
            }
        });


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (selectId == item.getItemId()) {
                    ILog.logWarn(TAG + "已在当前页面，无需重复选择");
                    return false;
                }
                selectId = item.getItemId();
                switch (item.getItemId()) {
                    case R.id.activity_main_id_init:
                        viewPager2.setCurrentItem(0);
                        return true;
                    case R.id.activity_main_id_advert:
                        viewPager2.setCurrentItem(1);
                        return true;
                    case R.id.activity_main_id_account:
                        viewPager2.setCurrentItem(2);
                        return true;
                    case R.id.activity_main_id_pay:
                        viewPager2.setCurrentItem(3);
                        return true;
                    case R.id.activity_main_id_setting:
                        viewPager2.setCurrentItem(4);
                        return true;
                    default:
                        return false;
                }
            }
        });
        if (selectId == -1) {
            ILog.logDebug(TAG + "当前的导航栏ID：" + bottomNavigationView.getSelectedItemId() + " ," + R.id.activity_main_id_init);
            selectId = bottomNavigationView.getSelectedItemId();
        }
        List<Fragment> data = new ArrayList<>();
        data.add(initFragment);
        data.add(advertFragment);
        data.add(loginFragment);
        data.add(payFragment);
        data.add(settingsFragment);
        viewPager2.setUserInputEnabled(true);
        viewPager2.setOffscreenPageLimit(data.size());
        viewPager2.setAdapter(new MainFragmentPagerAdapter(this, data));
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
//                ILog.logDebug(TAG + "onPageScrolled：" + position + " ," + positionOffset + " , " + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                ILog.logDebug(TAG + "onPageSelected：" + position);
                switch (position) {
                    case 0:
                        bottomNavigationView.setSelectedItemId(R.id.activity_main_id_init);
                        break;
                    case 1:
                        bottomNavigationView.setSelectedItemId(R.id.activity_main_id_advert);
                        break;
                    case 2:
                        bottomNavigationView.setSelectedItemId(R.id.activity_main_id_account);
                        break;
                    case 3:
                        bottomNavigationView.setSelectedItemId(R.id.activity_main_id_pay);
                        break;
                    case 4:
                        bottomNavigationView.setSelectedItemId(R.id.activity_main_id_setting);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
                ILog.logDebug(TAG + "onPageScrollStateChanged：" + state);
            }
        });
    }

    @Override
    public void initView() {
        super.initView();
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        viewPager2 = binding.activityMainViewpager;
        lottieAnimationView = binding.activityMainProgress;
        bottomNavigationView = binding.activityMainNavigation;

        initFragment = InitFragment.newInstance("InitFragment", "InitFragment");
        advertFragment = AdvertFragment.newInstance("AdvertFragment", "AdvertFragment");
        loginFragment = LoginFragment.newInstance("LoginFragment", "LoginFragment");
        payFragment = PayFragment.newInstance(1);
        settingsFragment = SettingsFragment.newInstance("PayFragment", "SettingsFragment");
    }

    private void cancleProgress() {
        if (lottieAnimationView.isAnimating()) {
            lottieAnimationView.cancelAnimation();
        }
    }

    private void startProgress(int count) {
        if (!lottieAnimationView.isAnimating()) {
            lottieAnimationView.setAnimation("loading/loading-three-colors.json");
            lottieAnimationView.setRepeatMode(LottieDrawable.RESTART);
            lottieAnimationView.setRepeatCount(count);
            lottieAnimationView.playAnimation();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ILog.logInfo("requestCode = " + requestCode + ", resultCode = " + resultCode);
        switch (requestCode) {
            case 1:
                if (data != null) {
                    ILog.logInfo("register result = " + data.getStringExtra("result"));
                }
                break;
            case 2:
                if (data != null) {
                    ILog.logInfo("login result = " + data.getStringExtra("result"));
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();这句话一定要注掉,不然又去调用默认的back处理方式了
        // 这里处理逻辑代码，大家注意：该方法仅适用于2.0或更新版的sdk
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再次点击退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }
}
