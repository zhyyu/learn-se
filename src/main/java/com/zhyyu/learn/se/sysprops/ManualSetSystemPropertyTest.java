package com.zhyyu.learn.se.sysprops;

/**
 * 测试手动设置系统变量, 使用jinfo 验证
 * @author zhyyu2016
 *
 */
public class ManualSetSystemPropertyTest {

	public static void main(String[] args) {
		System.setProperty("my-property", "my-value");
		String property = System.getProperty("sun.cpu.isalist");
		System.out.println(property);
		while (true);
	}
	
}


//C:\Users\Administrator>jinfo 14296
//Attaching to process ID 14296, please wait...
//Debugger attached successfully.
//Server compiler detected.
//JVM version is 25.121-b13
//Java System Properties:
//
//java.runtime.name = Java(TM) SE Runtime Environment
//java.vm.version = 25.121-b13
//sun.boot.library.path = D:\java\jdk1.8.0_121\jre\bin
//java.vendor.url = http://java.oracle.com/
//java.vm.vendor = Oracle Corporation
//path.separator = ;
//file.encoding.pkg = sun.io
//java.vm.name = Java HotSpot(TM) 64-Bit Server VM
//sun.os.patch.level = Service Pack 1
//sun.java.launcher = SUN_STANDARD
//user.script =
//user.country = CN
//user.dir = F:\workspace-zhyyu-learn\learn-se
//java.vm.specification.name = Java Virtual Machine Specification
//java.runtime.version = 1.8.0_121-b13
//java.awt.graphicsenv = sun.awt.Win32GraphicsEnvironment
//os.arch = amd64
//java.endorsed.dirs = D:\java\jdk1.8.0_121\jre\lib\endorsed
//line.separator =
//
//java.io.tmpdir = C:\Users\ADMINI~1\AppData\Local\Temp\
//java.vm.specification.vendor = Oracle Corporation
//user.variant =
//os.name = Windows 7
//sun.jnu.encoding = GBK
//java.library.path = D:\java\jdk1.8.0_121\bin;C:\Windows\Sun\Java\bin;C:\Windows\system32;C:\Windows;D:/java/jdk1.8.0_121/bin/../jre/bin/server;D:/java
///jdk1.8.0_121/bin/../jre/bin;D:/java/jdk1.8.0_121/bin/../jre/lib/amd64;D:\apache-maven-3.3.9\bin;D:\Python34\;D:\Python34\Scripts;D:\java\jdk1.8.0_121
//\bin;C:\Program Files (x86)\Intel\iCLS Client\;C:\Program Files\Intel\iCLS Client\;C:\Windows\system32;C:\Windows;C:\Windows\System32\Wbem;C:\Windows\
//System32\WindowsPowerShell\v1.0\;c:\Program Files (x86)\ATI Technologies\ATI.ACE\Core-Static;C:\Program Files (x86)\Intel\Intel(R) Management Engine C
//omponents\DAL;C:\Program Files\Intel\Intel(R) Management Engine Components\DAL;C:\Program Files (x86)\Intel\Intel(R) Management Engine Components\IPT;
//C:\Program Files\Intel\Intel(R) Management Engine Components\IPT;D:\Git\cmd;C:\Windows\system32\config\systemprofile\.dnx\bin;C:\Program Files\Microso
//ft DNX\Dnvm\;C:\Program Files\Microsoft SQL Server\130\Tools\Binn\;C:\Program Files\MySQL\MySQL Utilities 1.6\;C:\Users\Administrator\AppData\Local\at
//om\bin;C:\Users\Administrator\AppData\Local\Programs\Fiddler;D:\Fiddler;D:\eclipse-jee-oxygen-1a-win32-x86_64\eclipse;;.
//java.specification.name = Java Platform API Specification
//java.class.version = 52.0
//sun.management.compiler = HotSpot 64-Bit Tiered Compilers
//os.version = 6.1
//user.home = C:\Users\Administrator
//user.timezone =
//java.awt.printerjob = sun.awt.windows.WPrinterJob
//file.encoding = UTF-8
//java.specification.version = 1.8
//user.name = Administrator
//java.class.path = D:\java\jdk1.8.0_121\jre\lib\resources.jar;D:\java\jdk1.8.0_121\jre\lib\rt.jar;D:\java\jdk1.8.0_121\jre\lib\jsse.jar;D:\java\jdk1.8.
//0_121\jre\lib\jce.jar;D:\java\jdk1.8.0_121\jre\lib\charsets.jar;D:\java\jdk1.8.0_121\jre\lib\jfr.jar;D:\java\jdk1.8.0_121\jre\lib\ext\access-bridge-64
//.jar;D:\java\jdk1.8.0_121\jre\lib\ext\cldrdata.jar;D:\java\jdk1.8.0_121\jre\lib\ext\dnsns.jar;D:\java\jdk1.8.0_121\jre\lib\ext\jaccess.jar;D:\java\jdk
//1.8.0_121\jre\lib\ext\jfxrt.jar;D:\java\jdk1.8.0_121\jre\lib\ext\localedata.jar;D:\java\jdk1.8.0_121\jre\lib\ext\nashorn.jar;D:\java\jdk1.8.0_121\jre\
//lib\ext\sunec.jar;D:\java\jdk1.8.0_121\jre\lib\ext\sunjce_provider.jar;D:\java\jdk1.8.0_121\jre\lib\ext\sunmscapi.jar;D:\java\jdk1.8.0_121\jre\lib\ext
//\sunpkcs11.jar;D:\java\jdk1.8.0_121\jre\lib\ext\zipfs.jar;F:\workspace-zhyyu-learn\learn-se\target\classes;C:\Users\Administrator\.m2\repository\org\a
//pache\commons\commons-lang3\3.7\commons-lang3-3.7.jar
//java.vm.specification.version = 1.8
//sun.arch.data.model = 64
//sun.java.command = com.zhyyu.learn.se.sysprops.ManualSetSysPropsTest


