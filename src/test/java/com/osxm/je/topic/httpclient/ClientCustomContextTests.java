/**  
* @Title: ClientCustomContextTests.java
* @Package com.osxm.je.topic.httpclient
* @Description: TODO
* @author XM
* @date 2022年1月3日 下午7:52:14
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.je.topic.httpclient;

import java.util.List;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

public class ClientCustomContextTests {

	@Test
	public void demo() throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			CookieStore cookieStore = new BasicCookieStore();
			HttpClientContext localContext = HttpClientContext.create();
			localContext.setCookieStore(cookieStore);
			HttpGet httpget = new HttpGet("http://httpbin.org/cookies");
			CloseableHttpResponse response = httpclient.execute(httpget, localContext);
			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				List<Cookie> cookies = cookieStore.getCookies();
				for (int i = 0; i < cookies.size(); i++) {
					System.out.println("Local cookie: " + cookies.get(i));
				}
				EntityUtils.consume(response.getEntity());
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}

}
