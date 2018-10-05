package com.bjsxt.io.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * ��������(����+String)������
 * 1�������� DataInputStream  readXxx()
 * 2������� DataOutputStream writeXxx()
 * ������������ʹ�ö�̬
 * 
 * java.io.EOFException :û�ж�ȡ����ص�����
 * @author Administrator
 *
 */
public class DataDemo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//write("e:/xp/test/data.txt");
			//read("e:/xp/test/arr.txt"); //�Ƿ�����
			read("e:/xp/test/data.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	/**
	 * ���ļ���ȡ����+����
	 * @throws IOException 
	 */
	public static void read(String destPath) throws IOException{
		//����Դ
		File src =new File(destPath);
		//ѡ����
		DataInputStream dis =new DataInputStream(
					new BufferedInputStream(
								new FileInputStream(src)
							)
				);
		
		//���� ��ȡ��˳����д��һ��   ������ڲ��ܶ�ȡ
		//��һ�£����ݴ�������
		long num2 =dis.readLong();
		double num1 =dis.readDouble();
		String str =dis.readUTF();
		
		dis.close();
		System.out.println(num2+"-->"+str);
		
	}
	/**
	 * ����+����������ļ�
	 * @throws IOException 
	 */
	public static void write(String destPath) throws IOException{
		double point =2.5;
		long num=100L;
		String str ="��������";
		
		//����Դ
		File dest =new File(destPath);
		//ѡ����  DataOutputStream
		DataOutputStream dos =new DataOutputStream(
					new BufferedOutputStream(
								new FileOutputStream(dest)
							)
				);
		//���� д����˳�� Ϊ��ȡ׼��
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);		
		dos.flush();
		
		//�ͷ���Դ
		dos.close();
		
		
		
		
		
	}

}
