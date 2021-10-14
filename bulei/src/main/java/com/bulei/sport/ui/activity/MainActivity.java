package com.bulei.sport.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bulei.sport.R;
import com.bulei.sport.databinding.ActivityMainBinding;
import com.bulei.sport.ui.MainPath;
import com.bulei.sport.ui.fragment.HomeFragment;
import com.bulei.sport.ui.fragment.MatchFragment;
import com.bulei.sport.ui.fragment.MyFragment;
import com.bulei.sport.ui.fragment.SportFragment;
import com.lib.base.ui.BasicActivity;
import com.lib.utils.Logger;

/**
 * @author huangguofeng
 */
@SuppressLint("SetTextI18n")
@Route(path = MainPath.MAIN_HOME)
public class MainActivity extends BasicActivity {
    ActivityMainBinding binding;
    HomeFragment homeFragment;
    MatchFragment matchFragment;
    SportFragment sportFragment;
    MyFragment myFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ARouter.getInstance().inject(this);
        initData();
        initView();

    }

    private void initData() {
        homeFragment = new HomeFragment();
        matchFragment = new MatchFragment();
        sportFragment = new SportFragment();
        myFragment = new MyFragment();

        getFt().add(R.id.main_fg, homeFragment).add(R.id.main_fg, matchFragment)
                .add(R.id.main_fg, sportFragment).add(R.id.main_fg, myFragment)
                .hide(matchFragment).hide(sportFragment).hide(myFragment)
                .show(homeFragment)
                .commit();
    }

    private void initView() {
        binding.naviHome.setOnClickListener(v -> {
            getFt().hide(matchFragment).hide(sportFragment).hide(myFragment).show(homeFragment).commit();
        });
        binding.naviMatch.setOnClickListener(v -> {
            getFt().hide(homeFragment).hide(sportFragment).hide(myFragment).show(matchFragment).commit();
        });
        binding.naviCamera.setOnClickListener(v -> {
            Logger.logInfo("打开拍摄界面");
        });
        binding.naviSport.setOnClickListener(v -> {
            getFt().hide(matchFragment).hide(homeFragment).hide(myFragment).show(sportFragment).commit();
        });
        binding.naviMy.setOnClickListener(v -> {
            getFt().hide(matchFragment).hide(sportFragment).hide(homeFragment).show(myFragment).commit();
        });

    }


    private void goVerifyActivity() {
        ARouter.getInstance().build(MainPath.MAIN_VERIFY).navigation();
    }

}