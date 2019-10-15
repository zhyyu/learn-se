package com.zhyyu.learn.se.weakreference;

import java.util.WeakHashMap;

/**
 * 测试 weakHashMap
 * <pre>
 *     1. 对key 进行弱引用
 *     2. key 不能为运行中常量池变量, 不然无法回收, 如String
 *     3. 对 key 不能有其他强引用
 * </pre>
 *
 * @author juror
 * @datatime 2019/10/15 16:10
 */
public class WeakHashMapTest {

    public static void main(String[] args) throws InterruptedException {
        WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();
        weakHashMap.put("1", "a");
        System.out.println(weakHashMap);

        System.gc();
        System.out.println(weakHashMap);

        System.out.println("================");
        WeakHashMap<MyObj, String> weakHashMap2 = new WeakHashMap<>();
//        MyObj myObj = new MyObj();
        weakHashMap2.put(new MyObj(), "a");
        System.out.println(weakHashMap2);
        System.gc();
        System.out.println(weakHashMap2);
    }

    static class MyObj {

    }

}

/*
* https://droidyue.com/blog/2014/10/12/understanding-weakreference-in-java/
* */