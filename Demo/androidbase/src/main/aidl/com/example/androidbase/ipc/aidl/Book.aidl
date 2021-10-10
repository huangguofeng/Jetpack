// Book.aidl 第一类AIDL 被其他aidl文件使用的
// 这个文件的作用是引入了一个序列化对象 Book 供其他的AIDL文件使用
// 注意：该aidl文件和目标序列化实体类java文件的包名应当是一样的
package com.example.androidbase.ipc.aidl;

// Declare any non-default types here with import statements
// 注意parcelable是小写 该路径下是类名
parcelable Book;
// package和parcelable共同构成目标实体类的完整类路径