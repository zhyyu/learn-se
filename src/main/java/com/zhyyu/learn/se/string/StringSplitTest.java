package com.zhyyu.learn.se.string;

import java.util.Arrays;

/**
 * StringSplitTest
 * <pre>
 *
 *     javadoc: Trailing empty strings are therefore not included in the resulting array.
 *     1. 若分割后最后一个字符串为空串, 去除, 直到最后不为空串
 *     2. 中间可为空串
 * </pre>
 */
public class StringSplitTest {

    public static void main(String[] args) {
        System.out.println(Arrays.asList("a,b,c,,".split(",")));
        System.out.println(Arrays.asList("a,b,c, ,".split(",")));
        System.out.println(Arrays.asList("a,b,c,, ".split(",")));

        System.out.println();
        System.out.println("===============");

        System.out.println(Arrays.asList("a,b,c, ".split(",")));
        System.out.println(Arrays.asList("a,b,c,".split(",")));
    }

}

/**
 * [a, b, c]
 * [a, b, c,  ]
 * [a, b, c, ,  ]
 *
 * ===============
 * [a, b, c,  ]
 * [a, b, c]
 */