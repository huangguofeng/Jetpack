package com.example.framework.mvc;

import com.example.framework.news.INews;
import com.example.framework.news.News;
import com.lib.utils.Logger;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @author :huangguofeng
 * date    :2021/8/9
 * package :com.example.framework.mvc
 * desc    :Model角色
 */
public class NewsModel {
    /**
     * TODO: 测试用 新闻url token
     */
    public static final String API_NEWS = "http://v.juhe.cn/";
    public static final String API_NEWS_TOKEN = "7723d691f364d35a07337cde0f89cce6";

    public NewsModel() {

    }

    public void load(HttpCallback callback) {
        getNews(API_NEWS, "top", 1, 10, API_NEWS_TOKEN, callback);
    }

    protected void getNews(String baseUrl, String type, int page, int pageSize, String token, HttpCallback callback) {
        Logger.logDebug("getNews: baseUrl = " + baseUrl + ", type = " + type + ", page = " + page +
                ", pageSize = " + pageSize + ", token = " + token);

        INews news = HttpRetrofit.get().getRetrofit(baseUrl).create(INews.class);
        Call<News> result = news.getNewsGet(type, page, pageSize, token);

        result.enqueue(new HttpRetrofitCallback<News>() {
            @Override
            public void success(int code, Call<News> call, Response<News> response) {
                callback.success(code, response.body());
            }

            @Override
            public void fail(int code, Call<News> call, String error) {
                callback.fail(code, error);
            }
        });
    }
}
