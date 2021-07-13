package com.hgf.jetpack.ui.fragment.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */

/**
 * @author :huangguofeng
 * date    :2020/7/3
 * package :com.hgf.jetpack.ui.fragment.data
 * desc    :用户实体信息，用户唯一id和用户名
 */
public class LoggedInUser {

    private String userId;
    private String displayName;

    public LoggedInUser(String userId, String displayName) {
        this.userId = userId;
        this.displayName = displayName;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }
}