package com.zhyyu.learn.se.shutdown;

/**
 * javac 编译, java 执行, 在linux 平台
 *
 * <pre>
 *     kill -9: 直接杀死非守护线程, 守护线程, 不执行shutdownHook
 *     kill -15: 直接杀死非守护线程, 守护线程, 执行shutdownHook
 *     Runtime.getRuntime().exit(0): 直接杀死非守护线程, 守护线程, 执行shutdownHook
 *     所有非守护线程执行完毕, 杀死守护线程, 执行shutdownHook
 * </pre>
 *
 *
 * @author juror
 * @datatime 2020/5/18 11:02
 */
public class Kill15Test {

    public static void main(String[] args) throws InterruptedException {
        // shutDownHook
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("shutdown hook invoked");
            }
        }));

        // 非守护线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                int cnt = 0;
                while (true) {
                    try {
                        cnt++;
                        if (cnt > 10) {
                            break;
                        }
                        Thread.sleep(1000);
                        System.out.println("not daemon execute " + cnt);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();


        // 守护线程
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int cnt = 0;
                while (true) {
                    try {
                        cnt++;
                        // 5, 15 test
                        if (cnt > 15) {
                            break;
                        }
                        Thread.sleep(1000);
                        System.out.println("daemon execute " + cnt);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.setDaemon(true);
        thread.start();

//        Thread.sleep(5000);
//        Runtime.getRuntime().exit(0);
    }

}
