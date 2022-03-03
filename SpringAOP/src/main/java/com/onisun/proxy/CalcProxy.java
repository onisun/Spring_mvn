package com.onisun.proxy;

/**
 * @author Neo
 * @version 1.0
 */

import com.onisun.service.Calc;
import com.onisun.util.LogUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 帮助Calc生成代理对象的类
 */
public class CalcProxy {

    public static Calc getProxy(final Calc calc) {
        //被代理对象的类加载器
        ClassLoader classLoader = calc.getClass().getClassLoader();
        //被代理对象的接口
        Class<?>[] interfaces = calc.getClass().getInterfaces();
        //方法执行器，执行被代理对象的目标方法
        InvocationHandler handler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                //利用反射执行目标方法,目标方法执行后的返回值
                try {
//                    System.out.println(method.getName() + "方法开始执行，参数是：" + Arrays.asList(args));
//                    LogUtil.start(method,args);
                    result = method.invoke(calc, args);
//                    LogUtil.stop(method, result);

                } catch (Exception e) {
//                    System.out.println(method.getName() + "方法出现异常，" + e);
//                    LogUtil.logException(method,e);
                } finally {
//                    System.out.println(method.getName() + "方法执行结束了...");
//                    LogUtil.end(method);
                }

                return result;
            }
        };

        Object proxy = Proxy.newProxyInstance(classLoader, interfaces, handler);

        return (Calc) proxy;
    }
}
