package test;
import java.util.*;
public class TimerEx {
	public static int cnt;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cnt = 0;
		Timer m_timer = new Timer();
		TimerTask m_task = new TimerTask() {
			public void run() {
				while(cnt == 10) {
					System.out.println("Morph");
					cnt ++;
				}
			}
		};
		m_timer.schedule(m_task, 10000, 2000);
	}

}
