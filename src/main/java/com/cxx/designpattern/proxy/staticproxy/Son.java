package com.cxx.designpattern.proxy.staticproxy;

import com.cxx.designpattern.proxy.Person;

public class Son implements Person {
    @Override
    public void findLove() {
        System.out.println("《=================儿子的要求：大长腿！！！===============》");
    }
}
