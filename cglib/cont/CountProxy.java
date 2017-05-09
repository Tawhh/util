package com.task.schedule.test.cont;

import com.task.schedule.test.dao.Count;
import com.task.schedule.test.impl.CountImpl;

/**
 * Created by t420 on 2017/5/3.
 */
public class CountProxy implements Count {

    private CountImpl countImpl;

    public CountProxy(CountImpl countImpl) {
        this.countImpl = countImpl;
    }

    @Override
    public void queryCount() {
        System.out.println("before--count");
        countImpl.queryCount();
        System.out.println("after--count");
    }

    @Override
    public void updateCount() {
        System.out.println("before--updatecount");
        countImpl.updateCount();
        System.out.println("after--updatecount");
    }
}
