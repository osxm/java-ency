/**
* @Title: CucumberTest.java
* @Package com.osxm.je.topic.bdd
* @Description: TODO
* @author XM
* @date 2023年10月9日 下午10:05:35
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.je.topic.bdd;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources")  // 要测试的 Feature 文件的位置
public class CucumberTest {
	
	
}