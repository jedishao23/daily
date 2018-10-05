package com.bjsxt.io.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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
public class DataDemo02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			byte[] data=write();
			read(data);
			System.out.println(data.length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	/**
	 * ���ֽ������ȡ����+����
	 * @throws IOException 
	 */
	public static void read(byte[] src) throws IOException{
		//ѡ����
		DataInputStream dis =new DataInputStream(
					new BufferedInputStream(
								new ByteArrayInputStream(src)
							)
				);
		
		//���� ��ȡ��˳����д��һ��   ������ڲ��ܶ�ȡ
		double num1 =dis.readDouble();
		long num2 =dis.readLong();
		String str =dis.readUTF();
		
		dis.close();
		
		System.out.println(num1+"-->"+num2+"-->"+str);
		
	}
	/**
	 * ����+����������ֽ�������
	 * @throws IOException 
	 */
	public static byte[] write() throws IOException{
		//Ŀ������
		byte[] dest =null;
		double point =2.5;
		long num=100L;
		String str ="��������";
		
		
		//ѡ���� ByteArrayOutputStream  DataOutputStream
		ByteArrayOutputStream bos =new ByteArrayOutputStream();
		DataOutputStream dos =new DataOutputStream(
					new BufferedOutputStream(
							bos
							)
				);
		//���� д����˳�� Ϊ��ȡ׼��
		dos.writeDouble(point);
		dos.writeLong(num);
		dos.writeUTF(str);		
		dos.flush();

		dest =bos.toByteArray();
		
		//�ͷ���Դ
		dos.close();
		
		return dest;
		
		
		
		
	}

}
