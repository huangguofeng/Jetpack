package com.example.androidbase.thread;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidbase.R;
import com.lib.utils.Logger;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author huangguofeng
 */
public class ThreadActivity extends AppCompatActivity {
    private Handler handler = new Handler(Looper.myLooper()) {
        @Override
        public void handleMessage(@NonNull Message msg) {
            Logger.logDebug(msg.what + "");
        }
    };

    private MyThread myThread = new MyThread();
    private MyThread myThread2;

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Logger.logInfo("自定义runnable run方法执行了");
        }
    };


    private Handler handlerThread;
    HandlerThread thread;
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
    ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
    ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
    ScheduledExecutorService singleThreadScheduledPool = Executors.newSingleThreadScheduledExecutor();

    ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 1,
            10L, TimeUnit.SECONDS, new LinkedBlockingDeque<>(5), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            thread.setName("test");
            return thread;
        }
    });

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        Logger.logInfo("手机的核心数：" + CPU_COUNT);
        myThread2 = new MyThread(runnable);
        findViewById(R.id.msg1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                send();
                myThread.start();
            }
        });

        findViewById(R.id.msg2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                sendDelay();
                myThread2.run();
            }
        });

        //
        thread = new HandlerThread("test");
        thread.start();
        handlerThread = new Handler(thread.getLooper(), new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {
                Logger.logInfo("自定义HandlerThread handleMessage方法执行了: " + msg.what);
                return true;
            }
        });

        handlerThread.sendEmptyMessage(0);

        findViewById(R.id.msg2).post(new Runnable() {
            @Override
            public void run() {
                Logger.logInfo("View.post方法执行完成了");
            }
        });

        fixedThreadPool.execute(runnable);
        singleThreadPool.execute(runnable);
        cachedThreadPool.execute(runnable);
    }

    private void sendDelay() {
        Logger.logDebug(Looper.myLooper() + "");
        Logger.logDebug(Looper.getMainLooper() + "");
        Message message = Message.obtain();
        message.what = 1;
        message.obj = "sendDelay";
        handler.sendMessageDelayed(message, 3000);
    }

    private void send() {
        Logger.logDebug(Looper.myLooper() + "");
        Logger.logDebug(Looper.getMainLooper() + "");
        Message message = Message.obtain();
        message.what = 0;
        message.obj = "send";
        handler.sendMessage(message);
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 移除回调和消息 避免内存泄露
        handler.removeCallbacksAndMessages(null);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onGetMessage(MessageWrap message) {
        Toast.makeText(this, message.message, Toast.LENGTH_SHORT);
    }
}