/**  
* @Title: JdbcDemo.java
* @Package com.osxm.je.topic.jdbc
* @Description: TODO
* @author XM
* @date 2022年6月8日 下午10:17:10
* @Copyright: 2022
* @version V1.0  
*/
package com.osxm.je.topic.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JdbcDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {	
		String url = "jdbc:mysql://localhost:3306/jpaency?useUnicode=true&characterEncoding=utf8";
		String username = "root";
		String password = "123456";
		//Class.forName("com.mysql.cj.jdbc.Driver"); 不需要
		//1. 获取连接
		Connection conn = DriverManager.getConnection(url,username,password);
		//2. 创建语句对象
		Statement  stmt = conn.createStatement();
        String sql;
        sql = "SELECT id, name FROM USR";
        //3. 执行查询，获取结果集
        ResultSet rs = stmt.executeQuery(sql);
    
        // 4. 展开结果集
        while(rs.next()){
            // 通过字段检索
            int id  = rs.getInt("id");
            String name = rs.getString("name");

            // 输出数据
            System.out.print("ID: " + id);
            System.out.print(", 名称: " + name);
            System.out.print("\n");
        }
        // 5. 完成后关闭资源和连接
        rs.close();
        stmt.close();
        conn.close();
	}

}
