package com.bulei.sport.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import com.bulei.sport.databinding.ActivitySkeletonBinding;
import com.bulei.sport.viewmodel.LoginViewModel;
import com.lib.base.ui.BaseActivity;
import com.lib.base.ui.BasicActivity;

import java.util.List;

public final class HumanSkeletonActivity extends BasicActivity {
    private static final String TAG = "[HumanSkeletonActivity]: ";

    ActivitySkeletonBinding binding;

    @RequiresApi(api = 21)
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);

        binding = ActivitySkeletonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }


    public void onDestroy() {
        super.onDestroy();

    }

    protected void onPause() {
        super.onPause();

    }

    public void onResume() {
        super.onResume();
    }
}

