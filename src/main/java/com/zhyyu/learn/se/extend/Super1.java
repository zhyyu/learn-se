package com.zhyyu.learn.se.extend;

/**
 * @author juror
 * @datatime 2019/7/24 19:00
 */
public class Super1 implements Interface1 {

    private Object object = new Object();

    public String obt2String() {
        return object.toString();
    }

    @Override
    public void method1() {
        System.out.println("super method1");
    }

}
