package com.trupti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetworkIO {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		// Server code
//		ServerSocket serverSocket = new  ServerSocket(5555);
//		for(;;) {
//			System.out.println("Waiting....");
//			Socket userSocket = serverSocket.accept();
//			System.out.println(userSocket);
//			InputStream is = userSocket.getInputStream();
//			BufferedReader br = new BufferedReader(new InputStreamReader(is));
//			String user = br.readLine();
//			System.out.println(user);
//		}
		
		Socket socket = new Socket("192.168.1.85", 5555);
		OutputStream os = socket.getOutputStream();
		PrintWriter pw = new PrintWriter(os);
		pw.write("Hello, I am Trupti");
		pw.flush();
		pw.close();
		socket.close();
	}
}
