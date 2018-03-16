package com.whoiszxl.pattern.singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * 测试反射和反序列化破解单例模式
 * @author Administrator
 *
 */
public class Client {
	
	public static void main(String[] args) throws Exception {
		SingletonStaticClass s1 = SingletonStaticClass.getInstance();
		SingletonStaticClass s2 = SingletonStaticClass.getInstance();
		
		System.out.println(s1);
		System.out.println(s2);
		
		try {
			Class<SingletonStaticClass> clazz = (Class<SingletonStaticClass>) Class.forName("com.whoiszxl.pattern.singleton.SingletonStaticClass");
			Constructor<SingletonStaticClass> constructor = clazz.getDeclaredConstructor(null);
			//使用反射,关闭安全校验就可以破解单例new出新的类来
			constructor.setAccessible(true);
			SingletonStaticClass s3 = constructor.newInstance();
			SingletonStaticClass s4 = constructor.newInstance();
			System.out.println(s3);
			System.out.println(s4);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//通过反序列化构建多个对象
		FileOutputStream fos = new FileOutputStream("j:/a.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s1);
		oos.close();
		fos.close();
		
		//反序列化出来的对象是不同的 对象
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("j:/a.txt"));
		SingletonStaticClass s = (SingletonStaticClass) ois.readObject();
		System.out.println(s);
		
	}
}
