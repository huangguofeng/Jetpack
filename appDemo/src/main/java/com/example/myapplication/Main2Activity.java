package com.example.myapplication;

import android.os.Bundle;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapplication.adapter.TestAdapter;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.vm.NewsViewModel;
import com.lib.base.ui.BaseActivity;
import com.lib.base.viewmodel.BaseViewModel;

import java.util.List;

/**
 * @author huangguofeng
 */
public class Main2Activity extends BaseActivity<ActivityMainBinding, NewsViewModel> {

    TestAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new TestAdapter();

        getViewBind().recycle.setAdapter(adapter);
        getViewBind().recycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        getViewModel().data.observe(this, new Observer<List<BaseViewModel>>() {
            @Override
            public void onChanged(List<BaseViewModel> baseViewModels) {
                adapter.setItems(baseViewModels);
            }
        });
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected NewsViewModel initViewModel() {
        return getViewModel(NewsViewModel.class);
    }
}