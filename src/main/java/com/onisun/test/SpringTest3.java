package com.onisun.test;

import com.onisun.entity.Person;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Neo
 * @version 1.0
 */
public class SpringTest3 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc2.xml");

        Person person = context.getBean("person4", Person.class);
        System.out.println(person);
    }
}
