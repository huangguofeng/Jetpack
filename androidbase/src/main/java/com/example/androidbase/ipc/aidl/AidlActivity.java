package com.example.androidbase.ipc.aidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidbase.R;
import com.lib.utils.Logger;

import java.util.List;
import java.util.Random;

/**
 * @author huangguofeng
 * aidl客户端
 */
public class AidlActivity extends AppCompatActivity {

    private Button msg11;
    private Button msg22;
    private BookManager bookManager;
    private List<Book> mBooks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
        msg11 = (Button) findViewById(R.id.msg11);
        msg22 = (Button) findViewById(R.id.msg22);

        msg11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mBooks = bookManager.getBooks();
                    for (Book b : mBooks) {
                        Logger.logInfo("getBooks: " + b.toString());
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });

        msg22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("android" + new Random().nextInt(10));
                book.setPrice(new Random().nextInt(99));
                try {
                    bookManager.addBook(book);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
        bind();
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
        Intent intent = new Intent(this, AidlService.class);
//        intent.setAction("com.example.androidbase.ipc.aidl");
//        intent.setPackage("com.example.androidbase");
        bindService(intent, connection, BIND_AUTO_CREATE);
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Logger.logInfo("onServiceConnected  aidl服务");
            bookManager = BookManager.Stub.asInterface(service);

            try {
                mBooks = bookManager.getBooks();
                for (Book b : mBooks) {
                    Logger.logInfo("getBooks: " + b.toString());
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Logger.logDebug("onServiceDisconnected  aidl服务");
        }
    };
}