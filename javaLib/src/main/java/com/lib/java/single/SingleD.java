package com.lib.java.single;

/**
 * @author :huangguofeng
 * date    :2021/7/17
 * package :com.lib.java.single
 * desc    :静态内部类单例模式
 * 优点是：外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化INSTANCE，故而不占内存
 * 假设两个线程同时调用，由于synchronized锁定，只有一个进去方法体，一个等待锁释放，
 * 其中一个进去后实例化对象执行完毕，另外一个进去后会再次判断null，避免二次实例化对象
 */
public class SingleD {
    private SingleD(){

    }
    public static SingleD getInstance() {
        return SingleHolder.singleD;
    }

    /**
     * SingleD第一次被加载时，并不需要去加载SingleHolder，只有当getInstance()方法第一次被调用时，才会去初始化singleD,
     * 第一次调用getInstance()方法会导致虚拟机加载SingleHolder类，这种方法不仅能确保线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化
     * 静态内部类也有着一个致命的缺点，就是传参的问题，由于是静态内部类的形式去创建单例的，故外部无法传递参数进去，例如Context这种参数，
     * 所以，我们创建单例时，可以在静态内部类与DCL(加锁双重判空问题)模式里自己斟酌。
     */
    private static class SingleHolder{
        private static SingleD singleD = new SingleD();
    }

    public void print(String s){
        System.out.println("SingleD: "+s);
    }
}
