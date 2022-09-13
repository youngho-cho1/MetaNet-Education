package test;

import java.io.*;
import java.net.*;

public class EchoServer {
	private ServerSocket server;

	public EchoServer(int port) throws IOException {
		server = new ServerSocket(port);
		
	}

	public void service() throws IOException {
		Socket client = server.accept();
		InputStream is = client.getInputStream();
		OutputStream os = client.getOutputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader in = new BufferedReader(isr);
		PrintWriter out = new PrintWriter(os, true);
		BufferedReader con = new BufferedReader(new InputStreamReader(System.in));	// 지금은 필요없는듯
		while (true) {
			String msg = in.readLine();
			System.out.println(msg);
			if (msg.equals("bye")) {
				break; // 이 때 통신 끝
			}
			out.println(">>" + msg);
		}
	}
	
	public void close() throws IOException{
		server.close();
	}

	public static void main(String[] args) {
		try {
			EchoServer es = new EchoServer(1);
			es.service();
			es.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
