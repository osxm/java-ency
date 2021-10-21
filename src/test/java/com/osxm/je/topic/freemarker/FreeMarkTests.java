/**  
* @Title: FreeMarkTests.java
* @Package com.osxm.je.topic.freemarker
* @Description: TODO
* @author XM
* @date 2021年10月21日 下午9:32:51
* @Copyright: 2021
* @version V1.0  
*/
package com.osxm.je.topic.freemarker;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkTests {

	@Test
	public void test() throws Exception {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_31);//设置配置版本	
		cfg.setDefaultEncoding("UTF-8");//设置字符集
		cfg.setDirectoryForTemplateLoading(new File(FreeMarkTests.class.getResource("/").getPath()+"/freemarker")); //设置模板文件目录
		Map<String,Object> root = new HashMap<String,Object>(); // 设置数据
		root.put("user", "oscar");
		Template t = cfg.getTemplate("my.ftl");	// 使用模板文件创建模板对象
		Writer out = new OutputStreamWriter(System.out, "UTF-8"); //控制台输出流对象
		t.process(root, out); //模板结合数据 ， 输出到控制台
	}
}
