package com.example.myapplication.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.myapplication.Constant;
import com.example.myapplication.base.BaseResponse;
import com.example.myapplication.bean.News;
import com.example.myapplication.bean.ResultCode;
import com.example.myapplication.server.INews;
import com.example.myapplication.utils.RetrofitUtils;
import com.example.myapplication.vm.TitleViewViewModel;
import com.lib.base.model.BaseModel;
import com.lib.base.server.IBaseModelListener;
import com.lib.base.viewmodel.BaseViewModel;
import com.lib.http.RetrofitManager;
import com.lib.http.RetrofitCallback;
import com.lib.utils.Logger;
import com.rxjava.rxlife.RxLife;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
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
//        getNews(Constant.API_NEWS, "top", 1, 10, Constant.API_NEWS_TOKEN, new RetrofitCallback<News>() {
//
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void success(Response<News> response) {
//                News news = response.body();
//                if(news == null){
//                    getIBaseModelListener().loadFail(ResultCode.FAIL.value(),"null");
//                    return;
//                }
//
//                List<BaseViewModel> viewViewModels = new ArrayList<>();
//                Logger.logInfo( "load " + Thread.currentThread().getName());
//                Logger.logInfo( "load " + news.toString());
//
//
//                Optional<News> news1 = Optional.of(news);
//                List<News.ResultBean.DataBean> bean = news1.map(News::getResult)
//                        .map(News.ResultBean::getData).orElse(null);
//
//                if(bean != null && bean.size() != 0){
//                    bean.forEach(dataBean -> {
//                        TitleViewViewModel titleViewViewModel = new TitleViewViewModel();
//                        titleViewViewModel.setDataBean(dataBean);
//                        viewViewModels.add(titleViewViewModel);
//                    });
//                }
//
//                getIBaseModelListener().loadSuccess(ResultCode.SUCCESS.value(), viewViewModels);
//            }
//
//            @Override
//            public void fail(Throwable throwable) {
//                getIBaseModelListener().loadFail(ResultCode.FAIL.value(), throwable.getMessage());
//            }
//        });

//        getNews3(Constant.API_NEWS, "top", 1, 10, Constant.API_NEWS_TOKEN);
        getNews4(Constant.API_NEWS, "top", 1, 10, Constant.API_NEWS_TOKEN);
    }

    protected void getNews(String baseUrl, String type, int page, int pageSize, String token, RetrofitCallback callback) {
        Logger.logDebug("getNews: baseUrl = " + baseUrl + ", type = " + type + ", page = " + page +
                ", pageSize = " + pageSize + ", token = " + token);

        INews news = RetrofitManager.get().getRetrofit(baseUrl).create(INews.class);
        Call<News> result = news.getNewsGet(type, page, pageSize, token);

        result.enqueue(callback);
    }

    protected void getNews2(String baseUrl, String type, int page, int pageSize, String token) {
        Logger.logDebug( "getNews: baseUrl = " + baseUrl + ", type = " + type + ", page = " + page +
                ", pageSize = " + pageSize + ", token = " + token);

        INews news = RetrofitManager.get().getRetrofit(baseUrl).create(INews.class);
        Observable<News> result = news.getNewsGet2(type, page, pageSize, token);

        result.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .to(RxLife.to(this))
                .subscribe(new Observer<News>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Logger.logDebug("onSubscribe "+ Thread.currentThread().getName());
                    }

                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onNext(News news) {
                        Logger.logDebug("onNext "+ Thread.currentThread().getName());
                        if(news == null){
                            getIBaseModelListener().loadFail(ResultCode.FAIL.value(),"null");
                            return;
                        }

                        List<BaseViewModel> viewViewModels = new ArrayList<>();
                        Logger.logInfo( "load " + Thread.currentThread().getName());
                        Logger.logInfo( "load " + news.toString());


                        Optional<News> news1 = Optional.of(news);
                        List<News.ResultBean.DataBean> bean = news1.map(News::getResult)
                                .map(News.ResultBean::getData).orElse(null);

                        if(bean != null && bean.size() != 0){
                            bean.forEach(dataBean -> {
                                TitleViewViewModel titleViewViewModel = new TitleViewViewModel();
                                titleViewViewModel.setDataBean(dataBean);
                                viewViewModels.add(titleViewViewModel);
                            });
                        }

                        getIBaseModelListener().loadSuccess(ResultCode.SUCCESS.value(), viewViewModels);
                    }

                    @Override
                    public void onError(Throwable t) {
                        Logger.logDebug("onError "+ Thread.currentThread().getName());
                    }

                    @Override
                    public void onComplete() {
                        Logger.logDebug("onComplete "+ Thread.currentThread().getName());
                    }
                });
    }

    protected void getNews3(String baseUrl, String type, int page, int pageSize, String token) {
        Logger.logDebug( "getNews: baseUrl = " + baseUrl + ", type = " + type + ", page = " + page +
                ", pageSize = " + pageSize + ", token = " + token);

        INews news = RetrofitManager.get().getRetrofit(baseUrl).create(INews.class);
        Observable<BaseResponse<News.ResultBean>> result = news.getNewsGet3(type, page, pageSize, token);

        result.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseResponse<News.ResultBean>>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Logger.logDebug("onSubscribe "+ Thread.currentThread().getName());
                    }

                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onNext(BaseResponse<News.ResultBean> response) {
                        Logger.logDebug("onNext "+ Thread.currentThread().getName());
                        Logger.logDebug("onNext "+ response.getError_code());
                        success(response.getResult());
                    }

                    @Override
                    public void onError(Throwable t) {
                        Logger.logDebug("onError "+ Thread.currentThread().getName());
                    }

                    @Override
                    public void onComplete() {
                        Logger.logDebug("onComplete "+ Thread.currentThread().getName());
                    }
                });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void success(News.ResultBean resultBean){
        if(resultBean == null){
            getIBaseModelListener().loadFail(-1,"null");
            return;
        }

        List<BaseViewModel> viewViewModels = new ArrayList<>();
        Logger.logInfo( "load " + Thread.currentThread().getName());

        Optional<News.ResultBean> news1 = Optional.of(resultBean);
        List<News.ResultBean.DataBean> bean = news1.map(News.ResultBean::getData)
                .orElse(null);

        if(bean != null && bean.size() != 0){
            bean.forEach(dataBean -> {
                TitleViewViewModel titleViewViewModel = new TitleViewViewModel();
                titleViewViewModel.setDataBean(dataBean);
                viewViewModels.add(titleViewViewModel);
            });
        }

        getIBaseModelListener().loadSuccess(0, viewViewModels);
    }

    protected void getNews4(String baseUrl, String type, int page, int pageSize, String token) {
        Logger.logDebug( "getNews: baseUrl = " + baseUrl + ", type = " + type + ", page = " + page +
                ", pageSize = " + pageSize + ", token = " + token);

        INews news = RetrofitManager.get().getRetrofit(baseUrl).create(INews.class);
        Observable<Response<News>> result = news.getNewsGet4(type, page, pageSize, token);

        result.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Response<News>>() {

                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Logger.logDebug("onSubscribe "+ Thread.currentThread().getName());
                    }

                    @RequiresApi(api = Build.VERSION_CODES.N)
                    @Override
                    public void onNext(Response<News> response) {
                        Logger.logDebug("onNext "+ Thread.currentThread().getName());
                        RetrofitUtils.logResponse(response);
                        success(response.body().getResult());
                    }

                    @Override
                    public void onError(Throwable t) {
                        Logger.logDebug("onError "+ Thread.currentThread().getName());
                    }

                    @Override
                    public void onComplete() {
                        Logger.logDebug("onComplete "+ Thread.currentThread().getName());
                    }
                });
    }
}
