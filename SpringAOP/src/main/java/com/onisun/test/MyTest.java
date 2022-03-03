package com.onisun.test;

import com.onisun.service.Calc;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Neo
 * @version 1.0
 */
public class MyTest {
    public static void main(String[] args) throws NoSuchMethodException {
        //使用动态代理实现的日志切入
     /*   CalcImpl calc = new CalcImpl();
        Calc proxy = CalcProxy.getProxy(calc);
        System.out.println(proxy.mult(15,3));

*/

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Calc calc = context.getBean(Calc.class);
        System.out.println(calc.add(5,6));
        System.out.println("------------------");
    }
}
