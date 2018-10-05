package com.bjsxt.io.file;

import java.io.File;
import java.util.Arrays;

/**
 * ������ＶĿ¼|�ļ�������(����·��)
 * 1��listFiles()
 * 2���ݹ�
 * 
 * static listRoots() ��·��
 * @author Administrator
 *
 */
public class Demo05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path ="E:/xp";
		File parent =new File(path);
		printName(parent);
		
//		File[] roots =File.listRoots();
//		System.out.println(Arrays.toString(roots));
//		for(File temp:roots){
//			//printName(temp);
//			
//		}
	}
	/**
	 * ���·��
	 */
	public static void printName(File src){
		if(null==src || !src.exists()){
			return ;
		}
		System.out.println(src.getAbsolutePath());
		if(src.isDirectory()){ //�ļ���
			for(File sub:src.listFiles()){
				printName(sub);
			}
			
		}
		
	}

}
