package com.example.androidbase.ipc.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

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
 * aidl服务端
 */
public class BankService extends Service {
    private List linkedList = new LinkedList();
    private List arrayList = new ArrayList();
    private Map hashMap = new HashMap();
    private Map linkedHashMap = new LinkedHashMap();
    private Map hashtable = new Hashtable();
    private Map treeMap = new TreeMap();

    public BankService() {
    }

    int count = 0;
    BankCard bankCard = new BankCard();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            while (count < 20) {
                count++;
                bankCard.setBalance(count);
                if (moneyListener != null) {
                    try {
                        moneyListener.callback(bankCard);
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        Logger.logError("moneyListener callback异常");
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    Logger.logError("线程睡眠异常");
                }
            }
        }
    };
    private Thread thread = new Thread(runnable);

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Logger.logInfo("绑定 BankService");
        return stub.asBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.logInfo("创建 BankService");
//        thread.start();
    }

    private final MoneyService.Stub stub = new MoneyService.Stub() {
        @Override
        public void test(CharSequence a, String b, int c, long d, double e, boolean f, byte g, float i, char j) throws RemoteException {
            Logger.logInfo("test：" + a + " " + b + " " + c + " " + d + " " + e + " " + f + " " + g + " " + i + " " + j);
        }

        @Override
        public List testList(List list) throws RemoteException {
            Logger.logInfo("testList：" + list);
            if (list != null) {
                Logger.logInfo(list.size() + "");
            }
            return arrayList;
        }

        @Override
        public Map testMap(Map map) throws RemoteException {
            Logger.logInfo("testMap：" + map);
            if (map != null) {
                Logger.logInfo(map.size() + "");
            }
            return hashtable;
        }

        @Override
        public void setListener(MoneyListener listener) throws RemoteException {
            Logger.logInfo("setListener：" + listener);
            if (listener != null) {
                Logger.logInfo("服务器端保存客户端回调接口对象");
                moneyListener = listener;
            }
        }

        @Override
        public User getUser(BankCard card) throws RemoteException {
            Logger.logInfo("getUser：" + card);
            Logger.logInfo("查看服务器bankCard：" + bankCard);
            User user = new User();
            user.setName("User" + card.getBalance());
            card.setBalance(card.getBalance() + 1);
            user.setCard(card);
            return user;
        }

        @Override
        public void send(BankCard card) throws RemoteException {
            Logger.logInfo("send：" + card);
            Logger.logInfo("send：" + bankCard);
            
            if (moneyListener != null) {
                moneyListener.callback(bankCard);
            }
        }
    };

    private MoneyListener moneyListener;

}