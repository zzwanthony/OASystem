package com.ksd.zzw.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UtilMD5 {

	public static String MD5(String plainText){
//		MD5加密
		byte[] secretBytes = null;
		try {
			secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("没有md5这个算法");
		}
		String md5code = new BigInteger(1,secretBytes).toString(16);
		for (int i = 0; i < 32-md5code.length(); i++) {
			md5code = "0" +md5code;
		}
		return md5code;
	}
}
