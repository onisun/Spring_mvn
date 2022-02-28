package com.onisun.test;

import com.onisun.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Neo
 * @version 1.0
 */
public class StringTest01 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
    }
}
