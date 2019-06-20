package com.zhyyu.learn.se.collection;

import java.util.ArrayList;

/**
 * AddAllContainNullElementTest
 * <p>
 *     1. 可添加非空集合, 但集合中包含null 元素
 *     2. 不可添加null 集合, 否则 NullPointerException
 * </p>
 * @author juror
 * @datatime 2019/6/20 9:45
 */
public class AddAllContainNullElementTest {

    public static void main(String[] args) {
        ArrayList<Integer> alist1 = new ArrayList<>();
        alist1.add(1);
        alist1.add(null);

        ArrayList<Integer> aList2 = new ArrayList<>();
        aList2.addAll(alist1);
        System.out.println(aList2);

        aList2.addAll(null);
    }

}

/**
 * output:
 * [1, null]
 * Exception in thread "main" java.lang.NullPointerException
 * 	at java.util.ArrayList.addAll(ArrayList.java:581)
 * 	at com.zhyyu.learn.se.collection.AddAllContainNullElementTest.main(AddAllContainNullElementTest.java:20)
 */