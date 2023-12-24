/**
* @Title: FloatDemo.java
* @Package com.osxm.je.base.datatype
* @Description: TODO
* @author XM
* @date 2023年10月25日 下午10:17:28
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.je.base.datatype;

import org.junit.jupiter.api.Test;

public class FloatDemo {
	
	@Test
	public void floatAdd() {
		float f1 = (float)1.1;
		float f2 = (float)1.2;
		float f3 = (float)1.3;
 
	    float f4 = f1+f2+f3;
	    System.out.println(f4);
	    
	    System.out.println(1.1+1.2+1.0); //3.3	    	    
	    System.out.println(1.1+1.2+1.2); //3.5
	    System.out.println(1.1+1.2+1.3); //3.5999999999999996	    
	    System.out.println(1.1+1.2+1.4); //3.6999999999999997
	}

}
