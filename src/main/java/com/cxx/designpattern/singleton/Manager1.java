package com.cxx.designpattern.singleton;


/**
 * 饿汉式（静态常量）
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用！
 * 唯一缺点：不管有没有用到，在类装载的时候就完成实例化（基本不算是坑，你如果不用就不会类装载了）
 * 类装载在其他类引用他的时候就完成加载
 *
 *
 * 在这里扩展下java类装载的一些知识点<br/>
 * 一、类装载的三种方式
 *  1) 静态加载
 *      静态加载就是我们通常用的 Test test = new Test();
 *  2)动态加载（Class.forName()）
 *
 *  3)动态加载(getClassLoader().loadClass())
 *
 * TODO: 类装载的方式，顺序，static final 关键字的具体用法整理
 *
 */
public class Manager1 {

    public static final Manager1 INSTANCE = new Manager1();

    /**
     * 构造方法私有化，不让其他人new
     */
    private Manager1() {
        System.out.println("Manager1 class Loader");
        System.out.println(getClass().getName());
    }

    public static Manager1 getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) throws Exception{
//        System.out.println("I'm coming");
//        Manager1 manager11;
//        System.out.println("game over");
        Manager1 manager1 = Manager1.getInstance();
        Manager1 manager2 = Manager1.getInstance();
        // 通过 == 比较
        System.out.println(manager1 == manager2);
    }

}
