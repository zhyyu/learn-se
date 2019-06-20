package com.zhyyu.learn.se.exception;

/**
 * ExceptionMessageTest
 * <pre>
 *      1. 打印异常堆栈信息即包括 e.getMessage()
 * </pre>
 * @author juror
 * @datatime 2019/6/20 15:40
 */
public class ExceptionMessageTest {

    public static void main(String[] args) {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e);
            e.printStackTrace();
        }
    }

}


/*
*
*
/ by zero
java.lang.ArithmeticException: / by zero
java.lang.ArithmeticException: / by zero
	at com.zhyyu.learn.se.exception.ExceptionMessageTest.main(ExceptionMessageTest.java:11)
*
* */
