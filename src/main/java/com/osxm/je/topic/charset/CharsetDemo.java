/**
* @Title: CharsetDemo.java
* @Package com.osxm.je.topic.charset
* @Description: TODO
* @author XM
* @date 2023年9月26日 下午10:29:09
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.je.topic.charset;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

public class CharsetDemo {
	
	@Test
	public void charaset() {
		System.out.println(System.getProperty("file.encoding"));  
		System.out.println(Charset.defaultCharset());
	}
	
	
	//@Test
	public void callOSCmd() throws Exception {
		Runtime rt = Runtime.getRuntime();
		Process pr = rt.exec("cmd.exe /c cd errorpath");
		int exitCode = pr.waitFor();   // 等待进程完成，然后获取返回码
		if (exitCode == 0) {
		    System.out.println("命令执行成功!");
		} else {
		    System.out.println("命令执行失败, 返回码: " + exitCode);
		    //try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pr.getErrorStream()))) {
		    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(pr.getErrorStream(),StandardCharsets.UTF_8))) {
		        String line;
		        StringBuilder content = new StringBuilder();
		        while ((line = bufferedReader.readLine()) != null) {
		            content.append(line);
		            content.append(System.lineSeparator()); // 添加行分隔符，如果需要的话
		        }
		        String errorText = content.toString();	        
		        // 打印或处理错误消息
		        System.out.println("错误信息："+errorText);
		    }
		}
	}

}
