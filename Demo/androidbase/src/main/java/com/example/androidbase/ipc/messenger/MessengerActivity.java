package com.example.androidbase.ipc.messenger;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.androidbase.R;
import com.lib.utils.Logger;

/**
 * @author huangguofeng
 */
public class MessengerActivity extends AppCompatActivity {
    Button button1;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);
        button1 = findViewById(R.id.send11);
        button2 = findViewById(R.id.send22);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message = Message.obtain(null, 1);
                Bundle bundle = new Bundle();
                bundle.putString("clientMsg", "客户端发送给服务器的消息1");
                message.setData(bundle);
                message.replyTo = clientMessenger;
                try {
                    serverMessenger.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Message message = Message.obtain(null, 2);
                Bundle bundle = new Bundle();
                bundle.putString("clientMsg", "客户端发送给服务器的消息2");
                message.setData(bundle);
                message.replyTo = clientMessenger;
                try {
                    serverMessenger.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        /**
         * 绑定服务
         */
        Intent intent = new Intent(this, MessengerService.class);
        bindService(intent, connection, BIND_AUTO_CREATE);
    }

    /**
     * 创建handler对象，接受来自服务器端返回的消息
     * 本质还是客户端自己发消息，自己处理消息
     * 只是客户度发给服务器端的消息，携带了客户端的Messenger对象，然后服务器端在自己那操作客户端的Messenger对象而已
     */
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            Logger.logInfo("服务器返回到客户端的消息：" + msg.getData().getString("serviceMsg"));
        }
    };

    /**
     * 客户端的Messenger 使用客户端的handler作为参数
     */
    private Messenger clientMessenger = new Messenger(handler);

    /**
     * 服务端的Messenger
     */
    private Messenger serverMessenger;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Logger.logInfo("客户端和服务器:onServiceConnected");
            /**
             * 客户端通过binder服务获取服务端的Messenger对象的IBinder绑定类，用于在客户端实例化服务器端的Messenger对象serverMessenger
             */
            serverMessenger = new Messenger(service);
            /**
             * 创建消息，并设置要传递的数据
             */
            Message message = Message.obtain(null, 0);
            Bundle bundle = new Bundle();
            bundle.putString("clientMsg", "客户端和服务器链接起来了");
            message.setData(bundle);
            /**
             * 关键步骤：把客户端的clientMessenger对象保存到消息对象里，传递给服务器，这样服务器就可以操纵客户端的clientMessenger对象了
             */
            message.replyTo = clientMessenger;
            try {
                /**
                 * 使用服务器Messenger对象发送消息
                 */
                serverMessenger.send(message);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Logger.logInfo("客户端和服务器:onServiceDisconnected");
        }
    };

    @Override
    protected void onDestroy() {
        unbindService(connection);
        super.onDestroy();
    }
}