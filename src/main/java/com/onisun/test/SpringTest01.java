package com.onisun.test;

import com.onisun.entity.Address;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Neo
 * @version 1.0
 */
public class SpringTest01 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
//        Person person = applicationContext.getBean("person", Person.class);
//        Person person2 = applicationContext.getBean("person", Person.class);
//        System.out.println(person == person2);

        //通过Bean的类型获取对象
//        Person person3 = applicationContext.getBean(Person.class);
//        System.out.println(person3);

        //通过构造器给bean对象赋值
//        Person person2 = applicationContext.getBean("person2", Person.class);
//        System.out.println(person2);

        //通过命名空间为bean赋值
//        Person person3 = applicationContext.getBean("person3", Person.class);
//        System.out.println(person3);


//        Person person4 = applicationContext.getBean("person4", Person.class);
//        System.out.println(person4);

        //继承关系
//        Person person6 = applicationContext.getBean("person6", Person.class);
//        System.out.println(person6);


        //静态工厂的使用
//        Person person9 = applicationContext.getBean("person9", Person.class);
//        System.out.println(person9);

        //实例工厂的使用
//        Person person9 = applicationContext.getBean("person10", Person.class);
//        System.out.println(person9);

        //实现FactoryBean接口来创建对象
//        Object myfactorybean = applicationContext.getBean("myfactorybean");
//        System.out.println(myfactorybean);

        //Bean的生命周期表示Bean对象的创建到销毁的过程
        //如果Bean是单例的，容器在启动时会创建好，关闭时会销毁
        //如果Bean是多例的，在获取Bean对象的时候创建实例，销毁时不会有任何调用
//        Address address = applicationContext.getBean("address", Address.class);
//////        System.out.println(address);
////        ((ClassPathXmlApplicationContext)applicationContext).close();


        //spring中包含一个BeanPostProcessor的接口，可以在bean的初始化方法的前后调用该方法，
        // 如果配置了初始化方法的前置和后置处理器，无论是否包含初始化方法，都会进行调用
        Object obj = applicationContext.getBean("address2");

    }
}
