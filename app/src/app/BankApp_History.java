package app;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class BankApp_History extends JFrame {
	AppDao appdao = new AppDao();

	BankApp_History() {
		
		Dimension dim = new Dimension(400, 150);
		String str = "";
		JFrame frame = new JFrame("거래내역");
		frame.setLocation(200, 400);
		frame.setPreferredSize(dim);
//		String[][] contents = new String[5][5];
		appdao.history(); // 내역 누를때마다 생김
		String header[] = { "은행", "날짜", "이름", "거래구분", "계좌", "금액" };// 잔고는 나중에

		System.out.println("cnt: " + appdao.cnt);
		String[][] arr = new String[appdao.cnt][6];
		for (int i = 0; i < appdao.cnt; i++) {
			if (appdao.data.get(i).getDivision().equals("y")) {
				str = "출금";
			} else {
				str = "입금";
			}
			for (int j = 0; j < 6; j++) {
				if (j == 0)
					if(str.equals("출금")) {
						arr[i][j] = appdao.data.get(i).getBankname();
					}else {arr[i][j] = appdao.data.get(i).getYbankname();}
				if (j == 1)
					arr[i][j] = appdao.data.get(i).getDay();
				if (j == 2)
					arr[i][j] = appdao.data.get(i).getYname();
				if (j == 3)
					arr[i][j] = str;
				if (j == 4)
					arr[i][j] = appdao.data.get(i).getAccount();
				if (j == 5)
					arr[i][j] = appdao.data.get(i).getMoney();
			}
			if (i == appdao.data.size() - 1) {
				JTable table = new JTable(arr, header);
				JScrollPane scrollpane = new JScrollPane(table);
				frame.add(scrollpane);
		}

		}

		frame.setBounds(200, 200, 450, 250);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BankApp_History();
	}

}
