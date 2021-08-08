package com.example.androidbase.ipc.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author :huangguofeng
 * date    :2021/8/8
 * package :com.example.androidbase.ipc.aidl
 * desc    :
 */
public class BankCard implements Parcelable {
    private int balance;

    public BankCard() {

    }

    protected BankCard(Parcel in) {
        balance = in.readInt();
    }

    public static final Creator<BankCard> CREATOR = new Creator<BankCard>() {
        @Override
        public BankCard createFromParcel(Parcel in) {
            return new BankCard(in);
        }

        @Override
        public BankCard[] newArray(int size) {
            return new BankCard[size];
        }
    };

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BankCard{" +
                "balance=" + balance +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(balance);
    }

    /**
     * 参数是一个Parcel,用它来存储与传输数据
     * 当aidl接口参数tag属性为out或者inout时，必须创建该方法，代码内部和有参构造器一致
     * 因为aidl被编译成java文件后 代码中会调用该方法 但是该方法不存在 需要自己实现
     *
     * @param dest dest
     */
    public void readFromParcel(Parcel dest) {
        //注意，此处的读值顺序应当是和writeToParcel()方法中一致的
        balance = dest.readInt();
    }
}
