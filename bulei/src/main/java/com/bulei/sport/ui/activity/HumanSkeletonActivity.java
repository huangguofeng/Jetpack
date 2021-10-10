package com.bulei.sport.ui.activity;

import android.os.Bundle;

import androidx.annotation.RequiresApi;

import com.bulei.sport.databinding.ActivitySkeletonBinding;
import com.lib.base.ui.BasicActivity;

public final class HumanSkeletonActivity extends BasicActivity {
    private static final String TAG = "[HumanSkeletonActivity]: ";

    ActivitySkeletonBinding binding;

    @Override
    @RequiresApi(api = 21)
    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);

        binding = ActivitySkeletonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }


    @Override
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

