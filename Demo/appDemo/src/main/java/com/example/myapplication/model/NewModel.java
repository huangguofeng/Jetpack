package com.example.myapplication.model;

import com.example.myapplication.Constant;
import com.example.myapplication.bean.News;
import com.example.myapplication.server.INews;
import com.example.myapplication.vm.TitleViewViewModel;
import com.lib.base.model.BaseModel;
import com.lib.base.server.IBaseModelListener;
import com.lib.base.viewmodel.BaseViewModel;
import com.lib.http.HttpCallback;
import com.lib.http.HttpRetrofit;
import com.lib.http.HttpRetrofitCallback;
import com.lib.utils.Logger;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @author :huangguofeng
 * date    :2021/3/1
 * package :com.example.myapplication.model
 * desc    :
 */
public class NewModel extends BaseModel {

    public NewModel(IBaseModelListener listener) {
        super(listener);
    }

    @Override
    public void load() {
        getNews(Constant.API_NEWS, "top", 1, 10, Constant.API_NEWS_TOKEN, new HttpCallback<News>() {

            @Override
            public void success(int code, News news) {
                List<BaseViewModel> viewViewModels = new ArrayList<>();
                Logger.logDebug(Constant.TAG, "load " + news.getResult().getData().size());

                for (int i = 0; i < news.getResult().getData().size(); i++) {
                    Logger.logDebug(Constant.TAG, "setDataBean " + news.getResult().getData().get(i).toString());
                    TitleViewViewModel titleViewViewModel = new TitleViewViewModel();
                    titleViewViewModel.setDataBean(news.getResult().getData().get(i));
                    viewViewModels.add(titleViewViewModel);
                }

                getIBaseModelListener().loadSuccess(code, viewViewModels);

            }

            @Override
            public void fail(int errorCode, String errorMsg) {

            }
        });
    }

    protected void getNews(String baseUrl, String type, int page, int pageSize, String token, HttpCallback callback) {
        Logger.logDebug(Constant.TAG, "getNews: baseUrl = " + baseUrl + ", type = " + type + ", page = " + page +
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
