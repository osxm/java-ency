/**  
* @Title: ClientExecuteProxy.java
* @Package com.osxm.je.topic.httpclient
* @Description: TODO
* @author XM
* @date 2022年1月3日 下午7:49:16
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.je.topic.httpclient;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

public class ClientExecuteProxy {

	@Test
	public void demo() throws Exception {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpHost target = new HttpHost("httpbin.org", 443, "https");
			HttpHost proxy = new HttpHost("127.0.0.1", 8080, "http");
			RequestConfig config = RequestConfig.custom().setProxy(proxy).build();
			HttpGet request = new HttpGet("/");
			request.setConfig(config);
			CloseableHttpResponse response = httpclient.execute(target, request);
			try {
				System.out.println("----------------------------------------");
				System.out.println(response.getStatusLine());
				System.out.println(EntityUtils.toString(response.getEntity()));
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}

}
