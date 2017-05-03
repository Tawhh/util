package com.task.schedule.test.cont;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by t420 on 2017/5/3.
 */
public class CglibProxy implements MethodInterceptor {
    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer ech = new Enhancer();
        ech.setSuperclass(this.target.getClass());
        ech.setCallback(this);
        return ech.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("--begin--");
        methodProxy.invokeSuper(o,objects);
        System.out.println("--end--");
        return null;
    }

}
