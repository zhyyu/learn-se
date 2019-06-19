package com.zhyyu.learn.se.switch_;

/**
 * SwitchNullTest
 * <pre>
 *     1. 空指针异常
 *     2. javap 查看字节码指令后, 发现调用 invokevirtual #3                  // Method java/lang/String.hashCode:()I
 *        null.hashCode 会包空指针异常
 * </pre>
 * @author juror
 * @datatime 2019/6/19 18:04
 */
public class SwitchNullTest {

    public static void main(String[] args){
        method(null);
    }

    public static void method(String param){
        switch(param){
            // 肯定不是进入这里
            case"sth":
                System.out.println("it's sth");
                break;
            // 也不是进入这里
            case"null":
                System.out.println("it's null");
                break;
            // 也不是进入这里
            default:
                System.out.println("default");
        }
    }

}


/**
 * C:\juror\tech\Java\jdk1.8.0_201\bin\java.exe "-javaagent:C:\juror\tech\JetBrains\IntelliJ IDEA 2019.1\lib\idea_rt.jar=64349:C:\juror\tech\JetBrains\IntelliJ IDEA 2019.1\bin" -Dfile.encoding=UTF-8 -classpath C:\juror\tech\Java\jdk1.8.0_201\jre\lib\charsets.jar;C:\juror\tech\Java\jdk1.8.0_201\jre\lib\deploy.jar;C:\juror\tech\Java\jdk1.8.0_201\jre\lib\ext\access-bridge-64.jar;C:\juror\tech\Java\jdk1.8.0_201\jre\lib\ext\cldrdata.jar;C:\juror\tech\Java\jdk1.8.0_201\jre\lib\ext\dnsns.jar;C:\juror\tech\Java\jdk1.8.0_201\jre\lib\ext\jaccess.jar;C:\juror\tech\Java\jdk1.8.0_201\jre\lib\ext\jfxrt.jar;C:\juror\tech\Java\jdk1.8.0_201\jre\lib\ext\localedata.jar;C:\juror\tech\Java\jdk1.8.0_201\jre\lib\ext\nashorn.jar;C:\juror\tech\Java\jdk1.8.0_201\jre\lib\ext\sunec.jar;C:\juror\tech\Java\jdk1.8.0_201\jre\lib\ext\sunjce_provider.jar;C:\juror\tech\Java\jdk1.8.0_201\jre\lib\ext\sunmscapi.jar;C:\juror\tech\Java\jdk1.8.0_201\jre\lib\ext\sunpkcs11.jar;C:\juror\tech\Java\jdk1.8.0_201\jre\lib\ext\zipfs.jar;C:\juror\tech\Java\jdk1.8.0_201\jre\lib\javaws.jar;C:\juror\tech\Java\jdk1.8.0_201\jre\lib\jce.jar;C:\juror\tech\Java\jdk1.8.0_201\jre\lib\jfr.jar;C:\juror\tech\Java\jdk1.8.0_201\jre\lib\jfxswt.jar;C:\juror\tech\Java\jdk1.8.0_201\jre\lib\jsse.jar;C:\juror\tech\Java\jdk1.8.0_201\jre\lib\management-agent.jar;C:\juror\tech\Java\jdk1.8.0_201\jre\lib\plugin.jar;C:\juror\tech\Java\jdk1.8.0_201\jre\lib\resources.jar;C:\juror\tech\Java\jdk1.8.0_201\jre\lib\rt.jar;C:\juror\eclipse-workspace\zhyyu-learn-workspace\learn-se\target\classes;C:\Users\juror\.m2\repository\org\apache\commons\commons-lang3\3.7\commons-lang3-3.7.jar com.zhyyu.learn.se.switch_.SwitchNullTest
 * Exception in thread "main" java.lang.NullPointerException
 * 	at com.zhyyu.learn.se.switch_.SwitchNullTest.method(SwitchNullTest.java:14)
 * 	at com.zhyyu.learn.se.switch_.SwitchNullTest.main(SwitchNullTest.java:10)
 *
 * Process finished with exit code 1
 *
 *
 *
 *
 * javap:
 *
 *  public static void method(java.lang.String);
 *     descriptor: (Ljava/lang/String;)V
 *     flags: ACC_PUBLIC, ACC_STATIC
 *     Code:
 *       stack=2, locals=3, args_size=1
 *          0: aload_0
 *          1: astore_1
 *          2: iconst_m1
 *          3: istore_2
 *          4: aload_1
 *          5: invokevirtual #3                  // Method java/lang/String.hashCode:()I
 *          8: lookupswitch  { // 2
 *                   114215: 36
 *                  3392903: 50
 *                  default: 61
 *             }
 *         36: aload_1
 *         37: ldc           #4                  // String sth
 *         39: invokevirtual #5                  // Method java/lang/String.equals:(Ljava/lang/Object;)Z
 */