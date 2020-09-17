package com.cxx.designpattern.singleton;

/**
 * lazy loading
 * 懒汉式（什么时候用，什么时候初始化）
 * 虽然达到了按需初始化的目的，但是也带来了多线程访问时，可能会创建多个实例，不符合单例模式的原则
 */
public class Manager3 {

    /**
     * 没有加final是因为，final必须得初始化
     * 初始化的方式有两种 一种是直接初始化
     * 一种是通过静态代码块初始化
     */
    public static Manager3 INSTANCE;

    /**
     * 构造方法私有化，防止外部NEW
     */
    private Manager3(){
    }

    /**
     * 按需初始化
     * @return
     */
    public static Manager3 getInstance(){
        // 如果一个线程在判断INSTANCE == null 为true 他会进入if语句内，新建一个实例
        // 在这个现成刚进入判断还没有新建实例前，又有一个线程判断，这时 结果还是true，则这个线程也会新建实例
        if (INSTANCE == null){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Manager3();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++){
            //同一个类的不同对象hashcode 是不同的
            //不同class的hashcode 可能相同
            new Thread(() -> System.out.println(Manager3.getInstance().hashCode())).start();
        }
    }
}
