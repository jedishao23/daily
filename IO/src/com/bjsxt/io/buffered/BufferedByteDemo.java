package com.bjsxt.io.buffered;

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
 * �ֽ����ļ�����+������ ���������
 * ������(�ڵ���)
 * @author Administrator
 *
 */
public class BufferedByteDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
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
			File src =new File(srcPath);
			File dest =new File(destPath);
			if(!src.isFile()){ //�����ļ�����Ϊnull
				System.out.println("ֻ�ܿ����ļ�");
				throw new IOException("ֻ�ܿ����ļ�");
			}
			//2��ѡ����
			InputStream is =new BufferedInputStream(new FileInputStream(src));
			OutputStream os =new BufferedOutputStream( new FileOutputStream(dest));
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
