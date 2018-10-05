package com.bjsxt.io.byteIO;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
/**
 * �ļ�����
 * 1���ļ�����
 * 2���ļ��п���  �ܾ��Լ��������Լ�
 * @author Administrator
 *
 */
public class FileUtil {
	/**
	 * �����ļ���
	 * @param src Դ·��
	 * @param dest Ŀ��·��
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void copyDir(String  srcPath,String destPath) throws FileNotFoundException, IOException{
		//�ܾ��Լ��������Լ�
		if(srcPath.equals(destPath)){
			return ;
		}
		File src=new File(srcPath);
		File dest =new File(destPath);
		copyDir(src,dest);		
	}
	
	
	
	/**
	 * �����ļ���
	 * @param src ԴFile����
	 * @param dest Ŀ��File����
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void copyDir(File src,File dest) throws FileNotFoundException, IOException{
		if(src.isDirectory()){ //�ļ���
			dest =new File(dest,src.getName());
			if(dest.getAbsolutePath().contains(src.getAbsolutePath())){
				System.out.println("��Ŀ¼���ܿ�������Ŀ¼��");
				return;
			}
		}		
		copyDirDetail(src,dest);
	}
	
	/**
	 * �����ļ���ϸ��
	 * @param src
	 * @param dest
	 */
	public static void copyDirDetail(File src,File dest) throws FileNotFoundException,IOException{
		if(src.isFile()){ //�ļ�
			try {
				FileUtil.copyFile(src, dest);
			} catch (FileNotFoundException e) {
				//e.printStackTrace();
				throw e;
			} catch (IOException e) {
				//e.printStackTrace();
				throw e;
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
	
	
	/**
	 * �ļ��Ŀ���
	 * @param  Դ�ļ�·��
	 * @param  Ŀ¼�ļ�·��
	 * @throws FileNotFoundException,IOException
	 * @return 
	 */
	public static void copyFile(String srcPath,String destPath) throws FileNotFoundException,IOException {
		//1��������ϵ Դ(������Ϊ�ļ�) +Ŀ�ĵ�(�ļ����Բ�����) 
		copyFile(new File(srcPath),new File(destPath));
	}
	/**
	 * �ļ��Ŀ���
	 * @param  Դ�ļ�File����
	 * @param  Ŀ¼�ļ�File����
	 * @throws FileNotFoundException,IOException
	 * @return 
	 */
	public static void copyFile(File src,File dest) throws FileNotFoundException,IOException {
		if(! src.isFile()){ //�����ļ�����Ϊnull
			System.out.println("ֻ�ܿ����ļ�");
			throw new IOException("ֻ�ܿ����ļ�");
		}
		//destΪ�Ѿ����ڵ��ļ��У����ܽ������ļ���ͬ�����ļ�
		if(dest.isDirectory()){
			System.out.println(dest.getAbsolutePath()+"���ܽ������ļ���ͬ�����ļ�");
			throw new IOException(dest.getAbsolutePath()+"���ܽ������ļ���ͬ�����ļ�");
		}
		
		
		//2��ѡ����
		InputStream is =new BufferedInputStream(new FileInputStream(src));
		OutputStream os =new BufferedOutputStream(new FileOutputStream(dest));
		//3���ļ�����   ѭ��+��ȡ+д��
		byte[] flush =new byte[1024];
		int len =0;
		//��ȡ
		while(-1!=(len=is.read(flush))){
			//д��
			os.write(flush, 0, len);
		}
		os.flush(); //ǿ��ˢ��
		
		//�ر���
		os.close();
		is.close();
	}
}
