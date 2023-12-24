/**
* @Title: OsCommand.java
* @Package com.osxm.je.topic.os
* @Description: TODO
* @author XM
* @date 2023年9月27日 下午10:13:09
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.je.topic.os;

import org.junit.jupiter.api.Test;

public class OsCommand {

	//@Test
	public void runtimeExec() throws Exception{
		Runtime rt = Runtime.getRuntime();
		Process pr = rt.exec("cmd.exe /c dir D:\\temp");
	    int exitCode = pr.waitFor();
	    System.out.println("命令执行结果：" + exitCode);
	}
	
	@Test
	public void processBuilder() throws Exception{
		String command = "cmd.exe /c dir D:\\temp";
	    ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
	    // 将命令输出重定向到标准输出
	    processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
	    // 执行命令
	    Process process = processBuilder.start();
	    // 等待命令执行完成
	    int exitCode = process.waitFor();
	    System.out.println("命令执行结果：" + exitCode);
	}
}
