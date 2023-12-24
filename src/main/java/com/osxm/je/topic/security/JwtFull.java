/**
* @Title: JwtFull.java
* @Package com.osxm.je.topic.security
* @Description: TODO
* @author XM
* @date 2023年9月6日 上午6:04:37
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.je.topic.security;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Mac;

import org.junit.jupiter.api.Test;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JwtFull {

	
	@Test
	public void javaBaseGenJwt()
			throws NoSuchAlgorithmException, InvalidKeyException, IllegalStateException, UnsupportedEncodingException {
		String header = "{\"alg\":\"HS256\"}";
		String payload = "{\"sub\":\"myapp\",\"name\":\"oscar\"}";
		Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		String encodedHeader = Base64.getEncoder().encodeToString(header.getBytes());
		String encodedPayload = Base64.getEncoder().encodeToString(payload.getBytes());
		String concatenated = encodedHeader + '.' + encodedPayload;

		Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
		sha256_HMAC.init(secretKey);
		byte[] signature = sha256_HMAC.doFinal(concatenated.getBytes("utf-8"));
		String compact = concatenated + '.' + Base64.getEncoder().encodeToString(signature);
		System.out.println(compact);
	}
	
	@Test
	public void jjwt()
			throws NoSuchAlgorithmException, InvalidKeyException, IllegalStateException, UnsupportedEncodingException {
		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		String jwtToken = Jwts.builder().setSubject("myapp") // 设置主题（Subject）
				.claim("name", "oscar").claim("role", "admin").signWith(key) // 使用指定的算法和密钥签名
				.compact();
		System.out.println("jjwt="+jwtToken);
	}
	
	
}
