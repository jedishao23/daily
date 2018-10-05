package com.bjsxt.io.charIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * ���ı�����
 * @author Administrator
 *
 */
public class CopyFileDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//����Դ ������ �ַ��Ĵ��ı�
		File src =new File("E:/xp/test/Demo03.java");
		File dest =new File("e:/xp/test/char.txt");
		//ѡ����
		Reader reader =null;		
		Writer wr =null;
		try {
			reader =new FileReader(src);
			wr =new FileWriter(dest);
			//��ȡ����
			char[] flush =new char[1024];
			int len =0;
			while(-1!=(len=reader.read(flush))){
				wr.write(flush, 0, len);
			}
			wr.flush();//ǿ��ˢ��
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("Դ�ļ�������");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ļ���ȡʧ��");
		}finally{
			try {
				if (null != wr) {
					wr.close();
				}
			} catch (Exception e2) {
			}
			try {
				if (null != reader) {
					reader.close();
				}
			} catch (Exception e2) {
			}
		}
	
	}

}
