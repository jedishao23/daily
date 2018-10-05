package com.bjsxt.io.byteIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * �ļ��еĿ���
 * 1���ļ� ��ֵ  copyFile
 * 2���ļ� ���� mkdirs()
 * 3���ݹ�������Ｖ
 * 
 * @author Administrator
 *
 */
public class CopyDir {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ԴĿ¼
		String srcPath="E:/xp/test/a"; 	
		//Ŀ��Ŀ¼
		String destPath="E:/xp/test/c";
		try {
			FileUtil.copyDir(srcPath,destPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * �����ļ���
	 * @param src Դ·��
	 * @param dest Ŀ��·��
	 */
	public static void copyDir(String  srcPath,String destPath){
		File src=new File(srcPath);
		File dest =new File(destPath);
		copyDir(src,dest);		
	}
	
	
	
	/**
	 * �����ļ���
	 * @param src ԴFile����
	 * @param dest Ŀ��File����
	 */
	public static void copyDir(File src,File dest){
		if(src.isDirectory()){ //�ļ���
			dest =new File(dest,src.getName());			
		}		
		copyDirDetail(src,dest);
	}
	
	/**
	 * �����ļ���ϸ��
	 * @param src
	 * @param dest
	 */
	public static void copyDirDetail(File src,File dest){
		if(src.isFile()){ //�ļ�
			try {
				FileUtil.copyFile(src, dest);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(src.isDirectory()){ //�ļ���
			//ȷ��Ŀ���ļ��д���
			dest.mkdirs();
			//��ȡ��һ��Ŀ¼|�ļ�
			for(File sub:src.listFiles()){
				copyDirDetail(sub,new File(dest,sub.getName()));
			}
		}
	}
	
	

}
