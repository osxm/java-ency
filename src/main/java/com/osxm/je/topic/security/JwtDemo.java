/**
* @Title: JwtDemo.java
* @Package com.osxm.je.topic.security
* @Description: TODO
* @author XM
* @date 2023年8月6日 下午10:23:29
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.je.topic.security;

import java.security.Key;
import java.util.Date;

import org.junit.Test;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtDemo {

	// @formatter:off
	@Test
	public void genJwtToken() {
		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		String jwtToken = Jwts.builder().setSubject("JWT Demo") // 设置主题（Subject）
				.claim("userId", "oscar").claim("role", "admin")
				.signWith(key) // 使用指定的算法和密钥签名
				.compact();
		System.out.println("jwtToken="+jwtToken);
	}
	// @formatter:on
	
	
	// @formatter:off
	@Test
	public void tokenWithExpired() {
		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		Date expiration = new Date(System.currentTimeMillis() + 3600 * 1000); // 设置过期时间为1小时后
		String jwtToken = Jwts.builder().setSubject("JWT Demo") // 设置主题（Subject）
				.setExpiration(expiration) //设置过期时间
				.claim("userId", "oscar").claim("role", "admin")
				.signWith(key) // 使用指定的算法和密钥签名
				.compact();
		System.out.println("jwtToken="+jwtToken);
	}
	// @formatter:on

}
