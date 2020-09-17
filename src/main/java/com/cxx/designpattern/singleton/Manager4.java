package com.cxx.designpattern.singleton;

/**
 * 懒汉式（方法加锁）
 * 通过锁的方式解决了多线程时候的并发问题，但是效率也相对应的有所降低
 *
 */
public class Manager4 {

    /**
     * 没有加final是因为，final必须得初始化
     * 初始化的方式有两种 一种是直接初始化
     * 一种是通过静态代码块初始化
     */
    public static Manager4 INSTANCE;

    /**
     * 构造方法私有化，防止外部NEW
     */
    private Manager4(){
    }

    /**
     * 按需初始化
     * static synchronized 锁住的是class的这个方法，而不是实例的这个方法
     * static 方法是属于整个类的。而不是单个实例的
     * @return
     */
    public static synchronized Manager4 getInstance(){
        if (INSTANCE == null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Manager4();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++){
            //同一个类的不同对象hashcode 是不同的
            //不同class的hashcode 可能相同
            new Thread(() -> System.out.println(Manager4.getInstance().hashCode())).start();
        }
    }
}
