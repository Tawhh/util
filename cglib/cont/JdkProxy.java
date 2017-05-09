package com.task.schedule.test.cont;

import com.task.schedule.test.dao.Count;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by t420 on 2017/5/3.
 */
public class JdkProxy implements InvocationHandler {
    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);

    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        Object result = null;
        System.out.println("begin--");
        result = method.invoke(target,objects);
        System.out.println("end--");
        return result;
    }

}
