package chatting;

import java.io.*;
import java.net.*;
import java.util.Collections;
import java.util.*;

public class MultiServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiServer multiServer = new MultiServer();
		multiServer.start();
	}
	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(8000);
			while(true) {
				System.out.println("[클라이언트 연결 대기중]");
				socket = serverSocket.accept();
				
				// 클라이언트가 접속할때마다 새로운 thread 생성
				ReceiveThread receiveThread = new ReceiveThread(socket);
				receiveThread.start();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(serverSocket!=null) {
				try {
					serverSocket.close();
					System.out.println("[서버종료]");
				}catch(IOException e) {
					e.printStackTrace();
					System.out.println("[서버 통신에러]");
				}
			}
		}
	}
}

class ReceiveThread extends Thread{
	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());
	Socket socket = null;
	BufferedReader in = null;
	PrintWriter out = null;
	
	public ReceiveThread(Socket socket) {
		this.socket = socket;
		try {
			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			list.add(out);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		String name = "";
		try {
			name = in.readLine();
			System.out.println("["+name+" 새연결생성]");
			sendAll("[" + name + "]님이 들어오셨습니다.");
			
			while(in != null) {
				String inputMsg = in.readLine();
				if("quit".equals(inputMsg)) break;
				sendAll(name + ">>" + inputMsg);
			}
		}catch(IOException e) {
			System.out.println("[" + name + " 접속끊킴]");
		}finally {
			sendAll("[" + name + "]님이 나가셨습니다.");
			list.remove(out);
			try {
				socket.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
private void sendAll(String s) {
	for(PrintWriter out: list) {
		out.print(s);
		out.flush();
	}
}
}
