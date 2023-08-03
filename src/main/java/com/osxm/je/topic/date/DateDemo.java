/**
* @Title: DateDemo.java
* @Package com.osxm.je.topic.date
* @Description: TODO
* @author XM
* @date 2023年8月2日 下午11:01:07
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.je.topic.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.Test;



public class DateDemo {

	@Test
	public void getTimeStamp() {
		LocalDateTime dateTime = LocalDateTime.of(1970, 1, 1, 0, 0, 0);// 获取时间戳（秒数）
		long timestamp = dateTime.toEpochSecond(ZoneOffset.UTC);// 设置时区后获取时间戳
		System.out.println("Timestamp: " + timestamp); // 0, 时间戳从1970/01/01开始
	}

	@Test
	public void currentTimeStamp() {
		long timestamp = System.currentTimeMillis();
		System.out.println("Current Timestamp: " + timestamp);
	}
	
	/** 
	 * 北京时间的 1970/01/01 8点 是开始
	 */
	@Test
	public void zoneTimeStamp(){
		ZonedDateTime utc8DateTime= ZonedDateTime.of(1970, 1, 1, 8, 0, 0,0, ZoneId.of("UTC+8"));
		long timestamp =utc8DateTime.toEpochSecond();
		Assert.assertEquals(0, timestamp);
		
		LocalDateTime lcoalDateTime = LocalDateTime.of(1970, 1, 1, 8, 0, 0);
		ZonedDateTime zonedDateTime = ZonedDateTime.of(lcoalDateTime, ZoneId.of("UTC+8"));
		timestamp =zonedDateTime.toEpochSecond();
		Assert.assertEquals(0, timestamp);
	}
	
	
	@Test
	public void dateTimeformatter() {
		LocalDateTime lcoalDateTime = LocalDateTime.of(1970, 1, 1, 8, 0, 0);
		ZonedDateTime zonedDateTime = ZonedDateTime.of(lcoalDateTime, ZoneId.of("UTC+8"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
		String lcoalDateTimeStr = formatter.format(lcoalDateTime);
		Assert.assertEquals("1970-01-01 08:00:00", lcoalDateTimeStr);
		
		String zonedDateTimeStr =  formatter.format(zonedDateTime);
		Assert.assertEquals("1970-01-01 08:00:00", zonedDateTimeStr);
	}
	
	@Test
	public void getCurrentUtc8Time() {
        // 获取UTC+8时区
        ZoneId utc8ZoneId = ZoneId.of("UTC+8");
        // 获取当前时间
        ZonedDateTime now = ZonedDateTime.now(utc8ZoneId);
        // 格式化为字符串
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");     
        String currentTime = now.format(formatter);
        // 输出时间
        System.out.println("Current time in UTC+8: " + currentTime);
	}
	
	
	/**
	 * 时间戳转换为UTC时间
	 */
	@Test
	public void timeMillisToUtc() {
		long timeMillis = 0L;
		Instant instant = Instant.ofEpochMilli(timeMillis);
		LocalDateTime utcDateTime = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String utcTime = utcDateTime.format(formatter);
		System.out.println("Current UTC time: " + utcTime);
	}
}
