package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.*;

public class Ex21 extends Thread {

   private Socket s;
   private BufferedReader i;
   private PrintWriter o;
   private Ex20 server;

   public Ex21(Ex20 server, Socket s)throws Exception {
      this.server = server;
      this.s = s;
      InputStream ins = s.getInputStream();
      OutputStream os = s.getOutputStream();
      InputStreamReader isr = new InputStreamReader(ins);
      OutputStreamWriter osw = new OutputStreamWriter(os);
      o = new PrintWriter(osw, true);
      i = new BufferedReader(isr);
   }
   public void run() {
      String name = ""; //사용자가 들어올때
      try {
         name = i.readLine();
         server.register(this);
         broadcast(name + "님이 방문하셨습니다.");
         inname(name);
         while(true) {
            String msg = i.readLine();
            broadcast(name + " - " + msg);
            // 메세지를 뽑아주는 부분

         }
      }catch(Exception e) {
         server.unregister(this);
         broadcast(name + "님이 나가셨습니다.");
      }try {
         i.close();
         o.close();
         s.close(); //자원을 해지하는 것도 순서를 지켜주는 것이 바람직하다
         
      }catch(IOException ex) {
      }
   }
   protected void println(String message) {
      o.println(message);
      
   }
   
   protected void broadcast(String message) {
      server.broadcast(message);
   }
   protected void inname(String name) {
	  server.broadcast(name);
   }
}
// protected는 같은 패키지 또는 자식 클래스에서 사용할 수 있도록 한다
// private는 외부에서 사용 못 한다.