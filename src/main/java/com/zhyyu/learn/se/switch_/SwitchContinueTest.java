package com.zhyyu.learn.se.switch_;

/**
 * SwitchContinueTest
 * <pre>
 *     1. case 和break; 搭配, break 为退出switch 语句块
 *     2. case 中亦可使用return, continue, 但分别是退出方法与结束本次循环
 * </pre>
 * @author juror
 * @datatime 2019/6/20 14:52
 */
public class SwitchContinueTest {

    public static void main(String[] args){
        method("sth");
    }

    public static void method(String param){
        for (int i = 0; i < 3; i++) {
            switch (param) {
                // 肯定不是进入这里
                case "sth":
                    System.out.println("it's sth");
                    continue;
                    // 也不是进入这里
                case "null":
                    System.out.println("it's null");
                    break;
                // 也不是进入这里
                default:
                    System.out.println("default");
            }
        }
    }

}
