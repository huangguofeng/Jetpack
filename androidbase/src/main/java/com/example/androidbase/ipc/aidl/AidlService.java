package com.example.androidbase.ipc.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.lib.utils.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangguofeng
 * aidl服务端
 */
public class AidlService extends Service {
    private List<Book> books = new ArrayList<>();

    public AidlService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Logger.logInfo("AidlService  onCreate");
        Book book = new Book();
        book.setName("android");
        book.setPrice(66);
        books.add(book);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Logger.logInfo("AidlService  onBind");
        return bookManager.asBinder();
    }

    private final BookManager.Stub bookManager = new BookManager.Stub() {
        @Override
        public List<Book> getBooks() throws RemoteException {
            synchronized (this) {
                if (books == null) {
                    books = new ArrayList<>();
                }
            }
            return books;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            synchronized (this) {
                if (books == null) {
                    books = new ArrayList<>();
                }
                if (book == null) {
                    Logger.logError("addBook : book is null");
                    book = new Book();
                    book.setPrice(999);
                    book.setName("默认:" + book.getPrice());
                }
                Logger.logDebug(book.toString());
                if (!books.contains(book)) {
                    books.add(book);
                }

            }
        }
    };
}