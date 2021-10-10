package com.hgf.jetpack.ui.fragment.ui.login;

import androidx.annotation.Nullable;

/**
 * Data validation state of the login form.
 */

/**
 * @author :huangguofeng
 * date    :2020/7/3
 * package :com.hgf.jetpack.ui.fragment.ui.login
 * desc    :用户输入信息完成后，自动进行的数据验证，要么信息有效，要么部分信息错误
 */
class LoginFormState {
    @Nullable
    private Integer usernameError;
    @Nullable
    private Integer passwordError;
    private boolean isDataValid;

    LoginFormState(@Nullable Integer usernameError, @Nullable Integer passwordError) {
        this.usernameError = usernameError;
        this.passwordError = passwordError;
        this.isDataValid = false;
    }

    LoginFormState(boolean isDataValid) {
        this.usernameError = null;
        this.passwordError = null;
        this.isDataValid = isDataValid;
    }

    @Nullable
    Integer getUsernameError() {
        return usernameError;
    }

    @Nullable
    Integer getPasswordError() {
        return passwordError;
    }

    boolean isDataValid() {
        return isDataValid;
    }
}