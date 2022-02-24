/**  
* @Title: StreamTests.java
* @Package com.osxm.je.basic.advance
* @Description: TODO
* @author XM
* @date 2022年2月24日 下午10:02:00
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.je.basic.advance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class StreamTests {

	@Test
	public void create() throws Exception {
		// 1. 使用Collection的stream()和parallelStream()方法创建流
		List<String> list = Arrays.asList("Java6", "Java7", "Java8");
		// 创建顺序流
		Stream<String> stream = list.stream();

		// 创建并行流
		Stream<String> parallelStream = list.parallelStream();

		// 2.使用Arrays的stream()方法，将数组转化成流
		String[] strs = new String[5];
		Stream<String> stream1 = Arrays.stream(strs);

		// 3. 使用Stream的静态方法 ： of()、iterate()、generate()
		Stream<Integer> stream11 = Stream.of(1, 2, 3, 4, 5);

		Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 2).limit(6);// 从0开始的6个整数，每个数加2
		stream2.forEach(System.out::println);

		Stream<Double> stream3 = Stream.generate(Math::random).limit(3); // 3个随机的双浮点数
		stream3.forEach(System.out::println);

		// 4. 将文件的每行转换为流
		BufferedReader reader = new BufferedReader(new FileReader("D:\\bak\\stream.txt"));
		Stream<String> lineStream = reader.lines();
		lineStream.forEach(System.out::println);

		// 5. 使用模式类Pattern 将字符串分割成流
		Pattern pattern = Pattern.compile(",");
		Stream<String> strStream = pattern.splitAsStream("1,2,3,4");
		strStream.forEach(System.out::println);
	}

	@Test
	public void intermediateOperation() {
		// 2.1 筛选
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
		stream = stream.filter(i -> i > 3); // 4,5 . 过滤大于3的数
		stream.forEach(System.out::println);

		stream = stream.limit(2); // 取前两个元素

		stream = stream.skip(2);

		stream = stream.distinct().skip(2).limit(2).filter(i -> i > 3);

		// 2.2 映射
		stream = Stream.of(1, 2, 3, 4, 5);
		stream = stream.map(i -> i + 1); // 2,3,4,5,6
		stream.forEach(System.out::println);

		stream = Stream.of(1, 2, 3, 4, 5);
		stream = stream.flatMap(i -> {
			return Stream.of(i, i + 1);
		}); // 每个元素再转换为一个Stream, 逻辑可以自行编写
		stream.forEach(System.out::println);

		// 2.3 排序
		stream = Stream.of(5, 4, 3, 2, 1);
		stream = stream.sorted();
		stream.forEach(System.out::println);

		stream = Stream.of(5, 4, 3, 2, 1);
		stream = stream.sorted((o1, o2) -> {
			return o1 - o2; // 返回值整型
		});
		stream.forEach(System.out::println);

		// 2.4 消费
		stream = Stream.of(1, 2, 3, 4, 5);
		stream = stream.map(i -> {
			return i = i + 1;
		}); // 2,3,4,5,6
		stream = stream.peek(i -> {
			i = i + 1;
		}); // 2,3,4,5,6
		stream.forEach(System.out::println);
	}

	@Test
	public void terminalOperation() {
       //3.1 匹配、聚合
		Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
		boolean allMatch = stream.allMatch(i -> i > 3);
		boolean noneMatch = stream.noneMatch(i -> i > 3);
		boolean anyMatch = stream.anyMatch(i -> i > 3);

		int first = stream.findFirst().get();
		int any = stream.findAny().get();

		long count = stream.count();
		Integer max = stream.max(Integer::compareTo).get();
		Integer min = stream.min(Integer::compareTo).get();
		
		//3.2 规约操作reduce
        stream = Stream.of(1,2,3,4,5);
        Integer i = stream.reduce((i1,i2)-> i1+i2).get(); 
        //1+2 ,3+3,6+4,10+5=15
        System.out.println(i);
        
        stream = Stream.of(1,2,3,4,5);
        i = stream.reduce(10,(i1,i2)-> i1+i2); 
        //10+1 ,11+2,13+3,16+4,20+5=25
        System.out.println(i);
        
        //3.3 转换成集合
        stream = Stream.of(1,2,3,4,5);
        //转换成List
        List<Integer> list = stream.collect(Collectors.toList());
        System.out.println(list.toString()); //[1, 2, 3, 4, 5]
        
        stream = Stream.of(1,2,3,4,5);
        //转换成Set
        Set<Integer> set = stream.collect(Collectors.toSet());
        System.out.println(set.toString()); //[1, 2, 3, 4, 5]
        
        stream = Stream.of(1,2,3,4,5);
        //转换成map
        Map<Integer,Integer> map = stream.collect(Collectors.toMap((Integer j) -> j, (Integer j) -> j));
        System.out.println(map.toString()); //{1=1, 2=2, 3=3, 4=4, 5=5}
	}

}
