package com.zhyyu.learn.se.extend;

/**
 * 子类重写父类方法, super.xx 方式可再调用父类方法, 然后在重写方法中添加逻辑. 如下:
 * <pre>
 *     {@code
 *     @Override
 *      public void method1() {
 *           System.out.println("sub1 method1");
 *           super.method1();
 *       }
 *     }
 *
 *
 *  不同子类继承相同父类, 子类对象实际拥有的是不同父类对象
 *
 * </pre>
 * @author juror
 * @datatime 2019/7/24 18:59
 */
public class SubCallSuperTest {

    public static void main(String[] args) {
        Interface1 interface1 = new Sub1();
        interface1.method1();

        Sub1 sub1 = new Sub1();
        Sub2 sub2 = new Sub2();

        /**
         * java.lang.Object@74a14482
         * java.lang.Object@1540e19d
         */
        System.out.println(sub1.obt2String());
        System.out.println(sub2.obt2String());
    }

}
