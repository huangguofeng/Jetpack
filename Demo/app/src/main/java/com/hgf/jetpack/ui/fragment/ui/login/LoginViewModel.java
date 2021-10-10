package com.hgf.jetpack.ui.fragment.ui.login;

import android.util.Patterns;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.hgf.jetpack.R;
import com.hgf.jetpack.ui.fragment.data.LoginRepository;
import com.hgf.jetpack.ui.fragment.data.Result;
import com.hgf.jetpack.ui.fragment.data.model.LoggedInUser;

/**
 * @author :huangguofeng
 * date    :2020/7/3
 * package :com.hgf.jetpack.ui.fragment.ui.login
 * desc    :登录viewmodel
 */
public class LoginViewModel extends ViewModel {
    /**
     * 登录数据有效性验证
     */
    private MutableLiveData<LoginFormState> loginFormState = new MutableLiveData<>();
    /**
     * 登录结果
     */
    private MutableLiveData<LoginResult> loginResult = new MutableLiveData<>();
    /**
     * 登录操作的中介
     */
    private LoginRepository loginRepository;

    LoginViewModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    LiveData<LoginFormState> getLoginFormState() {
        return loginFormState;
    }

    LiveData<LoginResult> getLoginResult() {
        return loginResult;
    }

    /**
     * 登录以及输出结果
     */
    public void login(String username, String password) {
        // can be launched in a separate asynchronous job
        Result<LoggedInUser> result = loginRepository.login(username, password);

        if (result instanceof Result.Success) {
            LoggedInUser data = ((Result.Success<LoggedInUser>) result).getData();
            loginResult.setValue(new LoginResult(new LoggedInUserView(data.getDisplayName())));
        } else {
            loginResult.setValue(new LoginResult(R.string.login_failed));
        }
    }

    /**
     * 输入数据改变时，更新数据
     */
    public void loginDataChanged(String username, String password) {
        if (!isUserNameValid(username)) {
            loginFormState.setValue(new LoginFormState(R.string.invalid_username, null));
        } else if (!isPasswordValid(password)) {
            loginFormState.setValue(new LoginFormState(null, R.string.invalid_password));
        } else {
            loginFormState.setValue(new LoginFormState(true));
        }
    }


    /**
     * 校验用户名
     */
    private boolean isUserNameValid(String username) {
        if (username == null) {
            return false;
        }
        if (username.contains("@")) {
            return Patterns.EMAIL_ADDRESS.matcher(username).matches();
        } else {
            return !username.trim().isEmpty();
        }
    }

    /**
     * 校验密码
     */
    private boolean isPasswordValid(String password) {
        return password != null && password.trim().length() > 5;
    }
}