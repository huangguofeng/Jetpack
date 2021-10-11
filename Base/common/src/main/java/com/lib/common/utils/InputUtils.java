package com.lib.common.utils;

import android.content.Context;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.lib.utils.Logger;

public class InputUtils {
    private static InputUtils utils;

    private InputUtils() {
    }

    public static synchronized InputUtils getUtils(String... strings) {
        if (utils == null) {
            synchronized (InputUtils.class) {
                if (utils == null) {
                    utils = new InputUtils();
                }
            }
        }
        return utils;
    }

    public boolean onKey(EditText editText, KeyEvent event, int keyCode) {
//        Logger.logInfo("键盘事件："+keyCode+"  event: "+event.getAction());
        if (keyCode == KeyEvent.KEYCODE_DEL && event.getAction() == KeyEvent.ACTION_DOWN) {
            //获取当前editText中的内容
            String text = editText.getText().toString();
            //判断text中是否有内容
            if (0 < text.length()) {
                //判断text中是否只有一个字符
                if (0 == text.length() - 1) {
                    //如果只有一个则直接令editText为""，即none
                    editText.setText("");
                    //将焦点置于第0位，即最开始
                    editText.setSelection(0);
                } else {
                    //否则删除该字段的最后一个字符并将删除后的结果赋予newText
                    String newText = text.substring(0, text.length() - 1);
                    //显示newText中的内容
                    editText.setText(newText);
                    //设置焦点在该字段最后
                    editText.setSelection(newText.length());
                }
            }
            return true;
        }
        return false;
    }

    public void closeSoftInput(Context context, EditText editText) {
        if (context == null || editText == null) {
            Logger.logError("context editText都不可以为null");
        }
        InputMethodManager manager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (manager.isActive()) {
            manager.hideSoftInputFromWindow(editText.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
