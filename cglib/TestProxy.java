package com.task.schedule.test;

import com.task.schedule.test.cont.CglibProxy;
import com.task.schedule.test.cont.CountProxy;
import com.task.schedule.test.cont.JdkProxy;
import com.task.schedule.test.dao.Count;
import com.task.schedule.test.impl.CountImpl;

/**
 * Created by t420 on 2017/5/3.
 */
public class TestProxy {
    public static void main(String[] args) {
        /*--静态代理--*/
        CountProxy cop = new CountProxy(new CountImpl());
        cop.updateCount();

        //*--jdk代理*//*
        JdkProxy jp = new JdkProxy();
        Count count = (Count) jp.bind(new CountImpl());
        count.updateCount();
        //*cglib动态代理*//*
        CglibProxy cp = new CglibProxy();
        CountImpl ci = (CountImpl) cp.getInstance(new CountImpl());
        ci.updateCount();
    }

}
