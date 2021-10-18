/**  
* @Title: LambdaTests.java
* @Package com.osxm.je.lambda
* @Description: TODO
* @author XM
* @date 2021年9月10日 下午9:06:55
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.je.base.lambda;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @ClassName LambdaTests
 * @Description TODO
 * @author XM 
 * @date 2021年9月10日
 * 
 */
public class LambdaTests {

	@Test
	public void noReturnNoParam() {
		NoReturnNoParamI noReturnNoParam = ()->{System.out.println("noReturnNoParam");};
		// 只有一个语句的方法体可以省略大括号
		noReturnNoParam = ()->System.out.println("noReturnNoParam");
		noReturnNoParam.method();
	}
	
	@Test
	public void noReturnSingleParam() {
		NoReturnSingleParamI noReturnSingleParam = (String param)-> System.out.println("noReturnSingleParam,param="+param);
		//单个参数可以省略大括号， 也可以省略类型
		noReturnSingleParam = param-> System.out.println("noReturnSingleParam,param="+param);
		noReturnSingleParam.method("Hello");
	}
	
	@Test
	public void noReturnMultiParam() {
		NoReturnMultiParamI noReturnMultiParam = (String param1,String param2) -> System.out.println("noReturnMultiParam,param1="+param1+";param2="+param2);
		noReturnMultiParam.method("张三","李四");
	}
	
	@Test
	public void hasReturnNoParam() {
		HasReturnNoParamI hasReturnNoParam = ()-> {
			System.out.println("noReturnNoParam");
			return "Success";
		};
		String rtn = hasReturnNoParam.method();
		Assertions.assertTrue(rtn.equals("Success"));	
	}
	
	@Test
	public void hasReturnSingleParam() {
		HasReturnSingleParamI hasReturnSingleParam = (String param)-> {
			System.out.println("hasReturnSingleParam,param="+param);
			return "Success";
		};
		String rtn = hasReturnSingleParam.method("Hello");
		Assertions.assertTrue(rtn.equals("Success"));	
	}
	
	@Test
	public void hasReturnMultiParam() {
		HasReturnMultiParamI hasReturnMultiParam= (String param1,String param2)-> {
			System.out.println("hasReturnMultiParam,param1="+param1+";param2="+param2);
			return "Success";
		};
		String rtn = hasReturnMultiParam.method("张三","李四");
		Assertions.assertTrue(rtn.equals("Success"));	
	}
	
	
	public void evolution() {
		String str = "Hello World";
		 
		/*blockOfCode = public void method(String s) {
			              System.out.println(s);
		              };*/
	}
	
}
