package com.osxm.je.topic.security;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

// import sun.misc.BASE64Decoder;
// import sun.misc.BASE64Encoder;

public class PBEDemo {
	  /**
     *算法名称
     */
    public static final String ALGORITHM = "PBEWITHMD5andDES";

     /**
     * 盐初始化
     */
    public static byte[] initSalt() throws Exception { 
        SecureRandom random = new SecureRandom();//实例化安全随机数
        return random.generateSeed(8);//产出盐
    }
    /**
     * 将口令转换为密钥<br>
     *
     * @param password
     * @return
     * @throws Exception
     */
    private static Key toKey(String password) throws Exception {
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
        SecretKey secretKey = keyFactory.generateSecret(keySpec);
        return secretKey;
    }

    /**
     * 加密
     *
     * @param data 数据
     * @param password 密码
     * @param salt  盐
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data, String password, byte[] salt)
            throws Exception {
        Key key = toKey(password);
        PBEParameterSpec paramSpec = new PBEParameterSpec(salt, 100);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
        return cipher.doFinal(data);
    }

    /**
     * 解密
     *
     * @param data  数据
     * @param password 密码
     * @param salt  盐
     * @return
     * @throws Exception
     */
    public static byte[] decrypt(byte[] data, String password, byte[] salt)
            throws Exception {
        Key key = toKey(password);
        PBEParameterSpec paramSpec = new PBEParameterSpec(salt, 100);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
        return cipher.doFinal(data);
    }

    /**
     * BASE64解密
     * @param key
     * @return
     * @throws Exception
     */
//    public static byte[] decryptBASE64(String key) throws Exception {
//        return (new BASE64Decoder()).decodeBuffer(key);
//   }

//     /**
//      * BASE64加密
//      * @param key
//      * @return
//      * @throws Exception
//      */
//     public static String encryptBASE64(byte[] key) throws Exception {
// 		return (new BASE64Encoder()).encodeBuffer(key);
//    }


	public static void main(String[] args) throws Exception {
		String message = "你好";
		String password = "oscar999";
		// //1. 加密
		// byte[] salt = initSalt();
		// byte[] encryBytes = encrypt(message.getBytes(),password,salt);
		// String encryStr = encryptBASE64(encryBytes);
		// String saltStr = encryptBASE64(salt);
		// System.out.println("原文="+message);
		// System.out.println("盐="+saltStr);
		// System.out.println("密文="+encryStr);
		
		
		// //2. 解密
		// encryBytes = decryptBASE64(encryStr);
		// salt = decryptBASE64(saltStr);
		// byte[] decryBytes = decrypt(encryBytes,password,salt);
		// System.out.println("解密后="+new String(decryBytes));
	}

}
