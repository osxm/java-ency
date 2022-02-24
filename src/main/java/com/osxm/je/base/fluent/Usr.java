/**  
* @Title: Usr.java
* @Package com.osxm.je.base.fluent
* @Description: TODO
* @author XM
* @date 2022年1月18日 下午9:29:14
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.je.base.fluent;

public class Usr {

	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public Usr setName(String name) {
		this.name = name;
		return this;
	}

	public int getAge() {
		return age;
	}

	public Usr setAge(int age) {
		this.age = age;
		return this;
	}
	
	public static Usr build() {
		return new Usr();
	}

}
