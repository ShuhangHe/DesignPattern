package com.cxx.designpattern.singleton;

/**
 * 懒汉式（锁代码块）
 * 这种方式虽然让效率有所提高，但是也会带来多线程并发时候的多个实例的问题
 */
public class Manager5 {

    /**
     * 没有加final是因为，final必须得初始化
     * 初始化的方式有两种 一种是直接初始化
     * 一种是通过静态代码块初始化
     */
    public static Manager5 INSTANCE;


    /**
     * 构造方法私有化，防止外部NEW
     */
    private Manager5(){
    }

    /**
     * 按需初始化
     * static synchronized 锁住方法中的某一个代码块，而不是整个方法
     * static 方法是属于整个类的。而不是单个实例的
     * @return
     */
    public static Manager5 getInstance(){
        if (INSTANCE == null){
            synchronized (Manager5.class) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                INSTANCE = new Manager5();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++){
            //同一个类的不同对象hashcode 是不同的
            //不同class的hashcode 可能相同
            new Thread(() -> System.out.println(Manager5.getInstance().hashCode())).start();
        }
    }
}
