package com.zhyyu.learn.se.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDistinctTest {

    public static void main(String[] args) {
        List<String> strList = Arrays.asList("A", "A", "B", "B");
        List<String> distinctList = strList.stream().distinct().collect(Collectors.toList());

        System.out.println(distinctList);
    }

}
