package com.trupti;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

class MyOutputStream extends OutputStream {

	@Override
	public void write(int b) throws IOException {
		// TODO Auto-generated method stub
		
	}
}

public class IODemo {
	
	public static void inputstreamdemo() throws IOException {
		InputStream is = System.in;
//		int c = is.read();
//		System.out.println(c);
		
//		DataInputStream dis = new DataInputStream(is);
//		String s = dis.readLine();
//		System.out.println(s);
		
		// BridgeStream
		InputStreamReader isr = new InputStreamReader(is);
		
		BufferedReader br = new BufferedReader(isr);
		String m = br.readLine();
		
		OutputStreamWriter osw = new OutputStreamWriter(System.out);
		BufferedWriter bw = new BufferedWriter(osw);
		bw.write(m);
		bw.flush();
		
	}
	
	public static void main(String[] args) throws IOException {
		
		Reader r;
		Writer w;
		InputStream is;
		
		inputstreamdemo();
				
//		OutputStream ps = System.out;
//		OutputStream ps = new MyOutputStream();
//		byte b[] = "hello".getBytes(); 
//		ps.write(65);
//		ps.flush();
//		ps.close();
		
		OutputStream os = System.out;
		Writer w1 = new PrintWriter(os);
//		w1.write("Hello world");
		w1.flush();
		
		
		PrintStream pss = System.out;
//		pss.print("Hello");
	}
}
