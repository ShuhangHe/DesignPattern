package com.cxx.designpattern.singleton;

import org.springframework.util.StringUtils;

/**
 * 单例模式 按照不同的方式来说，共有八种实现方式
 * 1、饿汉式（静态常量）
 * 2、饿汉式（静态代码块）
 *
 *
 *
 *
 *
 *
 */
public class Main {

    public static void main(String[] args) {
        // 测试单例模式饿汉式 类加载是什么时候
        System.out.println("I'm coming");
        Manager1 manager11 = Manager1.getInstance();
        System.out.println("game over");


        String  s = "123aaa";
        String result;
        result = s.replaceAll("[^(0-9)]", "");
        if (!(("".compareTo(result) == 0) == "".equals(result))){
            System.out.println(Integer.parseInt(result));
        }

        System.out.println(result.matches("^\\d+$"));

    }
}
