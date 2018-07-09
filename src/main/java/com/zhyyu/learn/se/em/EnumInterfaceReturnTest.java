package com.zhyyu.learn.se.em;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 测试 《阿里巴巴JAVA开发手册》 枚举不做接口返回值, 
 * @author Administrator
 *
 * output:
 * <pre>
 * Exception in thread "main" java.io.InvalidObjectException: enum constant SNOWY does not exist in class com.zhyyu.learn.se.em.EnumInterfaceReturnTest$WeatherEnum1
	at java.io.ObjectInputStream.readEnum(ObjectInputStream.java:1958)
	at java.io.ObjectInputStream.readObject0(ObjectInputStream.java:1532)
	at java.io.ObjectInputStream.readObject(ObjectInputStream.java:422)
	at com.zhyyu.learn.se.em.EnumInterfaceReturnTest.main(EnumInterfaceReturnTest.java:48)
Caused by: java.lang.IllegalArgumentException: No enum constant com.zhyyu.learn.se.em.EnumInterfaceReturnTest.WeatherEnum1.SNOWY
	at java.lang.Enum.valueOf(Enum.java:238)
	at java.io.ObjectInputStream.readEnum(ObjectInputStream.java:1955)
	... 3 more
	</pre>
	结论:接口提供方枚举更新, 接口调用方枚举未更新, 调用方接收到提供方新枚举无法使用旧枚举返序列化, 程序报错
	
 * </pre>
 */
public class EnumInterfaceReturnTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		// write old enum 
		/*WeatherEnum1 weatherEnum1 = WeatherEnum1.CLOUDY;
		
		FileOutputStream fileOut =new FileOutputStream("F:\\weatherEnum1");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(weatherEnum1);
		out.close();
		fileOut.close();*/
		
		// read old enum
		/*FileInputStream fileIn = new FileInputStream("F:\\weatherEnum1");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		WeatherEnum1 weatherEnum1ByDeserialization = (WeatherEnum1) in.readObject();
		in.close();
		fileIn.close();
		
		System.out.println(weatherEnum1ByDeserialization);*/
		
		// write new enum
		/*WeatherEnum1 newWeatherEnum1 = WeatherEnum1.SNOWY;
		
		FileOutputStream newFileOut =new FileOutputStream("F:\\newWeatherEnum1");
		ObjectOutputStream newOut = new ObjectOutputStream(newFileOut);
		newOut.writeObject(newWeatherEnum1);
		newOut.close();
		newFileOut.close();*/
		
		// read old enum
		FileInputStream newfileIn = new FileInputStream("F:\\newWeatherEnum1");
		ObjectInputStream newIn = new ObjectInputStream(newfileIn);
		WeatherEnum1 newWeatherEnum1ByDeserialization = (WeatherEnum1) newIn.readObject();
		newIn.close();
		newfileIn.close();
		
		System.out.println(newWeatherEnum1ByDeserialization);
	}
	
	// old enum
	private enum WeatherEnum1 {
		SUNNY, RAINY, CLOUDY
	}
	
	// new enum
	/*private enum WeatherEnum1 {
		SUNNY, RAINY, CLOUDY, SNOWY
	}*/
	
}
