// MoneyService.aidl 作用是定义方法接口
// packgae属性：AS自动生成的MoneyService.java的包名
package com.example.androidbase.ipc.aidl;
// 必须通过这种方式导入一个aidl的完整路径，在aidl中定义MoneyService.aidl内部使用的实现序列化的实体类或者其他aidl文件中的接口
import com.example.androidbase.ipc.aidl.Card;
import com.example.androidbase.ipc.aidl.MoneyListener;

interface MoneyService {
    // 基本数据类型中不支持short
    void test(CharSequence a,String b,int c,long d,double e,boolean f,byte g,float i,char j);
    // 非基本类型需要声明数据流向tag：in out inout
    List testList(in List list);

    Map testMap(in Map map);

    void setListener(MoneyListener listener);

    User getUser(out BankCard card);

    void send(out BankCard card);
}