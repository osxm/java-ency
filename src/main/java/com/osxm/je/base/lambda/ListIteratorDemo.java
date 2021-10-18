/**  
* @Title: ListIteratorDemo.java
* @Package com.osxm.je.base.lambda
* @Description: TODO
* @author XM
* @date 2021年9月14日 下午9:40:59
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.je.base.lambda;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * @ClassName ListIteratorDemo
 * @Description TODO
 * @author XM 
 * @date 2021年9月14日
 * 
 */
public class ListIteratorDemo {

	@Test
	public void listIterator(){
		List<String> list = Arrays.asList("str1","str2","str3");
		for(int i=0;i<list.size();i++) {
			System.out.println("listIterator: without lambda expression"+list.get(i));
		}
		
		for(String str:list) {
			System.out.println("listIterator: without lambda expression"+str);
		}
	}
	
	@Test
	public void listIteratorWithLambda(){
		List<String> list = Arrays.asList("str1","str2","str3");
		list.forEach(str->System.out.println("listIterator: use lambda expression"+str));
	}
}
