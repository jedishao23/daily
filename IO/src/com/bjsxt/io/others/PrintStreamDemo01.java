package com.bjsxt.io.others;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * PrintStream ��ӡ�� -->������
 * @author Administrator
 *
 */
public class PrintStreamDemo01 {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("test");
		PrintStream ps =System.out;
		ps.println(false);
		
		
		//������ļ�
		File src = new File("e:/xp/test/print.txt");
		ps = new PrintStream(new BufferedOutputStream(new FileOutputStream(src)));
		ps.println("io is so easy....");
		
		ps.close();
	}

}
