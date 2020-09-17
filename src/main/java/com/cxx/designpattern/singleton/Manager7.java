package com.cxx.designpattern.singleton;

/**
 * 静态内部类
 * JVM保证单例
 * 加载外部类时不会加载内部类。这样可以实现懒加载
 */
public class Manager7 {
    private Manager7(){}

    /**
     * Manager7 被加载的时候，Manager7Holder 是不会被加载的
     * 只有当调用getInstance的时候才会对Manager7Holder加载
     */
    private static class Manager7Holder {
        public static final Manager7 INSTANCE = new Manager7();
    }

    public static Manager7 getInstance(){
        return Manager7Holder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            //同一个类的不同对象hashcode 是不同的
            //不同class的hashcode 可能相同
            new Thread(() -> System.out.println(Manager7.getInstance().hashCode())).start();
        }
    }
}
