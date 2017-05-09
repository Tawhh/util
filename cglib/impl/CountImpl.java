package com.task.schedule.test.impl;

import com.task.schedule.test.dao.Count;

/**
 * Created by t420 on 2017/5/3.
 */
public class CountImpl implements Count {
    @Override
    public void queryCount() {
        System.out.println("--querycount--");
    }

    @Override
    public void updateCount() {
        System.out.println("--updatecount--");
    }
}
