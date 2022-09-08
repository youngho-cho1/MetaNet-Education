package test;
import java.io.*;
public class Ex17 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file = new File("D:/IO/IO.txt");
		FileReader fr = new FileReader(file);
		BufferedReader brfr = new BufferedReader(fr);
		while(brfr.ready()) {
			System.out.println(brfr.readLine());
		}
		brfr.close();
		// 연습문제) 파일에 기록된 문자 데이터를 화면에 출력하시오.
		// 활용문제) 뱅크에 사용자(회원) 데이터를 파일로 기록하는 프로그램을 작성하시오.
	}

}
