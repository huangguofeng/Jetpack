package com.example.myapplication.base;

import com.example.myapplication.utils.RxExceptionUtil;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public abstract class BaseObserver<T> implements Observer<BaseResponse<T>> {
    @Override
    public void onSubscribe(@NonNull Disposable d) {

    }

    @Override
    public void onNext(@NonNull BaseResponse<T> response) {
        //在这边对 基础数据 进行统一处理  举个例子：
        if(response.getError_code() == 0){
            onSuccess(response.getResult());
        }else{
            onFail(null,response.getReason());
        }
    }

    @Override
    public void onError(@NonNull Throwable e) {
        onFail(e, RxExceptionUtil.exceptionHandler(e));
    }

    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(T demo);

    public abstract void onFail(Throwable e,String errorMsg);
}
