package test;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.ServerSocket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex24 implements Runnable {
	private Vector handlers;
	private JButton button;
	int port;
	public Ex24(int port) {
		this.port = port;
	}
	
	
	// 서버에서 필요한것들을 생성하면된다
	public Object getHandler(int index) {
		return handlers.elementAt(index);
	}

	public void register(Ex25 c) {
		handlers.addElement(c); // 처음에 접속했을때 사용자의 이름을 받아주고 connection에 넣엊
	}

	public void unregister(Object o) {
		handlers.removeElement(o);
	}

	public void broadcast(String message) {
		synchronized (handlers) {
			int n = handlers.size();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < n; i++) {
				Ex25 h = (Ex25) handlers.elementAt(i);
				sb.append("#" + h.getUser());
			}
			for (int i = 0; i < n; i++) {
				Ex25 h = (Ex25) handlers.elementAt(i);
				try {
					h.println(message + sb.toString()); // 모든 사용자에게 메세지를 뿌린다
				} catch (Exception e) {
				}
			}

		}
	} // 동기화처리

	public static void main(String[] args) {
		new Ex24(7979);
	}

	@Override
	public void run() {
		try {
			
			ServerSocket server = new ServerSocket(port);
			handlers = new Vector();
			System.out.println("ChatServer is ready");
			
			new Ex26("localhost");
			button.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Ex26.btn_cnt ++ ;
					new Ex26("localhost");
				}
			});
			System.out.println("Ex26.btn_cnt" + Ex26.btn_cnt);
			
				while (true) {// 소켓으로 관리하는게 아니라 객체화해서 관리
					Ex25 handler = new Ex25(this, server.accept()); // this: 서버에 대한 인스턴스
					handler.start(); // thread로 대응
				}
			
			
		} catch (Exception e) {

		}
		
		// TODO Auto-generated method stub
		
	}

}