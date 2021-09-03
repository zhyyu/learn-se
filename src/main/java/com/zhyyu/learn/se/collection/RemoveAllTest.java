package com.zhyyu.learn.se.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveAllTest {

    public static void main(String[] args) {
        List<String> firstList = new ArrayList<>(Arrays.asList("A", "B", "C"));
        List<String> secondList = new ArrayList<>(Arrays.asList("B", "C"));

        System.out.println(firstList.removeAll(secondList));
        System.out.println(firstList);
        System.out.println(secondList);
    }

}
