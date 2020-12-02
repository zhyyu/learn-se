package com.zhyyu.learn.se.lambda.chapter7_debug;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;

/**
 * @author zhongyu.yzy
 * @date 2020/12/2
 */
public class PeekTest {

    public static void main(String[] args) {
        Optional<Integer> max = Arrays.asList(1, 2).stream().peek(num -> System.out.println(num)).max(Comparator.comparing(i -> i));
        System.out.println(max);


        OptionalInt max1 = Arrays.asList(1, 2).stream().mapToInt(num -> num.intValue()).max();
        System.out.println(max1);
    }

}
