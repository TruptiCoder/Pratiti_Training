package com.trupti;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileIODemo {
	public static void main(String[] args) {
		
		File file = new File("newFile.txt");
		
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); FileWriter fw = new FileWriter(file, true); PrintWriter pw = new PrintWriter(System.out)) {
			
			String choice = "n";
			do {
				pw.write("Enter your id: ");
				pw.flush();
				String id = br.readLine();
				
				pw.write("Enter your name: ");
				pw.flush();
				String name = br.readLine();
				
				pw.write("Enter your city: ");
				pw.flush();
				String city = br.readLine();
				
				fw.write(id + ", " + name + ", " + city + "\n");
				
				pw.write("Do you want to continue (Y / N): ");
				pw.flush();
				choice = br.readLine();
			
			} while(choice.equalsIgnoreCase("Y"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
