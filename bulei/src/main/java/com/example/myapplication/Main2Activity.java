package com.example.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bulei.sport.R;
import com.bulei.sport.databinding.ActivityMainBinding;
import com.bulei.sport.ui.activity.AiLiveActivity;
import com.example.myapplication.adapter.TestAdapter;
import com.example.myapplication.vm.NewsViewModel;
import com.jakewharton.rxbinding4.view.RxView;
import com.lib.base.ui.BaseActivity;
import com.lib.base.viewmodel.BaseViewModel;
import com.lib.utils.Logger;
import com.lib.utils.device.DeviceUtils;
import com.lib.utils.file.MmKvUtil;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.Arrays;
import java.util.Collections;
import java.util.Currency;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.internal.observers.ConsumerSingleObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * @author huangguofeng
 */
public class Main2Activity extends BaseActivity<ActivityMainBinding, NewsViewModel> {

    TestAdapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Logger.logError(DeviceUtils.getCpuCount()+"核CPU");
        adapter = new TestAdapter();

        getViewBind().recycle.setAdapter(adapter);
        getViewBind().recycle.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        getViewModel().data.observe(this, baseViewModels -> adapter.setItems(baseViewModels));

        Observable.create((ObservableOnSubscribe<String>) emitter -> {
            Logger.logDebug(Thread.currentThread().getName());
            emitter.onNext("huang");
            emitter.onComplete();
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new io.reactivex.rxjava3.core.Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Logger.logDebug("onSubscribe "+Thread.currentThread().getName());
            }

            @Override
            public void onNext(@NonNull String s) {
                Logger.logInfo(s);
                Logger.logDebug("onNext "+Thread.currentThread().getName());
            }


            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Logger.logDebug("onComplete "+Thread.currentThread().getName());
            }
        });

        RxView.clicks(getViewBind().init).throttleFirst(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(obj -> {
//                    MmKvUtil.put("loginResult",false);
                    startActivity(new Intent(Main2Activity.this, AiLiveActivity.class));
                });
        List<Integer> list = Arrays.asList(1,2,3,4,7,8,0);
        list.stream()
                .filter(integer -> integer%2 == 0)
                .map(integer -> integer.toString()+":apply")
                .forEach(s -> Logger.logDebug(Thread.currentThread().getName()+" : "+s));

        List<Integer> list2 = Arrays.asList(1,2,3,4,7,8,0);
        Observable<List<Integer>> observable = Observable.just(list2);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integers -> Logger.logDebug(Thread.currentThread().getName()+" : "+integers.size()));

        observable.observeOn(Schedulers.io()).subscribe(integers -> Logger.logDebug(Thread.currentThread().getName()+" : "+integers.size()));
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected NewsViewModel initViewModel() {
        return createViewModel(NewsViewModel.class);
    }
}