/*=======================================/*=======================================/*=======================================/*=======================================*/
//my-property = my-value
/*=======================================/*=======================================/*=======================================/*=======================================*/



//java.home = D:\java\jdk1.8.0_121\jre
//user.language = zh
//java.specification.vendor = Oracle Corporation
//awt.toolkit = sun.awt.windows.WToolkit
//java.vm.info = mixed mode
//java.version = 1.8.0_121
//java.ext.dirs = D:\java\jdk1.8.0_121\jre\lib\ext;C:\Windows\Sun\Java\lib\ext
//sun.boot.class.path = D:\java\jdk1.8.0_121\jre\lib\resources.jar;D:\java\jdk1.8.0_121\jre\lib\rt.jar;D:\java\jdk1.8.0_121\jre\lib\sunrsasign.jar;D:\ja
//va\jdk1.8.0_121\jre\lib\jsse.jar;D:\java\jdk1.8.0_121\jre\lib\jce.jar;D:\java\jdk1.8.0_121\jre\lib\charsets.jar;D:\java\jdk1.8.0_121\jre\lib\jfr.jar;D
//:\java\jdk1.8.0_121\jre\classes
//java.vendor = Oracle Corporation
//file.separator = \
//java.vendor.url.bug = http://bugreport.sun.com/bugreport/
//sun.io.unicode.encoding = UnicodeLittle
//sun.cpu.endian = little
//sun.desktop = windows
//sun.cpu.isalist = amd64
//
//VM Flags:
//Non-default VM flags: -XX:CICompilerCount=3 -XX:InitialHeapSize=268435456 -XX:MaxHeapSize=4269801472 -XX:MaxNewSize=1422917632 -XX:MinHeapDeltaBytes=5
//24288 -XX:NewSize=89128960 -XX:OldSize=179306496 -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:+UseFastUnorderedTimeStamps -XX:-UseLargeP
//agesIndividualAllocation -XX:+UseParallelGC
//Command line:  -Dfile.encoding=UTF-8
