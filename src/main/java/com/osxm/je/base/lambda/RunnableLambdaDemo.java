/**  
* @Title: RunnableLambdaDemo.java
* @Package com.osxm.je.base.lambda
* @Description: TODO
* @author XM
* @date 2021年9月14日 下午9:29:54
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.je.base.lambda;

import org.junit.jupiter.api.Test;

/**
 * @ClassName RunnableLambdaDemo
 * @Description TODO
 * @author XM 
 * @date 2021年9月14日
 * 
 */
public class RunnableLambdaDemo {

	@Test
	public void runnableThread() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("runnable:without lambda expression");
			}
		}).start();
	}
	
	@Test
	public void runnableThreadWithLambda() {
		new Thread(() -> System.out.println("runnable:use lambda expression")).start();
	}

}
