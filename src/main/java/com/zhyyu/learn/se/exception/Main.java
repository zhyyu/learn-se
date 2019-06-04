package com.zhyyu.learn.se.exception;

/**
 * 测试实现类抛出异常降级(更细化)
 * <pre>
 *     实现类可定义接口方法抛出异常子类
 * </pre>
 * @author juror
 * @datatime 2019/6/4 12:05
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Interface1 interface1 = new Interface1Impl();
        interface1.method1();
    }

}


/*
    method1 invoked Exception1
        Exception in thread "main" com.zhyyu.learn.se.exception.Interface1Impl$Exception1
        at com.zhyyu.learn.se.exception.Interface1Impl.method1(Interface1Impl.java:17)
        at com.zhyyu.learn.se.exception.Main.main(Main.java:12)
*/
