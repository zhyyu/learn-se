package com.zhyyu.learn.se.collection;

import java.util.HashMap;
import java.util.Map;

public class MapComputeIfAbsentTest {

    public static void main(String[] args) {
        Map<String, String> testMap = new HashMap<>();
        testMap.computeIfAbsent("str1", key -> "val1");
        System.out.println(testMap.get("str1"));

        testMap.computeIfAbsent("str1", key -> "val2");
        System.out.println(testMap.get("str1"));
    }

}
