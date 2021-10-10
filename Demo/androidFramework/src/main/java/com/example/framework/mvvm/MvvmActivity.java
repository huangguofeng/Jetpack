package com.example.framework.mvvm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.framework.R;
import com.example.framework.databinding.ListViewItemBinding;
import com.example.framework.news.News;

/**
 * @author huangguofeng
 * View角色
 */
public class MvvmActivity extends AppCompatActivity {
    private NewsModel model;
    ListViewItemBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.list_view_item, new BaseBindingComponent());
        model = new ViewModelProvider(this).get(NewsModel.class);
        model.data.observe(this, new Observer<News>() {
            @Override
            public void onChanged(News news) {
                binding.setNews(news.getResult().getData().get(0));
            }
        });
    }
}