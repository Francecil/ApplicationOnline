package com.france.util;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class ConvertUtil {
	public int strToInt(String str) {
		int i = 0;
		try {
			if (str != null)
				i = Integer.parseInt(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public static String getTime() {
		Date date = new Date();
		String pattern = "yyyy/MM/dd HH:mm:ss";
		SimpleDateFormat simple = new SimpleDateFormat(pattern);
		return simple.format(date);
	}

	// md5
	public static final String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {

			byte[] btInput = s.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
	public static String getUUID(){
		 UUID uuid = UUID.randomUUID();
		 System.out.println("uuid:"+uuid.toString().substring(0,8));
		 return uuid.toString().substring(0,8);
	}
}
