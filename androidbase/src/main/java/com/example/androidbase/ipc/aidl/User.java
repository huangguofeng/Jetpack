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

    /**
     * 参数是一个Parcel,用它来存储与传输数据
     * 当aidl接口参数tag属性为out或者inout时，必须创建该方法，代码内部和有参构造器一致
     * 因为aidl被编译成java文件后 代码中会调用该方法 但是该方法不存在 需要自己实现
     *
     * @param dest dest
     */
    public void readFromParcel(Parcel dest) {
        //注意，此处的读值顺序应当是和writeToParcel()方法中一致的
        name = dest.readString();
        card = dest.readParcelable(BankCard.class.getClassLoader());
    }
}
