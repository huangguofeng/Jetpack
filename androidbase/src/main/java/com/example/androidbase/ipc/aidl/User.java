package com.example.androidbase.ipc.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author :huangguofeng
 * date    :2021/8/8
 * package :com.example.androidbase.ipc.aidl
 * desc    :
 */
public class User implements Parcelable {
    private String name;
    private BankCard card;


    protected User(Parcel in) {
        name = in.readString();
        card = in.readParcelable(BankCard.class.getClassLoader());
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BankCard getCard() {
        return card;
    }

    public void setCard(BankCard card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", card=" + card +
                '}';
    }

    public User() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeParcelable(card, flags);
    }
}
