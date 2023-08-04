/**
* @Title: LocalDateTime.java
* @Package com.osxm.je.topic.date
* @Description: TODO
* @author XM
* @date 2023年8月4日 下午10:20:09
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.je.topic.date;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

public class LocalDateTimeDemo {

	@Test
	public void getNow() {
		LocalDateTime now = LocalDateTime.now(); // 获取当前日期和时间
		String str = "";
		str += now.getYear() + "年";
		str += now.getMonthValue() + "月";
		str += now.getDayOfMonth() + "日";
		str += now.getHour() + "时";
		str += now.getMinute() + "分";
		str += now.getSecond() + "秒";
		System.out.println(str);
	}

	@Test
	public void localDateTimeInit() {
		LocalDateTime dateTime = LocalDateTime.of(2023, 8, 8, 23, 59, 59); // 指定日期和时间
	}

	@Test
	public void localDateTimeInit2() {
		LocalDateTime parsedDateTime = LocalDateTime.parse("2023-08-08T23:59:59"); // 解析字符串为LocalDateTime对象
	}

	@Test
	public void modify() {
		LocalDateTime dateTime = LocalDateTime.of(2023, 8, 8, 23, 59, 59); // 指定日期和时间
		LocalDateTime modifiedDateTime = dateTime.withYear(2023); // 修改年份为2023
		LocalDateTime addedDateTime = dateTime.plusDays(1); // 增加一天
		LocalDateTime subtractedDateTime = dateTime.minusHours(2); // 减去两小时
	}

	@Test
	public void format() {
		LocalDateTime dateTime = LocalDateTime.of(2023, 8, 8, 23, 59, 59); // 指定日期和时间
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formattedDateTime = dateTime.format(formatter); // 格式化为字符串
	}

	@Test
	public void calculate() {
		LocalDateTime startDateTime = LocalDateTime.of(2022, 1, 1, 0, 0, 0);
		LocalDateTime endDateTime = LocalDateTime.of(2022, 12, 31, 23, 59, 59);
		Duration duration = Duration.between(startDateTime, endDateTime); // 计算时间间隔
		long minutes = duration.toMinutes(); // 获取分钟数
	}
}
