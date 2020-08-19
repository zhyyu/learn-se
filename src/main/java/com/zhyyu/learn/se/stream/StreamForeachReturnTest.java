package com.zhyyu.learn.se.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @date 2020/7/24
 */
public class StreamForeachReturnTest {

    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3);

        intList.stream().forEach(integer -> {
            if (Objects.equals(integer, 2)) {
                // break continue 无法使用, 编译错误
//                break;
//                continue;

                // return 相当于continue
                    return;

                // RuntimeException 直接退出这个方法
//                throw new RuntimeException("myexp");
            }

            System.out.println(integer);
        });

        System.out.println("finished");
    }

}
