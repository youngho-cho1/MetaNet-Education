package app;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class BankApp_Main extends JFrame {
	BankApp_Main() {
		setTitle("메인");
		createMenu();
		setBounds(200, 200, 400, 250);
		setVisible(true);
	}
	void createMenu() {
		JMenuBar mb = new JMenuBar(); // 메뉴바 생성
		JMenuItem [] menuItem = new JMenuItem [3];
		String[] itemTitle5 = {"로그아웃", "도움말", "프로그램 종료"};
		JMenu screenMenu1 = new JMenu("예금");
		JMenu screenMenu2 = new JMenu("출금");
		JMenu screenMenu3 = new JMenu("이체");
		JMenu screenMenu4 = new JMenu("조회");
		JMenu screenMenu5 = new JMenu("종료");
		
		screenMenu1.add("예금").addActionListener(new MenuActionListener());
		screenMenu2.add("출금").addActionListener(new MenuActionListener());
		screenMenu3.add("이체").addActionListener(new MenuActionListener());
		screenMenu4.add("조회").addActionListener(new MenuActionListener());
		
		for(int i=0; i<menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle5[i]); 
			menuItem[i].addActionListener(new MenuActionListener()); 
			screenMenu5.add(menuItem[i]);
			if(i == 2) {
				break;
			}else {
				screenMenu5.addSeparator();
			}
		}
		setJMenuBar(mb); // 메뉴바를 프레임에 부착
		
		mb.add(screenMenu1);
		mb.add(screenMenu2);
		mb.add(screenMenu3);
		mb.add(screenMenu4);
		mb.add(screenMenu5); 
		
		
	}
	class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			
			switch(cmd) {
			case "프로그램 종료":
				System.exit(0); 
				break;
			case "로그아웃":{
				JOptionPane.showMessageDialog
				(null,"로그아웃하셨습니다.");
				new BankApp_Login();
				dispose();
				break;
			}
			case "도움말":{
				JOptionPane.showMessageDialog
				(null," 제작자: 조영호\n "
						+ "연락처: 010-0000-0000 \n"
						+ " 이메일: mmy4637@naver.com \n"
						+ " 버전: 1.0.0");
				break;
			}
			case "예금":{
				new BankApp_Push();
				dispose();
				break;
			}
			case "출금":{
				new BankApp_Pull();
				dispose();
				break;
			}
			case "이체":{
				JOptionPane.showMessageDialog
				(null," 이체는 개발중입니다...");
				break;
			}
			case "조회":{
				new BankApp_Read();
				dispose();
				break;
			}
				
			}
				
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BankApp_Main();
	}

}
