package com.trupti;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileIO {

	public static void main(String[] args) {
		
		String msg  = "Hello Boss \n";
		
		File file = new File("abc.txt");
		file.canRead();
		
		if(file.exists()) {
			try (FileOutputStream fos = new FileOutputStream(file, true); PrintWriter pw = new PrintWriter(fos); FileWriter fw = new FileWriter(file, true);) {
//				pw.print("WAHAHAHA");
				
//				BufferedWriter bw = new BufferedWriter(null);
				
				fw.write(msg);

				System.out.println("File updated");
				
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		else System.out.println("File doesn't exits");
	}

}
