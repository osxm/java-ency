/**  
* @Title: APITests.java
* @Package com.osxm.jpa.api
* @Description: TODO
* @author XM
* @date 2022年6月9日 上午6:38:39
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.je.topic.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.osxm.je.topic.jpa.entity.Usr;

public class APITests {

	private static EntityManagerFactory entityManagerFactory;
	
	private static EntityManager entityManager;
	
	@Test
	public void find() {
		Usr usr = entityManager.find(Usr.class, 1);
		usr.setName("刘备");
		Assertions.assertEquals("刘备",usr.getName());
	}
	
	/**
	 * 调试方式运行
	 * Debug As --> JUnit Test
	 */
	//@Test
	public void refresh() {
		Usr usr = entityManager.find(Usr.class, 1);
		usr.setName("刘备");
		Assertions.assertEquals("刘备",usr.getName());
		//下面一行代码添加断点， 手动修改Db, 刘备-> 刘玄德，或者执行 update Usr set name='刘玄德' where id=1;
		//如果不Refresh ,则取不到最新值
		entityManager.refresh(usr);
		Assertions.assertEquals("刘玄德",usr.getName());
	}
	
	
	//@Test
	public void persist() {
		Usr usr = new Usr();
		usr.setId(4);
		usr.setName("赵云");
		entityManager.getTransaction().begin();
		entityManager.persist(usr);
		entityManager.getTransaction().commit();//主键手动设置，事务提交时发送SQL 
		System.out.println("Done");
	}
	
	//@Test
	public void merge() {
		Usr usr = new Usr();
		usr.setId(4);
		usr.setName("赵云");
		entityManager.getTransaction().begin();
		entityManager.merge(usr);
		entityManager.getTransaction().commit();
	}
	
	//@Test
	public void flush() {
		Usr usr = entityManager.find(Usr.class,4);
		usr.setName("赵云3");
		entityManager.getTransaction().begin();	
		entityManager.flush(); //如果对象有改动，此句会发出更新语句
		entityManager.getTransaction().commit();
		
	}
	
	@Test
	public void detachAfterCommit() {
		Usr usr = new Usr();
		usr.setId(4);
		usr.setName("赵云");
		entityManager.getTransaction().begin();
		entityManager.merge(usr);
		entityManager.getTransaction().commit();
		Assertions.assertTrue(!entityManager.contains(usr));
	}
	
	
	
	@BeforeAll
	public static void setup() {
		String persistenceUnitName = "jpaency_mysql";
		 entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
		 entityManager = entityManagerFactory.createEntityManager();		
	}
	
	
	@AfterAll
	public static void destroy() {
		entityManager.close();
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
	    }
	}
}
