package com.zhyyu.learn.se.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ForeachRemoveTest
 * <pre>
 *     1. 使用 iterator 删除集合中元素
 *     2. foreach 中删除可能会出现 ConcurrentModificationException(但删除第一个元素时不会? 如下例 "1"
 * </pre>
 *
 * @author juror
 * @datatime 2019/6/20 12:22
 */
public class ForeachRemoveTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");

        /*Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("2".equals(item)) {
                iterator.remove();
            }
        }*/

        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }

        System.out.println(list);
    }

}
