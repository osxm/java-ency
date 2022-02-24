/**  
* @Title: FluentApiTests.java
* @Package com.osxm.je.topic.httpclient
* @Description: TODO
* @author XM
* @date 2022年1月2日 上午10:34:21
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.je.topic.httpclient;

import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.junit.jupiter.api.Test;

public class FluentApiTests {

	@Test
	public void baseUsage() throws Exception {
		String rtnStr = Request.Get("http://www.baidu.com").execute().returnContent().asString();
		System.out.println(rtnStr);
	}

	@Test
	public void postWithParams() throws Exception {
		Request.Post("http://mydomain/login")
		.bodyForm(Form.form().add("username", "osccar").build())
		.execute().returnContent().asString();
	}
}
