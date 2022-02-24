/**  
* @Title: HttpsCallTests.java
* @Package com.osxm.je.topic.httpclient
* @Description: TODO
* @author XM
* @date 2022年2月16日 下午9:51:50
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.je.topic.httpclient;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

public class HttpsCallTests {

	// @Test
	public void httpsLocal() throws Exception {
		String url = "https://localhost:8443/";
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
			HttpGet httpGet = new HttpGet(url);
			try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
				System.out.println(response.getStatusLine()); // 获取响应状态,比如 HTTP/1.1 200 OK
				HttpEntity entity = response.getEntity(); // 获取响应结果
				String rtn = EntityUtils.toString(entity); // 将结果转换为字符串
				System.out.println(rtn);
				EntityUtils.consume(entity); // 如果返回内容是输入流类型， 关闭输入流
			}
		}
	}

	// @Test
	public void httpsTrustAll() throws Exception {
		String url = "https://localhost:8443/";
		SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
			public boolean isTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
				return true;
			}
		}).build();
		SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(sslContext,
				NoopHostnameVerifier.INSTANCE);
		CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();
		HttpGet httpGet = new HttpGet(url);
		try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
			System.out.println(response.getStatusLine()); // 获取响应状态,比如 HTTP/1.1 200 OK
			HttpEntity entity = response.getEntity(); // 获取响应结果
			String rtn = EntityUtils.toString(entity); // 将结果转换为字符串
			System.out.println(rtn);
			EntityUtils.consume(entity); // 如果返回内容是输入流类型， 关闭输入流
		}
	}

	@Test
	public void httpsNoCheck() throws Exception {
		String url = "https://localhost:8443/";
		X509TrustManager trustManager = new X509TrustManager() {
			@Override
			public X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			@Override
			public void checkClientTrusted(X509Certificate[] xcs, String str) {
			}

			@Override
			public void checkServerTrusted(X509Certificate[] xcs, String str) {
			}
		};
		SSLContext ctx = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
		ctx.init(null, new TrustManager[] { trustManager }, null);
		SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(ctx,
				NoopHostnameVerifier.INSTANCE);
		CloseableHttpClient httpclient = HttpClients.custom().setSSLSocketFactory(sslSocketFactory).build();
		HttpGet httpGet = new HttpGet(url);
		try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
			System.out.println(response.getStatusLine()); // 获取响应状态,比如 HTTP/1.1 200 OK
			HttpEntity entity = response.getEntity(); // 获取响应结果
			String rtn = EntityUtils.toString(entity); // 将结果转换为字符串
			System.out.println(rtn);
			EntityUtils.consume(entity); // 如果返回内容是输入流类型， 关闭输入流
		}
	}

	// @Test
	public void https() throws Exception {
		String url = "https://free-api.heweather.com/v5/forecast?city=CN101220101&key=5c043b56de9f4371b0c7f8bee8f5b75e";
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
			HttpGet httpGet = new HttpGet(url);
			try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
				System.out.println(response.getStatusLine()); // 获取响应状态,比如 HTTP/1.1 200 OK
				HttpEntity entity = response.getEntity(); // 获取响应结果
				String rtn = EntityUtils.toString(entity); // 将结果转换为字符串
				System.out.println(rtn);
				EntityUtils.consume(entity); // 如果返回内容是输入流类型， 关闭输入流
			}
		}
	}

}
