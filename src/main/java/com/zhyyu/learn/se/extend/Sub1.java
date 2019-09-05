package com.zhyyu.learn.se.extend;

/**
 * @author juror
 * @datatime 2019/7/24 19:01
 */
public class Sub1 extends Super1 {

    @Override
    public void method1() {
        System.out.println("sub1 method1");
        super.method1();
    }
}
