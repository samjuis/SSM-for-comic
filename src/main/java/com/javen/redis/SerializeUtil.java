package com.javen.redis;

import java.io.*;

public class SerializeUtil {
/**
 * 
 * 序列化
 */
	public static byte[] serialize(Object obj) {
		ObjectOutputStream oos=null;
		ByteArrayOutputStream baos=null;
		try{
			//序列化
			baos=new ByteArrayOutputStream();
			oos=new ObjectOutputStream(baos);
			
			oos.writeObject(obj);
			byte[] byteArray=baos.toByteArray();
			return byteArray;
		}catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 反序列化
	 */
	public static Object unSerialize(byte[] bytes) {
		ByteArrayInputStream bais=null;
		try {
			bais=new ByteArrayInputStream(bytes);
			ObjectInputStream ois=new ObjectInputStream(bais);
			return ois.readObject();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
