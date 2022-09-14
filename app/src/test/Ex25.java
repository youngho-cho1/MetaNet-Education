package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Ex25 extends Thread {
	private Socket s;
	private BufferedReader i;
	private PrintWriter o;
	private Ex24 server;
	private String user;

	public Ex25(Ex24 server, Socket s) throws Exception {
		this.server = server;
		this.s = s;
		InputStream ins = s.getInputStream();
		OutputStream os = s.getOutputStream();
		InputStreamReader isr = new InputStreamReader(ins);
		OutputStreamWriter osw = new OutputStreamWriter(os);
		o = new PrintWriter(osw, true);
		i = new BufferedReader(isr);
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
//   public Ex21() {
//      // TODO Auto-generated constructor stub
//   }
	public void run() {
		String name = ""; // 사용자가 들어올때
		try {
			name = i.readLine();
			setUser(name);
			server.register(this);
//         NickNameList.add(name);
//         serverchatgui.AppendUserList(NickNameList);
			broadcast(name + "님이 방문하셨습니다.");
			// 이곳에 append?
			while (true) {
				String msg = i.readLine();
				broadcast(name + " - " + msg);
			}
		} catch (Exception e) {
			server.unregister(this);
			broadcast(name + "님이 나가하셨습니다.");
		}
		try {
			i.close();
			o.close();
			s.close(); // 자원을 해지하는 것도 순서를 지켜주는 것이 바람직하다

		} catch (IOException ex) {
		}
	}

	protected void println(String message) {
		o.println(message);

	}

	protected void broadcast(String message) {
		server.broadcast(message);
	}
}