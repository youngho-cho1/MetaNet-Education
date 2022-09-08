package test;

import java.io.*;

public class Ex16 {

	public static void main(String[] args) throws IOException {
			File file = new File("D:/IO/IO.txt");
			FileWriter fwriter = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fwriter);
			PrintWriter pw = new PrintWriter(bw, true);
			InputStream is = System.in;
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br =new BufferedReader(isr);
			System.out.println("입력 : ");
			String str = "";
			while(!str.equals("end")) {
				str = br.readLine();
				pw.println(str+", ");
			}
			br.close();
			pw.close();
			
			
	}

}
