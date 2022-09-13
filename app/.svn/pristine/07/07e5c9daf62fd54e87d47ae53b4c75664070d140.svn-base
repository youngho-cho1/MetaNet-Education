package test;
import java.util.*;
import java.io.*;
import java.net.*;

public class TestEchoServer extends Thread {
	public void run() {
		if(Thread.currentThread().isDaemon()) {
			while(true) {
				try {
					service();
					System.out.println("Daemon thread run");
				}catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("Normal thread executing");
		}
	}
	private ServerSocket server;
	public TestEchoServer(int port) throws IOException{
		server = new ServerSocket(port);
	}
	public void service() throws IOException{
		Socket client = server.accept();
		InputStream is = client.getInputStream();
		OutputStream os = client.getOutputStream();
		InputStreamReader isr = new InputStreamReader(is);
		PrintWriter out = new PrintWriter(os, true);
		BufferedReader con = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("service run");
	}
	public static void main(String[] args) throws IOException {
		
		TestEchoServer EchoServer = new TestEchoServer(1000); // 포트번호
		
		EchoServer.setDaemon(true);
		
		EchoServer.start();
		
	}
}
