package chatting;
import java.io.*;
import java.net.*;
import java.util.*;
public class ChatServer {
	ServerSocket serverSocket;
	Socket socket;
	List<Thread> list;
	
	public ChatServer() {
		list = new ArrayList<Thread>();
		System.out.println("서버 시작");
	}
	public void giveAndTake() {
		try {
			serverSocket = new ServerSocket(5420);
			serverSocket.setReuseAddress(true);
			
			while(true) {
				socket = serverSocket.accept();
				ServerSocketThread thread = new ServerSocketThread(this, socket);
				addClient(thread);
				thread.start();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	// synchronized: 쓰레드들이 공유데이터를 함께 사용하지 못하도록 하는 것
	// 클라이언트가 입장 시 호출, 리스트에 쓰레드 저장
	private synchronized void addClient(ServerSocketThread thread) {
		list.add(thread);
		System.out.println("Client 1명 입장. 총" + list.size() + "명");
	}
	// 클라이언트 퇴장 시 호출, 리스트에 쓰레드 제거
	public synchronized void removeClient(Thread thread) {
		list.remove(thread);
		System.out.println("Client 1명 퇴장. 총" + list.size() + "명");
	}
	// 클라에게 채팅 내용 전달
	public synchronized void broadCasting(String str) {
		for(int i = 0; i < list.size(); i++) {
			ServerSocketThread thread = (ServerSocketThread)list.get(i);
			thread.sendMessage(str);
		}
	}
	
	
}
