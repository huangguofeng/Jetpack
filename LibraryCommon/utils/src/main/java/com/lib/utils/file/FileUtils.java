package com.lib.utils.file;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import com.lib.utils.Logger;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

/**
 * @author :huangguofeng
 * date    :2021/1/11
 * package :com.lib.utils.file
 * desc    :文件读写
 */
public class FileUtils {
    private static final String TAG = "[FileUtils]: ";

    /**
     * 读取指定目录下指定文件
     * 参数强检测
     *
     * @param context  上下文
     * @param path     文件保存的路径，文件夹的路径
     * @param fileName 保存写入内容的文件名
     * @param callback 读取回调,允许null
     */
    public static synchronized String readContentFormFile(Context context, File path, String fileName, FileOperationStateCallback callback) {
        if (context == null || path == null || TextUtils.isEmpty(fileName)) {
            callback(callback, FileOperationStateCallback.ERROR_PARAM_NULL, TAG + "参数有空值或者null对象，即将返回null");
            return null;
        }

        // 定义文件内容字符串
        String content = null;
        // 文件输入流
        FileInputStream fileInputStream;

        /*
         * 文件输出操作
         * */
        try {
            File testFile = new File(path, fileName);
            // 打开文件输入流
            fileInputStream = new FileInputStream(testFile);
            // 将文件输入流存放在ByteArrayOutputStream
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            // 定义每次读取一个字节
            byte[] buffer = new byte[1024];
            // 定义每次读取的字节长度
            int len;
            // 读取文件输入流的内容，并存入ByteArrayOutputStream中
            while ((len = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            // 将文件输入流数据以字符串的形式存放
            content = outputStream.toString();
            // 关闭文件输入流
            fileInputStream.close();
            // 关闭ByteArrayOutputStream
            outputStream.close();
            callback(callback, FileOperationStateCallback.SUCCESS, null);
        } catch (FileNotFoundException e) {
            callback(callback, FileOperationStateCallback.ERROR_EXCEPTION_FILE_NOT_FOUND, e.getMessage());
            Logger.logError(TAG + "读取文件失败：" + e.getMessage(), e);
        } catch (IOException e) {
            callback(callback, FileOperationStateCallback.ERROR_EXCEPTION_IO, e.getMessage());
            Logger.logError(TAG + "读取文件失败：" + e.getMessage(), e);
        }

        // 返回文件内容
        return content;
    }

    /**
     * 写入内容到指定文件名，并且文件保存在指定目录下，需手动设置写入模式
     * 参数强检测
     *
     * @param context  上下文
     * @param path     文件保存的路径，文件夹的路径
     * @param content  要写入的内容
     * @param fileName 保存写入内容的文件名
     * @param model    写入模式：true追加，false覆盖
     * @param callback 写入回调，允许为null值
     */
    public static synchronized void writeContentToFile(Context context, File path, String content, String fileName, boolean model, FileOperationStateCallback callback) {
        if (context == null || path == null || TextUtils.isEmpty(content) || TextUtils.isEmpty(fileName)) {
            callback(callback, FileOperationStateCallback.ERROR_PARAM_NULL, TAG + "参数有空值或者null对象，即将返回null");
            return;
        }

        /*
         * 文件输出操作
         */
        File testFile = new File(path, fileName);
        // 初始化文件输出流
        FileOutputStream fileOutputStream;
        // 以追加模式打开文件输出流
        try {
            fileOutputStream = new FileOutputStream(testFile, model);
            fileOutputStream.write(content.getBytes());
            // 关闭文件输出流
            fileOutputStream.close();
            callback(callback, FileOperationStateCallback.SUCCESS, null);
        } catch (IOException e) {
            callback(callback, FileOperationStateCallback.ERROR_EXCEPTION_IO, e.getMessage());
            Logger.logError(TAG + "写入文件失败：" + e.getMessage(), e);
        }
    }

    /**
     * 保存内容到文件，目录可选：内存文件 内存缓存，外存缓存，外存文件
     *
     * @param context  上下文
     * @param pathType 要保存的文件目录
     * @param content  要写入的文件内容
     * @param fileName 保存写入内容的文件名
     * @param model    写入模式：true追加，false覆盖
     * @param type     外存专属参数：文件类型，可以为null,参考Environment
     */
    public static synchronized void writeContentToFile(Context context, PathType pathType, String content, String fileName, boolean model, String type) {
        // 获得内存文件目录
        File path = getPath(context, pathType, type);
        /*
         * 文件输出操作
         */
        File testFile = new File(path, fileName);
        // 初始化文件输出流
        FileOutputStream fileOutputStream;
        // 以追加模式打开文件输出流
        try {
            fileOutputStream = new FileOutputStream(testFile, model);
            fileOutputStream.write(content.getBytes());
            // 关闭文件输出流
            fileOutputStream.close();
        } catch (IOException e) {
            Logger.logError(TAG + "写入文件失败：" + e.getMessage(), e);
        }
    }

    /**
     * 从指定目录读取文件(只限于根目录)，目录可选：内存文件 内存缓存，外存缓存，外存文件
     *
     * @param fileName fileName
     * @return content
     */
    public static synchronized String readContentFromFile(Context context, PathType pathType, String fileName, String type) {
        // 定义文件内容字符串
        String content = null;
        // 文件输入流
        FileInputStream fileInputStream;
        // 获得外存文件目录
        File path = getPath(context, pathType, type);
        /*
         * 文件输出操作
         */
        try {
            File testFile = new File(path, fileName);
            // 打开文件输入流
            fileInputStream = new FileInputStream(testFile);
            // 将文件输入流存放在ByteArrayOutputStream
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            // 定义每次读取一个字节
            byte[] buffer = new byte[1024];
            // 定义每次读取的字节长度
            int len;
            // 读取文件输入流的内容，并存入ByteArrayOutputStream中
            while ((len = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            // 将文件输入流数据以字符串的形式存放
            content = outputStream.toString();
            // 关闭文件输入流
            fileInputStream.close();
            // 关闭ByteArrayOutputStream
            outputStream.close();
        } catch (IOException e) {
            Logger.logError(TAG + "读取文件失败：" + e.getMessage(), e);
        }

        // 返回文件内容
        return content;
    }

    public static synchronized void deleteFile(Context context, File file) {
        if (context != null && file != null) {
            file.delete();
        }
    }

    private static File getPath(Context context, PathType pathType, String type) {
        File file = null;
        switch (pathType) {
            case MemoryFile:
                file = getFilesDir(context);
                break;
            case MemoryCacheFile:
                file = getCacheDir(context);
                break;
            case ExternalFile:
                file = getExternalFilesDir(context, type);
                break;
            case ExternalCacheFile:
                file = getExternalCacheDir(context);
                break;
            default:
                break;
        }
        return file;

    }

    /**
     * 统一处理回调和信息
     */
    private static void callback(FileOperationStateCallback callback, int errorCode, String msg) {
        if (callback != null) {
            if (!TextUtils.isEmpty(msg) || (errorCode != 0)) {
                callback.error(errorCode, msg);
            } else {
                callback.finish();
            }
        }
    }

    /**
     * 获取内存持久性空间目录 /data/user/0/packageName/files
     *
     * @param context 上下文
     * @return File:内存文件目录
     */
    public static File getFilesDir(Context context) {
        return context.getFilesDir();
    }

    /**
     * 获取内存缓存空间目录 /data/user/0/packageName/cache
     *
     * @param context 上下文
     * @return File:内存缓存目录
     */
    public static File getCacheDir(Context context) {
        return context.getCacheDir();
    }

    /**
     * 获取外存持久性空间目录 /storage/emulated/0/Android/data/packageName/files
     *
     * @param context   上下文
     * @param type:文件类型 null Environment.DIRECTORY_PICTURES,Environment.DIRECTORY_DOCUMENTS ...
     * @return File:外存文件目录
     */
    public static File getExternalFilesDir(Context context, String type) {
        return context.getExternalFilesDir(type);
    }

    /**
     * 获取外存缓存空间目录 /storage/emulated/0/Android/data/packageName/cache
     *
     * @param context 上下文
     * @return File:外存缓存目录
     */
    public static File getExternalCacheDir(Context context) {
        return context.getExternalCacheDir();
    }

    /**
     * 如果结果为true，则可以在外部储存上读写应用专属目录文件
     */
    public static boolean isExternalStorageWritable() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 如果结果为true，则可以在外部储存上读取应用专属目录文件，不一定能写入
     */
    public static boolean isExternalStorageReadable() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED) || Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED_READ_ONLY);
    }

    /**
     * 如果除了外存以外还存在sd卡槽时，会有多个外存卷，第一个就是主外存卷，首选第一个除非它满了
     */
    public static File getMainExternalStorage(Context context) {
        File[] externalStorageVolumes = ContextCompat.getExternalFilesDirs(context.getApplicationContext(), null);
        for (File f : externalStorageVolumes) {
            Logger.logDebug(TAG + "获取外存储存卷：" + f.getAbsolutePath());
        }
        return externalStorageVolumes[0];
    }

    /**
     * 如果除了外存以外还存在sd卡槽时，会有多个外存卷，首选第一个除非它满了
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public static long queryAvailableSize(Context context) {

        StorageManager storageManager = context.getApplicationContext().getSystemService(StorageManager.class);
        UUID appSpecificInternalDirUuid = null;
        long availableBytes = 0;
        try {
            appSpecificInternalDirUuid = storageManager.getUuidForPath(getFilesDir(context));
            availableBytes = storageManager.getAllocatableBytes(appSpecificInternalDirUuid);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return availableBytes;
    }

    public interface FileOperationStateCallback {
        int SUCCESS = 0;
        int ERROR_PARAM_NULL = 1;
        int ERROR_EXCEPTION_FILE_NOT_FOUND = 2;
        int ERROR_EXCEPTION_IO = 3;

        /**
         * 文件操作是否已完成
         */
        void finish();

        /**
         * 文件操作出错
         *
         * @param errorCode 错误码
         * @param msg       错误信息
         */
        void error(int errorCode, String msg);
    }

    /**
     * 文件目录选择
     */
    public enum PathType {
        /**
         * 内存文件目录
         */
        MemoryFile,
        /**
         * 内存缓存目录
         */
        MemoryCacheFile,
        /**
         * 外存文件目录
         */
        ExternalFile,
        /**
         * 外存缓存目录
         */
        ExternalCacheFile;
    }
}
