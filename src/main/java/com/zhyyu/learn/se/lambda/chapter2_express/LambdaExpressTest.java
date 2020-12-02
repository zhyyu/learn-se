package com.zhyyu.learn.se.lambda.chapter2_express;

import java.util.function.*;

/**
 * @author zhongyu.yzply
 * @date 2020/11/30
 */
public class LambdaExpressTest {

    public static void main(String[] args) {
        Runnable hello = () -> System.out.println("hello");

        Consumer hello2 = event -> System.out.println("hello2");

        Runnable runnable = () -> {
            System.out.println("hello1");
            System.out.println("hello1");
        };

        BinaryOperator<Long>  longBinaryOperator = (x, y) -> x + y;
        BinaryOperator<Long> longBinaryOperator2 = (Long x, Long y) -> x + y;
    }

}
