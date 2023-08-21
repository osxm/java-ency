/**
* @Title: SymmetricEncy.java
* @Package com.osxm.je.topic.security
* @Description: TODO
* @author XM
* @date 2023年8月12日 下午5:16:18
* @Copyright: 2023
* @version V1.0  
*/
package com.osxm.je.topic.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.junit.jupiter.api.Test;

/**
 *  * @ClassName SymmetricEncy  * @Description TODO  * @author XM
 *  * @date 2023年8月12日  *   
 */
public class SymmetricEncy {
	/**
	 * DES 对称加密
	 */
	@Test
	public void desEncrypt() throws Exception {
		String plainText = "需要加密的内容";
		String secretKey = "this is password";
		DESKeySpec desKeySpec = new DESKeySpec(secretKey.getBytes(StandardCharsets.UTF_8));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(desKeySpec);

		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key);

		byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
		String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
		System.out.println("DES加密后的内容=" + encryptedText);
	}

	@Test
	public void desDecrypt() throws Exception {
		String encryptedText = "HAyFHQXRKmihGtxFsrZlAJwla4FE3aqS";
		String secretKey = "this is password";
		DESKeySpec desKeySpec = new DESKeySpec(secretKey.getBytes(StandardCharsets.UTF_8));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey key = keyFactory.generateSecret(desKeySpec);

		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, key);

		byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
		String plainText = new String(decryptedBytes, StandardCharsets.UTF_8);
		System.out.println("DES解密的内容=" + plainText);
	}

	@Test
	public void encryptAES() throws Exception {
		String plainText = "需要加密的内容";
		String secretKey = "this is password";
		SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

		byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
		String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
		System.out.println("AES加密后的内容=" + encryptedText);
	}

	@Test
	public void decryptAES() throws Exception {
		String encryptedText = "oL2b5xULTtAmfi4ujnpw/jPamo0nTNCgRC9Bo+SBz7k=";
		String secretKey = "this is password";
		SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "AES");
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
		byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
		String plainText = new String(decryptedBytes, StandardCharsets.UTF_8);
		System.out.println("AES解密的内容=" + plainText);
	}
}
