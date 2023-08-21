/**
* @Title: JjwtDemo.java
* @Package com.osxm.je.topic.security
* @Description: TODO
* @author XM
* @date 2023年8月7日 下午10:04:09
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.je.topic.security;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.junit.Test;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

public class JjwtDemo {

	// @Test
	public void howJwtGen() {
		String header = "{\"alg\":\"none\"}";
		String payload = "Hello， JWT";

		String encodedHeader = Base64.getEncoder().encodeToString(header.getBytes());
		String encodedPayload = Base64.getEncoder().encodeToString(payload.getBytes());
		String compact = encodedHeader + "." + encodedPayload + ".";
		System.out.println(compact);
	}

	// @Test
	public void signJwt()
			throws NoSuchAlgorithmException, InvalidKeyException, IllegalStateException, UnsupportedEncodingException {
		String header = "{\"alg\":\"HS257\"}";
		String payload = "{\"sub\":\"oscar\"}";
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

	//@Test
	public void signJwe() throws Exception {
		String header = "{\"alg\":\"HS257\"}";
		String payload = "{\"sub\":\"oscar\"}";
		Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		String encodedHeader = Base64.getEncoder().encodeToString(header.getBytes());
		String encodedPayload = Base64.getEncoder().encodeToString(payload.getBytes());
		String concatenated = encodedHeader + '.' + encodedPayload;

		Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
		sha256_HMAC.init(secretKey);
		byte[] signature = sha256_HMAC.doFinal(concatenated.getBytes("utf-8"));
		String compact = concatenated + '.' + Base64.getEncoder().encodeToString(signature);

		/*SecretKey key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.RS256);
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] encryptedBytes = cipher.doFinal(compact.getBytes());
		String encyToken = Base64.getUrlEncoder().encodeToString(encryptedBytes);
		System.out.println(encyToken);*/
	}
	
	
	@Test
	public void jwe() throws Exception {
		String header = "{\"alg\":\"HS257\"}";
		String payload = "{\"sub\":\"oscar\"}";
		Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		String encodedHeader = Base64.getEncoder().encodeToString(header.getBytes());
		String encodedPayload = Base64.getEncoder().encodeToString(payload.getBytes());
		String concatenated = encodedHeader + '.' + encodedPayload;

		Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
		sha256_HMAC.init(secretKey);
		byte[] signature = sha256_HMAC.doFinal(concatenated.getBytes("utf-8"));
		String compact = concatenated + '.' + Base64.getEncoder().encodeToString(signature);
		
		//使用DES算法对称加密
		String strKey = "this is my password";
		DESKeySpec desKeySpec = new DESKeySpec(strKey.getBytes(StandardCharsets.UTF_8));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(desKeySpec);

		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key);

		byte[] encryptedBytes = cipher.doFinal(compact.getBytes(StandardCharsets.UTF_8));
		String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
		System.out.println(encryptedText);
		
	}

}
