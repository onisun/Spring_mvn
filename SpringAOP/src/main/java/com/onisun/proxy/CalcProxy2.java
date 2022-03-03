package com.onisun.proxy;

import com.onisun.service.impl.CalcImpl;
import com.onisun.util.LogUtil;

import java.lang.reflect.Method;

/**
 * @author Neo
 * @version 1.0
 */
public class CalcProxy2 {
  /*  public int add(int i,int j) throws NoSuchMethodException {

        Method method = CalcProxy2.class.getMethod("add", int.class, int.class);

        LogUtil.start(method,i,j);

        int result = new CalcImpl().add(i,j);

        LogUtil.stop(method,result);

        return result;
    }*/
}
