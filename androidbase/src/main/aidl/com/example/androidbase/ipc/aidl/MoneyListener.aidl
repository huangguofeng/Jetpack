// MoneyListener.aidl 作用是定义方法接口
// packgae属性：AS自动生成的MoneyListener.java的包名
package com.example.androidbase.ipc.aidl;
// 必须通过这种方式导入一个aidl的完整路径，在aidl中定义MoneyListener.aidl内部使用的实现序列化的实体类或者其他aidl文件中的接口
import com.example.androidbase.ipc.aidl.Card;

interface MoneyListener {
    // 基本数据类型中不支持short
    void callback(in BankCard card);
}