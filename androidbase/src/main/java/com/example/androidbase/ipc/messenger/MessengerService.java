package com.example.androidbase.ipc.messenger;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

import androidx.annotation.NonNull;

import com.lib.utils.Logger;

/**
 * @author huangguofeng
 */
public class MessengerService extends Service {
    public MessengerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Logger.logInfo("客户端调用服务器获取IBinder对象");
        /**
         * 返回服务端的Messenger对象的绑定类IMessenger
         */
        return messenger.getBinder();
    }


    public static final int MSG_FROM_CLIENT1 = 1;
    public static final int MSG_FROM_CLIENT2 = 2;
    /**
     * 服务器端的Messenger对象，持有本类handler对象
     */
    private Messenger messenger = new Messenger(new MessengerHandler());

    private static class MessengerHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            /**
             * 在客户端使用服务器端Messenger发送的消息会到达这里
             * 本质就是服务器端的Messenger发消息，服务器端Messenger持有的handler处理消息
             * 不过是客户端通过绑定服务，获取服务器端的Messenger对象，在客户端操作务器端的Messenger对象发送消息而已
             */
            Logger.logInfo("服务器收到客户端消息标记：" + msg.what);
            Logger.logInfo("服务器收到客户端消息msg：" + msg.getData().getString("clientMsg"));
            Logger.logInfo("服务器收到客户端消息handler：" + msg.getTarget());
            /**
             * 关键步骤：从消息中取出保存于消息内的客户端的Messenger对象
             */
            Messenger clientMessenger = msg.replyTo;
            // 重新创建一个消息 指定what
            Message message;
            // 创建服务器准备返回给客户端的bundle数据
            Bundle bundle = new Bundle();
            if (msg.what == MSG_FROM_CLIENT1) {
                message = Message.obtain(null, 11);
                bundle.putString("serviceMsg", "我是服务器返回的消息11");
                // 给消息设置bundle数据
                message.setData(bundle);
                // 尝试使用客户端Messenger发送消息
                try {
                    /**
                     * 服务器端操作客户端的Messenger对象，发送消息
                     */
                    clientMessenger.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            if (msg.what == MSG_FROM_CLIENT2) {
                message = Message.obtain(null, 22);
                bundle.putString("serviceMsg", "我是服务器返回的消息22");
                // 给消息设置bundle数据
                message.setData(bundle);
                // 尝试使用客户端Messenger发送消息
                try {
                    clientMessenger.send(message);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}