package com.zhyyu.learn.se.lambda.chapter3_stream;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhongyu.yzy
 * @date 2020/12/2
 */
public class FlatMapTest2 {

    public static void main(String[] args) {
        TestClz1 testClz1 = new TestClz1();
        testClz1.setTestStrList(Arrays.asList("1", "2"));

        TestClz1 testClz2 = new TestClz1();
        testClz2.setTestStrList(Arrays.asList("3", "4"));

        List<TestClz1> testClz1s = Arrays.asList(testClz1, testClz2);
        List<String> collect = testClz1s.stream().flatMap(elm -> elm.getTestStrList().stream()).collect(Collectors.toList());
        System.out.println(collect);
    }


    @Data
    private static class TestClz1 {
        private List<String> testStrList;
    }

}
