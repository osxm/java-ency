/**  
* @Title: CollectInitial.java
* @Package com.osxm.je.chp1
* @Description: TODO
* @author XM
* @date 2023年5月25日 下午9:36:22
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.je.chp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CollectionInitial {
	
	@Test
	public void strArrayInit() {		
		String[] strArray = new String[3] ;
		strArray[0] = "1";
		strArray[1] = "2";
		strArray[2] = "3";
		Assertions.assertTrue(strArray.length==3);
	}

	@Test
	public void strArrayInitQuick() {		
		String[] strArray = new String[] {"1","2","3"};
		Assertions.assertTrue(strArray.length==3);
	}
	
	
	@Test
	public void listInit() {		
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
	}
	
	@Test
	public void listInitQuick() {		
		List<String> list = Arrays.asList("1","2","3");
		Assertions.assertTrue(list.size()==3);
	}
	
	
	
	@Test
	public void mapInit() {		
		Map<String,String> map = new HashMap<String,String>();
		map.put("key1", "1");
		map.put("key2", "2");
		map.put("key3", "3");
	}
	@Test
	public void mapInitQuick() {		
		Map<String,String> map = new HashMap<String,String>(){{
			put("key1", "1");
			put("key2", "2");
			put("key3", "3");
		}};
		Assertions.assertTrue(map.keySet().size()==3);
	}
	
}
