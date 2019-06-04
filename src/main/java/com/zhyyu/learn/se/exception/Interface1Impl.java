package com.zhyyu.learn.se.exception;

/**
 * @author juror
 * @datatime 2019/6/4 12:05
 */
public class Interface1Impl implements Interface1 {

    /*@Override
    public void method1() throws Exception {
        System.out.println("method1 invoked");
    }*/

    @Override
    public void method1() throws Exception1 {
        System.out.println("method1 invoked Exception1");
        throw new Exception1();
    }

    public class Exception1 extends Exception {

    }

}
