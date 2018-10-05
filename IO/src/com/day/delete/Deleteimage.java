package com.day.delete;

import java.io.File;

public class Deleteimage {
	public static void main(String[] args) {
		String str="f:/Python/cat_dog_image";
		File file=new File(str); 
		delNotDir(file);
	}
	public static void delNotDir(File file){
        File[] f = file.listFiles();
        for (int i = 0; i < f.length; i++) {
            if (f[i].isDirectory()) {
                delNotDir(f[i]);
            }
            System.out.println(f[i].getPath());
            f[i].delete();
        }

    }

}
