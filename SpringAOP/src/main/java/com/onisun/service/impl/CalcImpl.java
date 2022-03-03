package com.onisun.service.impl;

import com.onisun.service.Calc;
import org.springframework.stereotype.Service;

/**
 * @author Neo
 * @version 1.0
 */
@Service
public class CalcImpl implements Calc {
    public Integer add(Integer i, Integer j) throws NoSuchMethodException {
//        System.out.println("add 方法开始执行，参数为："+i+","+j);
//        Method add = CalcImpl.class.getMethod("add", int.class, int.class);

//        LogUtil.start(add,i,j);
        int result = i + j;
//        System.out.println("add 方法开始完成结果为："+result);
//        LogUtil.stop(add,result);
        return result;
    }

    public Integer sub(Integer i, Integer j) throws NoSuchMethodException {
//        System.out.println("sub 方法开始执行，参数为："+i+","+j);
//        Method sub = CalcImpl.class.getMethod("sub", int.class, int.class);
//        LogUtil.start(sub,i,j);
        int result = i - j;
//        System.out.println("sub 方法开始完成结果为："+result);
//        LogUtil.stop(sub,result);
        return result;
    }

    public Integer mult(Integer i, Integer j) throws NoSuchMethodException {
//        System.out.println("mult 方法开始执行，参数为："+i+","+j);
//        Method mult = CalcImpl.class.getMethod("mult", int.class, int.class);
//        LogUtil.start(mult,i,j);
        int result = i * j;
//        System.out.println("mult 方法开始完成结果为："+result);
//        LogUtil.stop(mult,result);
        return result;
    }

    public Integer div(Integer i, Integer j) throws NoSuchMethodException {
//        System.out.println("div 方法开始执行，参数为："+i+","+j);
//        Method div = CalcImpl.class.getMethod("div", int.class, int.class);
//        LogUtil.start(div,i,j);
        int result = i / j;
//        System.out.println("div 方法开始完成结果为："+result);
//        LogUtil.stop(div,result);
        return result;
    }
}
