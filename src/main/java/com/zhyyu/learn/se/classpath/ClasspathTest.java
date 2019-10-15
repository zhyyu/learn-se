package com.zhyyu.learn.se.classpath;

import org.apache.commons.lang3.math.NumberUtils;

import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

/**
 * 使用java -classpath 参数指定依赖jar 包, 注意classpath 后指定路径需要添加引号(")!!
 *
 * <pre>
 *     springboot test:
 *	参考 https://www.liaoxuefeng.com/wiki/1252599548343744/1260466914339296
 * 	java -cp .\learn-springboot-0.0.1-SNAPSHOT.jar org.springframework.boot.loader.JarLauncher 同样可以启动jar 包
 *  java -jar .\learn-springboot-0.0.1-SNAPSHOT.jar
 * </pre>
 *
 * @author zhyyu
 *
 */
public class ClasspathTest {

	public static void main(String[] args) {
		System.out.println(NumberUtils.BYTE_ZERO);

		ClassLoader cl = ClassLoader.getSystemClassLoader();

		URL[] urls = ((URLClassLoader)cl).getURLs();
		System.out.println(Arrays.asList(urls));
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




/**
 * 190622:
 *
 * C:\zhongyuyu\tech\Java\jdk1.8.0_171\bin\java.exe "-javaagent:C:\zhongyuyu\tech\JetBrains\IntelliJ IDEA 2019.1\lib\idea_rt.jar=61507:C:\zhongyuyu\tech\JetBrains\IntelliJ IDEA 2019.1\bin" -Dfile.encoding=UTF-8 -classpath C:\Users\zhyyu\Desktop\zhyyu-learn-workspace\learn-se\target\classes;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\charsets.jar;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\deploy.jar;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\ext\access-bridge-64.jar;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\ext\cldrdata.jar;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\ext\dnsns.jar;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\ext\jaccess.jar;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\ext\jfxrt.jar;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\ext\localedata.jar;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\ext\nashorn.jar;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\ext\sunec.jar;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\ext\sunjce_provider.jar;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\ext\sunmscapi.jar;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\ext\sunpkcs11.jar;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\ext\zipfs.jar;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\javaws.jar;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\jce.jar;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\jfr.jar;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\jfxswt.jar;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\jsse.jar;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\management-agent.jar;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\plugin.jar;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\resources.jar;C:\zhongyuyu\tech\Java\jdk1.8.0_171\jre\lib\rt.jar;C:\Users\zhyyu\.m2\repository\org\apache\commons\commons-lang3\3.7\commons-lang3-3.7.jar com.zhyyu.learn.se.classpath.ClasspathTest
 * 0
 * [file:/C:/Users/zhyyu/Desktop/zhyyu-learn-workspace/learn-se/target/classes/, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/charsets.jar, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/deploy.jar, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/ext/access-bridge-64.jar, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/ext/cldrdata.jar, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/ext/dnsns.jar, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/ext/jaccess.jar, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/ext/jfxrt.jar, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/ext/localedata.jar, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/ext/nashorn.jar, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/ext/sunec.jar, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/ext/sunjce_provider.jar, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/ext/sunmscapi.jar, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/ext/sunpkcs11.jar, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/ext/zipfs.jar, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/javaws.jar, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/jce.jar, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/jfr.jar, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/jfxswt.jar, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/jsse.jar, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/management-agent.jar, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/plugin.jar, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/resources.jar, file:/C:/zhongyuyu/tech/Java/jdk1.8.0_171/jre/lib/rt.jar, file:/C:/Users/zhyyu/.m2/repository/org/apache/commons/commons-lang3/3.7/commons-lang3-3.7.jar, file:/C:/zhongyuyu/tech/JetBrains/IntelliJ%20IDEA%202019.1/lib/idea_rt.jar]
 *
 * Process finished with exit code 0
 */