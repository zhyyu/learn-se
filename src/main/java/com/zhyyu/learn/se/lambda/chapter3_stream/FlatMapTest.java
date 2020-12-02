package com.zhyyu.learn.se.lambda.chapter3_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @author zhongyu.yzy
 * @date 2020/12/1
 */
public class FlatMapTest {

    public static void main(String[] args) {
        List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)) .flatMap(numbers -> numbers.stream())
                .collect(toList());
        System.out.println(together);

        List<Long> collect = Stream.of(1L, 2L).collect(toList());
        System.out.println(collect);

        List<List<Integer>> collect1 = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4)).collect(toList());
        System.out.println(collect1);

        Stream<List<Integer>> listStream = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 4));
    }

}
