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
}
