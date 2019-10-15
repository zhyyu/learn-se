package com.zhyyu.learn.se.weakreference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * @author juror
 * @datatime 2019/10/15 14:45
 */
public class WeakReferenceTest {

    public static void main(String[] args) throws InterruptedException {
        WeakReference<MyObj> myObjWeakReference = new WeakReference<>(new MyObj());

        /**
         * 若有局部变量 myObj, 则弱引用不会被gc
         */
//        MyObj myObj = myObjWeakReference.get();
        System.out.println(myObjWeakReference.get());

        System.gc();
        System.out.println(myObjWeakReference);
        System.out.println(myObjWeakReference.get());

        System.out.println("===========================");
        ReferenceQueue<MyObj> referenceQueue = new ReferenceQueue<>();
        WeakReference<MyObj> myObjWeakReference2 = new WeakReference<>(new MyObj(), referenceQueue);
        System.out.println(myObjWeakReference2.get());
        System.out.println(referenceQueue.poll());

        System.gc();;
        System.out.println(myObjWeakReference2.get());
        System.out.println(referenceQueue.poll());
    }

    static class MyObj {

    }

}

/**
 * https://www.zhihu.com/question/37401125
 *
 吕清海 ThreadLocal 分析
 */
