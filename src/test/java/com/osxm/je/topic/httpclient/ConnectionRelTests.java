/**  
* @Title: ConnRelTests.java
* @Package com.osxm.je.topic.httpclient
* @Description: TODO
* @author XM
* @date 2022年1月3日 上午9:13:22
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.je.topic.httpclient;

import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

public class ConnectionRelTests {

	
	/**
	 * 通过Try 语法释放资源
	 * @throws Exception
	 */
	@Test
	public void byTryRelease() throws Exception {
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) { //3. 关闭客户端资源
		    HttpGet httpGet = new HttpGet("http://www.baidu.com");
		    try (CloseableHttpResponse response = httpclient.execute(httpGet)) { //2. 关闭响应资源    	
		        HttpEntity entity = response.getEntity();			     
		        EntityUtils.consume(entity); //1. 关闭响应流
		    }	  
		}
	}
	
    /**
     * 通过close 方法释放资源
     * @throws Exception
     */
	@Test
	public void byManualRelease() throws Exception{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {		
			HttpGet httpGet = new HttpGet("http://www.baidu.com");
			CloseableHttpResponse response = httpclient.execute(httpGet);
			try {
				 HttpEntity entity = response.getEntity();		
				 EntityUtils.consume(entity); //1. 关闭响应流
			}finally {
				response.close(); //2. 关闭响应资源    	
			}
		}finally {
			httpclient.close();//3. 关闭客户端资源
		}      	          
	}
	
    /**
     * 通过close 方法释放资源, 响应流也手动释放
     * @throws Exception
     */
	@Test
	public void byManualRelease2() throws Exception{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {		
			HttpGet httpGet = new HttpGet("http://www.baidu.com");
			CloseableHttpResponse response = httpclient.execute(httpGet);
			try {
				 HttpEntity entity = response.getEntity();		
				 //EntityUtils.consume(entity); //1. 关闭响应流
				 if (entity != null) {
	                    InputStream inStream = entity.getContent();
	                    try {
	                        inStream.read();
	                    }  finally {
	                        inStream.close();   //1. 关闭响应流
	                    }
	                }
			}finally {
				response.close(); //2. 关闭响应资源    	
			}
		}finally {
			httpclient.close();//3. 关闭客户端资源
		}      	          
	}
}
