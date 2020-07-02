package com.javen.config;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    //MD5鍔犲瘑
    public static String md5(String text) {
        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("md5");
            // 鏁扮粍 byte[] result -> digest.digest( );  鏂囨湰 text.getBytes();
            byte[] result = digest.digest(text.getBytes());
            //鍒涘缓StringBuilder瀵硅薄 鐒跺悗寤鸿StringBuffer锛屽畨鍏ㄦ�ч珮
            //StringBuilder sb = new StringBuilder();
            StringBuffer sb = new StringBuffer();
            // result鏁扮粍锛宒igest.digest ( ); -> text.getBytes();
            // for 寰幆鏁扮粍byte[] result;
            for (byte b : result){
                // 0xff 涓�16杩涘埗
                int number = b & 0xff;
                // number鍊� 杞崲 瀛楃涓� Integer.toHexString( );
                String hex = Integer.toHexString(number);
                if (hex.length() == 1){
                    sb.append("0"+hex);
                }else {
                    sb.append(hex);
                }
            }
            //sb StringBuffer sb = new StringBuffer();瀵硅薄瀹炰緥鍖�
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            //鍙戦�佸紓甯竢eturn绌哄瓧绗︿覆
            return "";
        }
    }
}
