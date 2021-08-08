// Card.aidl 第一类AIDL 被其他aidl文件引用的 本AIDL文件名不需要与目标实体类名相同，不然同时引入多个实体类怎么办呢
// 当前文件的作用是引入了一个序列化对象 BankCard
// 需要的序列化对象java类的包名
package com.example.androidbase.ipc.aidl;

// 需要的序列化对象java类的类名 注意parcelable是小写
parcelable BankCard;
parcelable User;

// package + parcelable = com.example.androidbase.ipc.aidl.BankCard ：目标序列化类的完整路径