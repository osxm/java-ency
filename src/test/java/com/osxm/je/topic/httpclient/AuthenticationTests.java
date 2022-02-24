/**  
* @Title: AuthenticationTests.java
* @Package com.osxm.je.topic.httpclient
* @Description: TODO
* @author XM
* @date 2022年1月3日 下午7:43:44
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.je.topic.httpclient;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

public class AuthenticationTests {

	@Test
	public void test() throws Exception{
		 CredentialsProvider credsProvider = new BasicCredentialsProvider();
		 credsProvider.setCredentials(
	                new AuthScope("httpbin.org", 80),
	                new UsernamePasswordCredentials("user", "passwd"));
		 CloseableHttpClient httpclient = HttpClients.custom()
					.setDefaultCredentialsProvider(credsProvider)
	                .build();
		 try {
			  HttpGet httpget = new HttpGet("http://httpbin.org/basic-auth/user/passwd");
			  CloseableHttpResponse response = httpclient.execute(httpget);
			  try {
				  EntityUtils.toString(response.getEntity());
			  }finally {
				  response.close();
			  }
			 
		 }finally {
			 httpclient.close();
		 }
	}
}
