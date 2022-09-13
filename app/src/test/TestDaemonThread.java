package test;

public class TestDaemonThread extends Thread{

	public void run(){

		// 데몬 스레드인지 확인
		if(Thread.currentThread().isDaemon()){
			while (true) {
				try {
					Thread.sleep(0);
					System.out.println("Daemon thread running");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		else{
			System.out.println("Normal thread executing");
		}
	}
	public static void main(String[] args){

		TestDaemonThread t1=new TestDaemonThread();
		TestDaemonThread t2=new TestDaemonThread();

		//t1을 데몬으로 설정
		t1.setDaemon(true);

		// 스레드 시작
		t1.start();
		t2.start();
	}
}

