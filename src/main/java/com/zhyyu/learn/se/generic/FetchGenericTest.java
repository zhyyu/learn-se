package com.zhyyu.learn.se.generic;

import java.util.Arrays;
import java.util.List;

/**
 * 测试List 泛型中获取元素对应Class
 * @author juror
 * @datatime 2019/6/12 17:02
 */
public class FetchGenericTest {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        MyObject.method1(integerList);
    }


    static class MyObject {
        public static <T> void method1(List<T> list) {
            Class<T> clz = (Class<T>) list.get(0).getClass();
            System.out.println(clz);
        }

    }

}
