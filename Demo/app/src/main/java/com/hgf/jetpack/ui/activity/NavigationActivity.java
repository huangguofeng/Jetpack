package com.hgf.jetpack.ui.activity;

import android.os.Bundle;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.hgf.jetpack.R;
import com.hgf.jetpack.ui.base.BaseActivity;

/**
 * @author :huangguofeng
 * date    :2020/7/15
 * package :com.hgf.jetpack.ui.activity
 * desc    :导航activity 适用于不断下一步的导航类，比如账号注册 引导类
 */
public class NavigationActivity extends BaseActivity {
    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
    }

    @Override
    public void initView() {
        super.initView();
    }

    @Override
    public void initData() {
        super.initData();
        navController = Navigation.findNavController(NavigationActivity.this, R.id.activity_navigation_id_host);

//        binding.activityMainNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                if (item.getItemId() == selectId) {
//                    ILog.logInfo("已经在当前页面 ：" + item.getTitle() + "，不需要重复导航");
//                    return false;
//                }
//                selectId = item.getItemId();
//                ILog.logInfo("即将导航到的页面 ：" + item.getTitle());
//                switch (item.getItemId()) {
//                    case R.id.activity_main_id_init:
//                        navController.navigate(R.id.initFragment);
//                        return true;
//                    case R.id.activity_main_id_advert:
//                        navController.navigate(R.id.advertFragment);
//                        return true;
//                    case R.id.activity_main_id_account:
//                        navController.navigate(R.id.loginFragment);
//                        return true;
//                    case R.id.activity_main_id_pay:
//                        navController.navigate(R.id.payFragment);
//                        return true;
//                    case R.id.activity_main_id_setting:
//                        navController.navigate(R.id.settingsFragment);
//                        return true;
//                    default:
//                }
//                return false;
//            }
//        });
    }
}