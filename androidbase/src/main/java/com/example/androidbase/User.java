package com.example.androidbase;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author :huangguofeng
 * date    :2021/7/29
 * package :com.example.androidbase
 * desc    :
 */
public class User implements Parcelable {
    private String name;
    private int age;
    private transient long time;

    protected User(Parcel in) {
        name = in.readString();
        age = in.readInt();
    }


    User(String n, int a) {
        name = n;
        age = a;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
    }


}
