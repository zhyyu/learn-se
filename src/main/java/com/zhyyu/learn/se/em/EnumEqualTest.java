package com.zhyyu.learn.se.em;

/**
 * 测试枚举相等运算符
 * <pre>
 * 1. 可直接使用 ==
 * @author zhyyu2016
 *
 */
public class EnumEqualTest {

	public static void main(String[] args) {
		WeatherEnum1 sunnyEnum1 = WeatherEnum1.SUNNY;
		WeatherEnum1 sunnyEnum2 = WeatherEnum1.SUNNY;
		
		boolean equals = sunnyEnum1 == sunnyEnum2;
		System.out.println(equals);
		
	}
	
	// old enum
	private enum WeatherEnum1 {
		SUNNY, RAINY, CLOUDY
	}
	
}
