package com.lib.utils.encode;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author :huangguofeng
 * date    :2021/1/11
 * package :com.lib.utils.encode
 * desc    :编解码工具
 */
public class EncodeUtils {
    private static final String TAG = "[EncodeUtils]: ";
    private final static String[] HEX_DIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String getMd5Str(String str) {
        if (str == null) {
            return null;
        }
        byte[] digest = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            digest = md5.digest(str.getBytes(StandardCharsets.UTF_8));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        //16是表示转换为16进制数
        return new BigInteger(1, digest).toString(16);
    }

    /**
     * MD5加密
     *
     * @param origin 要加密的字符串
     * @return md5加密结果
     */
    public static String md5Encryption(String origin) {
        if (origin == null) {
            return null;
        }
        String resultString = null;
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        if (md != null) {
            resultString = byteArrayToHexString(md.digest(origin.getBytes()));
        }
        return resultString;
    }

    /**
     * 字符转十六进制
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuilder resultSb = new StringBuilder();
        for (byte value : b) {
            resultSb.append(byteToHexString(value));
        }
        return resultSb.toString();
    }

    /**
     * 转换十六进制实际操作
     */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return HEX_DIGITS[d1] + HEX_DIGITS[d2];
    }
}
