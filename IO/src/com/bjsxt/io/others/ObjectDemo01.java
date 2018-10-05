package com.bjsxt.io.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
/**
 * �������еČ��󶼿������л�  java.io.NotSerializableException
 * �������еČ��Զ���Ҫ���л�  transient
 * @author Administrator
 *
 */
public class ObjectDemo01 {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		try {
			seri("e:/xp/test/ser.txt");
			read("e:/xp/test/ser.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�����л�
	public static void read(String destPath) throws IOException, ClassNotFoundException{
		//����Դ
		File src =new File(destPath);
		//ѡ����
		ObjectInputStream dis =new ObjectInputStream(
					new BufferedInputStream(
								new FileInputStream(src)
							)
				);
		
		//���� ��ȡ��˳����д��һ��   ������ڲ��ܶ�ȡ
		//��һ�£����ݴ�������
		Object obj =dis.readObject();
		if(obj instanceof Employee){
			Employee emp=(Employee)obj;
			System.out.println(emp.getName());
			System.out.println(emp.getSalary());
		}
		
		obj =dis.readObject();
		int[] arr=(int[])obj;
		System.out.println(Arrays.toString(arr));
		dis.close();
	}
	
	//���л�
	public static void seri(String destPath) throws IOException{
		Employee emp =new Employee("bjsxt",1000000);
		int[] arr ={1,2,3,45};
		//����Դ
		File dest =new File(destPath);
		//ѡ����  ObjectOutputStream
		ObjectOutputStream dos =new ObjectOutputStream(
					new BufferedOutputStream(
								new FileOutputStream(dest)
							)
				);
		//���� д����˳�� Ϊ��ȡ׼��
		dos.writeObject(emp);
		dos.writeObject(arr);
		//�ͷ���Դ
		dos.close();
	}
}
