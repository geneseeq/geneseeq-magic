package com.geneseeq.common.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Test {
	private final static String[] strDigits = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
    public static void main(String[] args) {
    	long s1=DateUtils.currentTimeStamp();
        String s2="shihedingdan";
        String s3=s1+s2;
        System.out.println(s3);
    	System.out.println(MD5Test.GetMD5Code(s3));
    }
    
    public static String getMD5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            System.out.println("aaaaaaaaaaaaaaa:"+str);
            System.out.println("aaaaaaaaaaaaaaa:"+md.digest());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }
 // 返回形式为数字跟字符串
    private static String byteToArrayString(byte bByte) {
        int iRet = bByte;
        // System.out.println("iRet="+iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        int iD1 = iRet / 16;
        int iD2 = iRet % 16;
        return strDigits[iD1] + strDigits[iD2];
    }

    // 返回形式只为数字
    @SuppressWarnings("unused")
	private static String byteToNum(byte bByte) {
        int iRet = bByte;
        System.out.println("iRet1=" + iRet);
        if (iRet < 0) {
            iRet += 256;
        }
        return String.valueOf(iRet);
    }
    // 转换字节数组为16进制字串
    private static String byteToString(byte[] bByte) {
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < bByte.length; i++) {
            sBuffer.append(byteToArrayString(bByte[i]));
        }
        return sBuffer.toString();
    }
    public static String GetMD5Code(String strObj) {
        String resultString = null;
        try {
            resultString = new String(strObj);
            MessageDigest md = MessageDigest.getInstance("MD5");
            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }
 // 对字符串进行MD5编码大写32
   public static String encodeByMD5(String s) {
	   char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
               'A', 'B', 'C', 'D', 'E', 'F' };
       try {
           byte[] btInput = s.getBytes();
           // 获得MD5摘要算法的 MessageDigest 对象
           MessageDigest mdInst = MessageDigest.getInstance("MD5");
           // 使用指定的字节更新摘要
           mdInst.update(btInput);
           // 获得密文
           byte[] md = mdInst.digest();
           // 把密文转换成十六进制的字符串形式
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
           e.printStackTrace();
           return null;
       }
   }
    
    
}
