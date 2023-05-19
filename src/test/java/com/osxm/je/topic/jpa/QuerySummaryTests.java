/**  
* @Title: QuerySummaryTests.java
* @Package com.osxm.je.topic.jpa
* @Description: TODO
* @author XM
* @date 2022年6月15日 上午6:31:57
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.je.topic.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.osxm.je.topic.jpa.entity.Usr;

public class QuerySummaryTests {

	private static EntityManagerFactory entityManagerFactory;

	private static EntityManager entityManager;

	// 1. SQL 语句查询
	@Test
	public void nativeQuery() {
		String sql = "select name from USR";
		//1. 查找单个字段
		@SuppressWarnings("unchecked")
		List<String> list = entityManager.createNativeQuery(sql).getResultList();
		if (list != null) {
			for (Object obj : list) {
				System.out.println(obj.toString());
			}
		}
		
		//2. 查找多个字段
		sql = "select * from USR";
		list = entityManager.createNativeQuery(sql).getResultList();
		if (list != null) {
			for(Object row:list) {
				Object[] cells = (Object[])row;
				System.out.println(cells[0]+":"+cells[1]);
			}
		}
		
		//3. 直接转换类型
		sql = "select * from USR";
		List<Usr> usrList = entityManager.createNativeQuery(sql,Usr.class).getResultList();
		if (usrList != null) {
			for(Usr usr:usrList) {
				System.out.println(usr.getName());
			}
		}

	}
	
	
	//2. JPQL 查询
	@Test
	public void jpqlQuery() {
		//查询单个属性
		String jqpl = "select u.name from Usr u where u.id=1";
		String name = entityManager.createQuery(jqpl,String.class).getSingleResult();
		Assertions.assertEquals("刘备", name);
		
		//查询对象
		 jqpl = "from Usr u where u.id=1";
		 Usr usr =  entityManager.createQuery(jqpl,Usr.class).getSingleResult();
		 Assertions.assertEquals("刘备", usr.getName());	
	}

	
	//3. Criteria API 查询
	@Test
    public void criteriaQuery() {
		//1. 通过实体管理器构造条件构造器
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		//2. 通过条件构造器构造条件查询对象
		CriteriaQuery<Usr> criteriaQuery = criteriaBuilder.createQuery(Usr.class);
		//3. 条件查询对象从哪查询， 相对于 from 子句
		Root<Usr> root = criteriaQuery.from(Usr.class);
	    //4. 查询条件的列表 ， 也就是where 子句后面的条件
		Predicate  predicate = criteriaBuilder.equal(root.get("id"),1);
		criteriaQuery.where(predicate); 
		//criteriaQuery.select(root); //查询结果， 相对于 select *
		//5. 使用构造的条件查询对象查询
		List<Usr> usrList = entityManager.createQuery(criteriaQuery).getResultList();
		Assertions.assertEquals(usrList.get(0).getName(), "刘备");
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
