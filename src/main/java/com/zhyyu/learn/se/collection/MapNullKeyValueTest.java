package com.zhyyu.learn.se.collection;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * MapNullKeyValueTest
 * <pre>
 *     ConcurrentHashMap: key, value 均不能为null
 *     hashMap: key, value 均可以为null
 *     treeMap: key 不能为null, value 可以为null
 * </pre>
 * @author juror
 * @datatime 2019/6/20 14:10
 */
public class MapNullKeyValueTest {

    public static void main(String[] args) {
        ConcurrentHashMap<Integer, Integer> chmap = new ConcurrentHashMap<>();
//        chmap.put(null, 1);
//        chmap.put(1, null);
//        chmap.put(null, null);
        chmap.put(1, 1);

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(null, 1);
        hashMap.put(1, null);
        hashMap.put(null, null);
        hashMap.put(2, 2);

        System.out.println(hashMap);
        System.out.println(hashMap.get(null));

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
//        treeMap.put(null, 1);
        treeMap.put(2, null);
//        treeMap.put(null, null);
        treeMap.put(1, 1);

        System.out.println(treeMap);
    }

}
