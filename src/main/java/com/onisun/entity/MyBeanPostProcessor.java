package com.onisun.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author Neo
 * @version 1.0
 */

//spring中包含一个BeanPostProcessor的接口，可以在bean的初始化方法的前后调用该方法，
// 如果配置了初始化方法的前置和后置处理器，无论是否包含初始化方法，都会进行调用
public class MyBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization:" + beanName + "调用初始化前置方法");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization:" + beanName + "调用初始化后置方法");
        return bean;
    }
}
