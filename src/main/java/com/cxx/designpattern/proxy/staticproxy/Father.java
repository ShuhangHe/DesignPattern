package com.cxx.designpattern.proxy.staticproxy;

import com.cxx.designpattern.proxy.Person;

public class Father implements Person {

    private Person person;

    public Father(Person person) {
        this.person = person;
    }

    @Override
    public void findLove() {
        System.out.println("《================父亲开始物色对象====================》");
        System.out.println("《================儿子提出自己的请求====================》");
        person.findLove();
        System.out.println("《====================父亲帮孩子找到了合适的对象============================》");
    }
}
