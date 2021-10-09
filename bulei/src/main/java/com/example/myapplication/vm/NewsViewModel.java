package com.example.myapplication.vm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.savedstate.SavedStateRegistry;

import com.example.myapplication.Constant;
import com.example.myapplication.model.NewModel;
import com.lib.base.server.IBaseModelListener;
import com.lib.base.viewmodel.BaseViewModel;
import com.lib.utils.Logger;

import java.io.File;
import java.util.List;

/**
 * @author :huangguofeng
 * date    :2021/3/1
 * package :com.example.myapplication.vm
 * desc    :
 */
public class NewsViewModel extends BaseViewModel implements IBaseModelListener<List<BaseViewModel>>, SavedStateRegistry.SavedStateProvider {
    protected NewModel model;
    public MutableLiveData<List<BaseViewModel>> data = new MutableLiveData<>();
    SavedStateHandle handle;
    int number;
    File file;
    String numberKey = "numberKey";
    String fileKey = "fileKey";

    public NewsViewModel() {
        model = new NewModel(this);
        model.load();
    }

    /**
     * savedStateHandle可以储存因为配置改变导致的数据变化，只接收基础数据类型，类似onSaveInstanceState
     * 对于系统因为内存低等强制杀死重建的情况 使用setSavedStateProvider实现
     */
    public NewsViewModel(SavedStateHandle savedStateHandle) {
        // 读取bundle 检查bundle值 是否包含目标key 读取目标key转换需要的对象
        Bundle tempFileBundle = savedStateHandle.get(getClass().getName());
        if (tempFileBundle != null && tempFileBundle.containsKey(fileKey)) {
            file = new File(tempFileBundle.getString(fileKey));
        }

        // 储存SavedStateHandle对象 设置provider
        handle = savedStateHandle;
        handle.setSavedStateProvider(getClass().getName(), this);

        // 实例化数据对象 并加载数据 从savedStateHandle读取的key来源于本来实例化时的factory中的bundle对象
        model = new NewModel(this);
        model.load();

    }

    @Override
    public void loadSuccess(int code, List<BaseViewModel> datas) {
        Logger.logDebug(Constant.TAG, "loadFinish " + datas.size());
        data.setValue(datas);
    }

    @Override
    public void loadFail(int code, String error) {

    }

    public void add() {
        number++;
        handle.set(numberKey, number);
    }

    public void delete() {
        number--;
        handle.set(numberKey, number);
    }

    /**
     * 保存状态，需在包含SavedStateHandle参数的构造器内，调用savedStateHandle.setSavedStateProvider方可生效
     * 具体保存的数据逻辑，自行实现,在系统导致的界面重建时会自动触发该方法，只处理简单数据
     * 比如：home键触发时
     */
    @NonNull
    @Override
    public Bundle saveState() {
        Bundle bundle = new Bundle();
        bundle.putInt(numberKey, number);
        if (file != null) {
            bundle.putString(fileKey, file.getAbsolutePath());
        }

        return bundle;
    }
}
