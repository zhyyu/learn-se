package com.zhyyu.learn.se.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhongyu.yzy
 * @date 2020/8/11
 */
public class StreamSortTest {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(2, 3, 1);
        List<Integer> collect = intList.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).collect(Collectors.toList());
        System.out.println(collect);
    }

}
