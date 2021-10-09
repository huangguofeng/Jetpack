package com.bulei.sport.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.lib.base.viewmodel.BaseViewModel;
import com.lib.utils.Logger;
import com.lib.utils.file.MmKvUtil;

public class LoginViewModel extends BaseViewModel {
    public MutableLiveData<Boolean> isEditFocus = new MutableLiveData<>();
    public MutableLiveData<Boolean> loginResult = new MutableLiveData<>();
    public int loginState = 0;
    public LoginViewModel(){

    }

    public void login(String phone,String password){
        Logger.logInfo("模拟账号登录，手机号："+phone+" ，密码："+password);
        loginResult.setValue(true);
        saveLogin(true);
    }

    public void register(String phone,String password,String verifyCode){
        Logger.logInfo("模拟账号登录，手机号："+phone+" ，密码："+password+" ，验证码："+verifyCode);
        loginResult.setValue(true);
        saveLogin(true);
    }

    public void saveLogin(boolean b){
        MmKvUtil.put("loginResult",b);
    }

    public boolean isLogin(){
        boolean b = MmKvUtil.getBoolean("loginResult");
        Logger.logInfo("是否已登录："+b);
        return b;
    }

}
