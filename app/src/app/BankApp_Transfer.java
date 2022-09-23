package app;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import app.BankApp_Pull.MenuActionListener;

@SuppressWarnings("serial")
public class BankApp_Transfer extends JFrame {
	BankApp_Transfer() {
		setTitle("계좌이체");
//		JPanel title = new JPanel();
//		JLabel login = new JLabel("계좌이체 화면");
//		title.add(login);
		createMenu();
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(4, 2));
		JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel jlb1 = new JLabel("이름 : ", JLabel.CENTER);

		idPanel.add(jlb1);
		// 아이디 라벨
		JPanel idPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField jtf1 = new JTextField(10);

		idPanel2.add(jtf1);
		// 아이디 필드 입력칸

		JPanel pwdPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel jlb2 = new JLabel("금액 : ", JLabel.CENTER);
		JPanel pwdPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPasswordField jtf2 = new JPasswordField(10);

		pwdPanel.add(jlb2);
		// 비밀번호 라벨
		pwdPanel2.add(jtf2);
		// 비밀번호 필드 입력칸

		JPanel bankPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel jlb3 = new JLabel("은행 : ", JLabel.CENTER);
		JPanel bankPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JRadioButton a = new JRadioButton("기업");
		JRadioButton b = new JRadioButton("농협");
		JRadioButton c = new JRadioButton("신한");

		a.setSelected(true);

		ButtonGroup bg = new ButtonGroup();
		bg.add(a);
		bg.add(b);
		bg.add(c);

		// radio panel
		JPanel radioPanel = new JPanel();
		radioPanel.add(a);
		radioPanel.add(b);
		radioPanel.add(c);

		bankPanel.add(jlb3);
		// 은행 라벨
		bankPanel2.add(radioPanel);
		// 은행 라디오 버튼

		jp1.add(bankPanel);
		jp1.add(bankPanel2);
		// 은행 패널, 은행 선택 라디오 버튼
		jp1.add(idPanel);
		jp1.add(idPanel2);
		// 아이디 입력칸, 아이디 패널
		jp1.add(pwdPanel);
		jp1.add(pwdPanel2);
		// 비밀번호 입력칸, 비밀번호 패널
	

		JPanel rankPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton rank = new JButton("등급");
		JPanel joinPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton join = new JButton("계좌이체");

		rankPanel.add(rank);
		joinPanel.add(join);
		jp1.add(rankPanel);
		jp1.add(joinPanel);
		// 로그인 회원가입 패널
		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout(FlowLayout.LEFT,0, 0));
		jp2.add(jp1);
		jp2.add(rank);
		setLayout(new BorderLayout());
//		add(title, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		setBounds(200, 200, 450, 250);
		setVisible(true);
	}

	void createMenu() {
		JMenuBar mb = new JMenuBar(); // 메뉴바 생성
		JMenuItem[] menuItem = new JMenuItem[3];
		String[] itemTitle5 = { "로그아웃", "도움말", "프로그램 종료" };
		JMenu screenMenu1 = new JMenu("예금");
		JMenu screenMenu2 = new JMenu("출금");
		JMenu screenMenu3 = new JMenu("이체");
		JMenu screenMenu4 = new JMenu("조회");
		JMenu screenMenu5 = new JMenu("종료");

		screenMenu1.add("예금").addActionListener(new MenuActionListener());
		screenMenu2.add("출금").addActionListener(new MenuActionListener());
		screenMenu3.add("이체").addActionListener(new MenuActionListener());
		screenMenu4.add("조회").addActionListener(new MenuActionListener());

		for (int i = 0; i < menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle5[i]);
			menuItem[i].addActionListener(new MenuActionListener());
			screenMenu5.add(menuItem[i]);
			if (i == 2) {
				break;
			} else {
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

			switch (cmd) {
			case "프로그램 종료":
				System.exit(0);
				break;
			case "로그아웃": {
				JOptionPane.showMessageDialog(null, "로그아웃하셨습니다.");
				dispose();
				new BankApp_Login();
				break;
			}
			case "도움말": {
				JOptionPane.showMessageDialog(null,
						" 제작자: 조영호\n " + "연락처: 010-0000-0000 \n" + " 이메일: mmy4637@naver.com \n" + " 버전: 1.0.0");
				break;
			}
			case "예금": {
				new BankApp_Push();
				dispose();
				break;
			}
			case "출금": {
				new BankApp_Pull();
				dispose();
				break;
			}
			case "이체": {
				JOptionPane.showMessageDialog(null, " 이체는 개발중입니다...");
				break;
			}
			case "조회": {
				new BankApp_Read();
				dispose();
				break;
			}

			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BankApp_Transfer();
	}

}
