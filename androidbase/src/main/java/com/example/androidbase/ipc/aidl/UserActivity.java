package com.example.androidbase.ipc.aidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidbase.R;
import com.lib.utils.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author huangguofeng
 * aidl客户端
 */
public class UserActivity extends AppCompatActivity {

    private MoneyService moneyService;
    private MoneyListener moneyListener = new MoneyListener.Stub() {
        @Override
        public void callback(BankCard card) throws RemoteException {
            Logger.logInfo("服务器通过监听类返回的数据：" + card);
            if (card != null) {
                textView.setText("服务器通过监听类返回的数据：" + card.getBalance());
            }
        }
    };
    private List linkedList = new LinkedList();
    private List arrayList = new ArrayList();
    private Map hashMap = new HashMap();
    private Map linkedHashMap = new LinkedHashMap();
    private Map hashtable = new Hashtable();
    private Map treeMap = new TreeMap();
    private User user = new User();
    private BankCard bankCard = new BankCard();

    private Button bind;
    private Button set;
    private Button get;
    private Button call;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl2);
        bind = (Button) findViewById(R.id.bind);
        set = (Button) findViewById(R.id.set);
        get = (Button) findViewById(R.id.get);
        call = (Button) findViewById(R.id.call);
        textView = (TextView) findViewById(R.id.show);

        bankCard.setBalance(-1);
        user.setName("默认人名");
        user.setCard(bankCard);

        bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testList();
                testMap();
            }
        });

        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logger.logInfo("准备设置监听");
                try {
                    moneyService.setListener(moneyListener);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUser();
            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    moneyService.send(bankCard);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        bind();
    }

    private void testList() {
        List list;
        try {
            list = moneyService.testList(arrayList);
            Logger.logDebug("测试List：" + list.size());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void testMap() {
        Map map;
        try {
            map = moneyService.testMap(hashMap);
            Logger.logDebug("测试Map：" + map.size());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    private void getUser() {
        BankCard card = bankCard;
        User user;
        Logger.logDebug("测试getUser1：" + card.toString());
        Logger.logDebug("测试getUser2：" + bankCard.toString());
        try {
            user = moneyService.getUser(card);
            Logger.logDebug("测试getUser3：" + user.getCard().toString());
            Logger.logDebug("测试getUser4：" + bankCard.toString());
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }

    private void bind() {
        Logger.logInfo("准备绑定服务");
        Intent intent = new Intent("com.example.androidbase.ipc.aidl.card");
        intent.setPackage("com.example.androidbase");
        bindService(intent, connection, BIND_AUTO_CREATE);
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // 打印service指针显示 跨进程为代理对象，同进程为Stub对象
            Logger.logInfo("绑定服务成功：" + service);
            moneyService = MoneyService.Stub.asInterface(service);
            byte[] bytes = "s".getBytes();
            try {
                moneyService.test(null, "string", 1, 2L, 3d, true, bytes[0], 4f, '5');
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Logger.logDebug("断开服务");
        }
    };
}