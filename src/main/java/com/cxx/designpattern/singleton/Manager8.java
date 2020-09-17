package com.cxx.designpattern.singleton;

/**
 * 枚举单例
 * 不仅可以解决线程问题，还可以防止反序列化
 * 因为枚举类没有构造方法，所以可以防止序列化
 * 
 */
public enum Manager8 {

    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            //同一个类的不同对象hashcode 是不同的
            //不同class的hashcode 可能相同
            new Thread(() -> System.out.println(Manager8.INSTANCE.hashCode())).start();
        }
    }
}
