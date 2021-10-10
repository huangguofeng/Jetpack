package com.hgf.jetpack.ui.fragment.ui.login;

/**
 * Class exposing authenticated user details to the UI.
 */

/**
 * @author :huangguofeng
 * date    :2020/7/3
 * package :com.hgf.jetpack.ui.fragment.ui.login
 * desc    :用于展示的验证的用户，TODO:使用之处可以用loggedInUser代替
 */
class LoggedInUserView {
    private String displayName;
    //... other data fields that may be accessible to the UI

    LoggedInUserView(String displayName) {
        this.displayName = displayName;
    }

    String getDisplayName() {
        return displayName;
    }
}