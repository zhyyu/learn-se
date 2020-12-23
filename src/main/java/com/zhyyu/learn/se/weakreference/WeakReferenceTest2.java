package com.zhyyu.learn.se.weakreference;

import lombok.Data;

import java.lang.ref.WeakReference;

/**
 * @author zhongyu.yzy
 * @date 2020/12/12
 */
public class WeakReferenceTest2 {

    public static void main(String[] args) {
        MyClz myClz = new MyClz();
        myClz.setI(10);

        WeakReference<MyClz> myClzWeakReference = new WeakReference<>(myClz);
        System.out.println(myClzWeakReference.get());
        System.out.println("=======");

        // 依然有强引用（yClz myClz = new MyClz();）， 故不会回收
        System.gc();
        System.out.println(myClzWeakReference.get());
        System.out.println("=======");

        // 强引用被清除， 未gc，弱引用未释放
        myClz = null;
        System.out.println(myClzWeakReference.get());
        System.out.println("=======");

        // 强引用， gc， 弱引用释放
        System.gc();
        System.out.println(myClzWeakReference.get());
    }

    @Data
    static class MyClz {
        private Integer i;
    }

}
