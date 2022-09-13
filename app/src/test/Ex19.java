package test;

import java.io.*;
import java.util.*;

public class Ex19 {
	List<Ex2> members;
	public Ex19() {
		members = new ArrayList<>();
		Ex2 member = new Ex2("a", "1", "1");
		members.add(member);
		fileInput(member);
		fileOutput();
		for(Ex2 m : members) {
			System.out.println(m.getName());
		}
	}
	public void fileInput(Ex2 member) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(new File("members.txt"), true));
			StringBuilder sb = new StringBuilder();
			sb.append(false);
			pw.println(member.getName() + "#" + member.getId() + "#" + member.getPw());
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void fileOutput() {
		try {
				BufferedReader br = new BufferedReader(new FileReader(new File("members.txt")));
				while(br.ready()) {
					StringTokenizer st  = new StringTokenizer(br.readLine(), "#");
				while(st.hasMoreTokens()) {
					Ex2 member = new Ex2(st.nextToken(), st.nextToken(), st.nextToken());
					members.add(member);
				}
				}
		}catch(IOException e) {
				e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex19();
	}

}
