package com.cxx.designpattern.singleton;

/**
 * 饿汉式（静态代码块）
 * 感觉和静态变量的没啥区别
 */
public class Manager2 {

    public static final Manager2 INSTANCE;

    static {
        INSTANCE = new Manager2();
    }

    /**
     * 构造方法私有化
     */
    private Manager2(){

    }

    public static Manager2 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        Manager2 manager2 = Manager2.getInstance();
        Manager2 manager22 = Manager2.getInstance();
        System.out.println(manager2 == manager22);
    }
}
