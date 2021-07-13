package com.hgf.jetpack.ui.fragment.data;

import com.hgf.jetpack.ui.fragment.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */

/**
 * @author :huangguofeng
 * date    :2020/7/3
 * package :com.hgf.jetpack.ui.fragment.data
 * desc    :处理带登录凭据的身份验证并检索用户信息
 */
public class LoginDataSource {

    /**
     * 实际登录的操作，请求服务器验证后返回结果
     */
    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    /**
     * 退出登录
     */
    public void logout() {
        // TODO: revoke authentication
    }
}