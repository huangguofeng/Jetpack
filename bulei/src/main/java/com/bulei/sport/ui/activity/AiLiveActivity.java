package com.bulei.sport.ui.activity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import com.bulei.sport.databinding.ActivityAiLiveBinding;

import com.lib.base.ui.BasicActivity;

@SuppressLint("SetTextI18n")
public class AiLiveActivity extends BasicActivity{

    ActivityAiLiveBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAiLiveBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initView();
    }

    private void initView() {
        binding.test.setOnClickListener(v -> {
//            startCamera();
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}