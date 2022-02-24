/**  
* @Title: Base64Tests.java
* @Package com.osxm.je.topic.base64
* @Description: TODO
* @author XM
* @date 2022年1月2日 上午9:06:08
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.je.topic.base64;

import java.io.IOException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/***
 * 123 ->　MTIz
 */
public class Base64Tests {
	
	
	//@Test
	public void jdk8() {
		// 编码
		String encodedStr = java.util.Base64.getEncoder().encodeToString("123".getBytes());
		Assertions.assertEquals(encodedStr, "MTIz");

		// 解码
		byte[] decodeBytes = java.util.Base64.getDecoder().decode("MTIz");
		Assertions.assertEquals(new String(decodeBytes), "123");
	}
	
	//@Test
	public void jdk7() throws IOException {
		String encodedStr =  new sun.misc.BASE64Encoder().encode("123".getBytes());
		Assertions.assertEquals(encodedStr, "MTIz");
		
		byte[] decodeBytes =  new sun.misc.BASE64Decoder().decodeBuffer("MTIz");
		Assertions.assertEquals(new String(decodeBytes), "123");

	}
	
	@Test
	public void apacheCodec() {
		String encodedStr = org.apache.commons.codec.binary.Base64.encodeBase64String("123".getBytes());
		Assertions.assertEquals(encodedStr, "MTIz");
		
		byte[] decodeBytes =   org.apache.commons.codec.binary.Base64.decodeBase64("MTIz");
		Assertions.assertEquals(new String(decodeBytes), "123");	
	}

}
