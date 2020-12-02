package com.zhyyu.learn.se.lambda.chapter4_library;

import java.util.Optional;

/**
 * @author zhongyu.yzy
 * @date 2020/12/2
 */
public class OptionalIfPresentTest {

    public static void main(String[] args) {
        Optional<String> a = Optional.of("a");
        a.ifPresent(ele -> System.out.println(ele));
    }

}
