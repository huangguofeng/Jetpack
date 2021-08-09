package com.example.androidbase.ipc;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

import com.lib.utils.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author :huangguofeng
 * date    :2021/8/9
 * package :com.example.androidbase.ipc
 * desc    :
 */
public class SocketHelper {
    private static final String TAG = "SocketHelper";
    // 监听的端口号
    public static final int SERVER_PORT = 5556;
    // 间隔时间
    public static final int RETRY_TIME_INTERVAL = 5000;
    // 重试次数
    private int tryTimes;
    // 线程池
    private ExecutorService service = Executors.newFixedThreadPool(4);
    // 自增做标记使用
    private AtomicInteger atomicInteger = new AtomicInteger(1);

    //==========================以下是socket客户端代码=======================================
    private Socket mSocket;
    private PrintWriter mWrite;

    private boolean isClientRunning;

    private ClientCallback clientCallback;

    public void setClientCallback(ClientCallback clientCallback) {
        this.clientCallback = clientCallback;
    }

    public interface ClientCallback {
        void onReceive(String msg);
    }

    /**
     * 向服务端发送消息
     *
     * @param msg
     */
    public void sendMsg2Server(final String msg) {
        if (mWrite != null && isClientRunning) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    mWrite.println(msg);
                }
            });
        }
    }

    /**
     * 启动客户端，连接服务端，第一次可能服务端没有启动好，连接失败，后面会自动重连
     */
    public void startClient() {
        isClientRunning = true;

        service.execute(new Runnable() {
            @Override
            public void run() {
                while (mSocket == null) {
                    try {
                        mSocket = new Socket("localhost", SERVER_PORT);
                        mWrite = new PrintWriter(new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream())),
                                true);
                        Logger.logDebug(TAG, "localhost port:" + SERVER_PORT + " connect success");
                    } catch (Exception e) {
                        // 记录连接失败次数
                        tryTimes++;
                        Logger.logDebug(TAG, "localhost port:" + SERVER_PORT + " connect fail tryTimes :" + tryTimes);
                        // 连接失败，等待时间依次递增
                        SystemClock.sleep(RETRY_TIME_INTERVAL * tryTimes);
                    }
                }

                // 连接成功，重置连接次数
                tryTimes = 0;

                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
                    while (isClientRunning) {
                        // 读取服务端发送来的消息
                        final String msg = reader.readLine();
                        Logger.logDebug(TAG, "msg from server " + msg);
                        if (clientCallback != null) {

                            // 切换主线程
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                @Override
                                public void run() {
                                    clientCallback.onReceive(msg);
                                }
                            });
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 客户端端口连接，回收资源
     */
    public void onClientDestroy() {
        Logger.logDebug(TAG, "onClientDestroy");
        isClientRunning = false;
        if (mSocket != null) {
            try {
                mSocket.shutdownInput();
                mSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //===================================以下是socket服务端代码======================================

    /**
     * 服务端是否在运行
     */
    private boolean mIsServerRunning;

    /**
     * 开启服务端监听
     */
    public void startServer() {
        mIsServerRunning = true;

        service.execute(new Runnable() {
            @Override
            public void run() {
                ServerSocket serverSocket = null;
                try {
                    Logger.logDebug(TAG, "service start listen localhost prot :" + SocketHelper.SERVER_PORT);
                    // 监听本地接口
                    serverSocket = new ServerSocket(SocketHelper.SERVER_PORT);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 服务端在运行，不断的接收客户端发来的消息，并做回应
                while (mIsServerRunning) {
                    try {
                        // 接收客户端请求
                        if (serverSocket != null) {
                            final Socket socket = serverSocket.accept();
                            Logger.logDebug(TAG, "accept");
                            service.execute(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        responseClient(socket);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     * 回应客户端消息
     *
     * @param socket
     * @throws IOException
     */
    private void responseClient(Socket socket) throws IOException {
        Logger.logDebug(TAG, "responseClient");
        // 接收客户端消息
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        // 向客户端发送消息
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        while (mIsServerRunning) {
            // 读取客户端发来的消息
            String str = in.readLine();
            // 判断客户端断开连接的方法很多，这里用输入流是否为null判断
            if (str == null) {
                break;
            }
            Logger.logDebug(TAG, "msg from client: " + str);

            int index = atomicInteger.getAndIncrement();

            // 服务端给客户端发送消息
            out.println("response: " + index + " ,request:" + str);
        }
        Logger.logDebug(TAG, "client logout");
        out.close();
        in.close();
        socket.close();
    }

    /**
     * 服务端断开回收资源
     */
    public void onServerDestroy() {
        Logger.logDebug(TAG, "onServerDestroy");
        mIsServerRunning = false;
    }

}
