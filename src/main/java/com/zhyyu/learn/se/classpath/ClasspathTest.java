package com.zhyyu.learn.se.classpath;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * 使用java -classpath 参数指定依赖jar 包, 注意classpath 后指定路径需要添加引号(")!!
 * @author zhyyu
 *
 */
public class ClasspathTest {

	public static void main(String[] args) {
		System.out.println(NumberUtils.BYTE_ZERO);
	}
	
}

/*============================ 未设置classpath =============================*/

//PS C:\Users\zhyyu\Desktop\workspace-zhyyu-learn\learn-se\target\classes> java com.zhyyu.learn.se.classpath.ClasspathTest
//Exception in thread "main" java.lang.NoClassDefFoundError: org/apache/commons/lang3/math/NumberUtils
//        at com.zhyyu.learn.se.classpath.ClasspathTest.main(ClasspathTest.java:13)
//Caused by: java.lang.ClassNotFoundException: org.apache.commons.lang3.math.NumberUtils
//        at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
//        at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
//        at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:349)
//        at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
//        ... 1 more

/*============================ 设置classpath =============================*/

//PS C:\Users\zhyyu\Desktop\workspace-zhyyu-learn\learn-se\target\classes> java -classpath "C:\zhongyuyu\tech\m2\repository\org\apache\commons\commons-lang3\3.7\commons-lang3-3.7.jar;." com.z
//hyyu.learn.se.classpath.ClasspathTest
//0