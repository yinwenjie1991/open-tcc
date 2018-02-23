package org.ywj.opentcc.core.classtest;

import org.junit.Test;

/**
 * 文件描述:
 * 作者: yinwenjie
 * 日期: 2018-02-07
 */
public class MyClassTest {

    @Test
    public void classTest() {
        A a = new A();
        Class[] classes = a.getClass().getInterfaces();
        for ( Class c : classes) {
            System.out.println(c);
        }
    }
}
