package test;

import java.net.*;
import java.util.*;
import java.io.*;

public class Ex20 { // server
	private Vector handlers;
	ArrayList<String> UserList = new ArrayList<String>();

	public Ex20(int port) {
		try {
			ServerSocket server = new ServerSocket(port);
			handlers = new Vector();
			System.out.println("Server is ready");
			while (true) {
				Ex21 handler = new Ex21(this, server.accept());
				// 또 다른 클래스를 만들어서 소켓 관리(객체화를 통해) --> 소켓뿐만 아니라 필요한 기능들을 만들어 사용 가능
				// handler는 소켓을(Ex21)을 관리하는 객체가 되는것이다.
				handler.start();
			}
		} catch (Exception e) {
		}
	}

	public Object getHandler(int index) {
		return handlers.elementAt(index);
		// 특정된 사용자와 통신하고 싶을때 그 객체를 가져오기 위한 코드 ( elementAt == get )
		// 컬렉션의 담겨지는 것은 요소 ==> element와 같음
	}

	public void register(Ex21 c) {
		handlers.addElement(c);
	}

	// 저장
	public void unregister(Object o) {
		handlers.removeElement(o);
	}

	// 삭제
	public /*synchronized*/ void broadcast(String message) {
		synchronized (handlers) {  //싱크로나이즈 : 멀티 쓰레드의 충돌을 막기 위해 웨이팅을 걸어준다 (동기화 처리)
			// public synchronized 클래스에 걸 수 있고 클래스 안에서 영역으로도 걸 수 있음.
			int n = handlers.size();
			for (int i = 0; i < n; i++) {
				Ex21 h = (Ex21) handlers.elementAt(i); // 오브젝트로 나오기 때문에 형변환 필요
				try {
					h.println(message);
					// 메세지 찍어주는 부분
				
				} catch (Exception e) {
				}
			}
		}
	}
	public void inname(String name) {
		int n = handlers.size();
		for(int i = 0; i < n; i++) {
			Ex21 h = (Ex21) handlers.elementAt(i); 
			try {
				UserList.add(name);
				System.out.println(UserList.get(i));
				h.println(UserList.get(i));
			}catch (Exception e) {}
		}
	}
	// 1. 메세지를 전부 뿌리기 위한 전체 인원파악 ( 인원수 만큼 객체를 끄집어냄)
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex20(7979);
	}
//  public void AppendUserList(ArrayList NickName) {
//	   // 유저 목록을 유저 리스트에 띄워줌.
//	   String name;
//	   UserList.setText(null);
//	   for(int i=0; i< NickName.size(); i++) {
//		   name = (String)NickName.get(i);
//		   UserList.append(name + "\n");
//	   }
//}


}