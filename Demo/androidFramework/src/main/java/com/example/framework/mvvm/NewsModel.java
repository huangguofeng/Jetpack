package com.example.framework.mvvm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.framework.news.INews;
import com.example.framework.news.News;
import com.lib.utils.Logger;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @author :huangguofeng
 * date    :2021/8/10
 * package :com.example.framework.mvvm
 * desc    :
 */
public class NewsModel extends ViewModel {
    public MutableLiveData<News> data = new MutableLiveData<>();
    private final String API_NEWS = "http://v.juhe.cn/";
    private final String API_NEWS_TOKEN = "7723d691f364d35a07337cde0f89cce6";

    public NewsModel() {
        load();
    }


    public void load() {
        getNews(API_NEWS, "top", 1, 10, API_NEWS_TOKEN);
    }

    protected void getNews(String baseUrl, String type, int page, int pageSize, String token) {
        Logger.logDebug("getNews: baseUrl = " + baseUrl + ", type = " + type + ", page = " + page +
                ", pageSize = " + pageSize + ", token = " + token);

        INews news = HttpRetrofit.get().getRetrofit(baseUrl).create(INews.class);
        Call<News> result = news.getNewsGet(type, page, pageSize, token);

        result.enqueue(new HttpRetrofitCallback<News>() {
            @Override
            public void success(int code, Call<News> call, Response<News> response) {
                data.setValue(response.body());
            }

            @Override
            public void fail(int code, Call<News> call, String error) {

            }
        });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        data = null;
    }
}
