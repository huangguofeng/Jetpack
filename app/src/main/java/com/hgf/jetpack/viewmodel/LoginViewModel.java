package com.hgf.jetpack.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hgf.jetpack.model.User;

/**
 * @author :huangguofeng
 * date    :2020/6/22
 * package :com.hgf.jetpack.viewmodel
 * desc    :登录ViewModel
 */
public class LoginViewModel extends ViewModel {
    private MutableLiveData<User> userLiveData;

    public MutableLiveData<User> getUserLiveData() {
        if (userLiveData == null) {
            userLiveData = new MutableLiveData<User>();
        }
        return userLiveData;
    }

    public void setValue(User user) {
        userLiveData.setValue(user);
    }

    public User getValue() {
        return userLiveData.getValue();
    }
}
