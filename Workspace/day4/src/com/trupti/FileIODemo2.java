package com.trupti;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileIODemo2 {
	public static void main(String[] args) throws IOException {
		
		FileDialog f = new FileDialog(new Frame());
		f.show();
		String fname = f.getDirectory() + f.getFile();
		FileReader fileReader = new FileReader(new File(fname));
		System.out.println((new BufferedReader(fileReader)).readLine());
		System.out.println(fname);
	}
}
