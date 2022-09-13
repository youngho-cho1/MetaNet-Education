package chatting;

import java.io.*;
import java.net.*;

public class ServerSocketThread extends Thread {
	Socket socket;
	ChatServer server;
	BufferedReader in;
	PrintWriter out;
	String name;
	String threadName;
	
	public ServerSocketThread(ChatServer server, Socket socket) {
		this.server = server;
		this.socket = socket;
		threadName = super.getName(); // Thread 이름 얻어옴
		System.out.println(socket.getInetAddress() + "님이 입장하였습니다."); // Ip 주소 얻어옴
		System.out.println("Thread Name : " + threadName);
	}
	// 클라에서 메시지 출력
	public void sendMessage(String str) {
		out.println(str);
	}
	//쓰레드
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// true : autoFlush 설정
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
		
			sendMessage("대화자 이름을 넣으세요");
			name = in.readLine();
			server.broadCasting("[" + name + "]님이 입장하셨습니다.");
		}
	}
}
