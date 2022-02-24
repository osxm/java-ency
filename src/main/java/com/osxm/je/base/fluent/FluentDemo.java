/**  
* @Title: FluentDemo.java
* @Package com.osxm.je.base.fluent
* @Description: TODO
* @author XM
* @date 2022年1月18日 下午9:31:24
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.je.base.fluent;

public class FluentDemo {
	
	public static void main(String[] args) {
		//一般初始化
		//Usr usr = new Usr();
	    //usr.setName("张三");
	    //usr.setAge(20);
	    
	    //流畅API 
	    Usr usr = Usr.build().setName("张三").setAge(20);
	}
}
