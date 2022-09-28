package app;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class BankApp_Transfer extends JFrame {
	static Transfer transfer = new Transfer();
	static List<Transfer> transfers = new ArrayList<>();
	static int min = 0;
	AppDao appdao = new AppDao();
	BankApp_Transfer() {
		setTitle("계좌이체");
//		JPanel title = new JPanel();
//		JLabel login = new JLabel("계좌이체 화면");
//		title.add(login);
		createMenu();
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(4, 2));
		JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel jlb1 = new JLabel("계좌번호 : ", JLabel.CENTER);

		idPanel.add(jlb1);
		// 이름 라벨
		JPanel idPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField jtf1 = new JTextField(10);

		idPanel2.add(jtf1);
		// 아이디 필드 입력칸

		JPanel pwdPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel jlb2 = new JLabel("금액 : ", JLabel.CENTER);
		JPanel pwdPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField jtf2 = new JTextField(10);

		pwdPanel.add(jlb2);
		// 금액 라벨
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
		JButton rank = new JButton("내역");
		JPanel joinPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton tran = new JButton("계좌이체");

		rankPanel.add(rank);
		joinPanel.add(tran);
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
		setResizable(false);
		setVisible(true);
		
		rank.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					new BankApp_History();
			}
			
		});
		tran.addActionListener(new ActionListener() {
			LocalDate now = LocalDate.now();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			String formatedNow = now.format(formatter);
			
			Connection conn = AppDao.getInstance().getConnection();
			PreparedStatement pstmt = null, pstmt2 = null, pstmt3 = null, pstmt4 = null;
			ResultSet rs = null, rs2 = null;
			int mission = 0;
			int myMoney = 0;
			int transMoney = 0;
			int Commission = 0;
			String transName = "";
			String my_Bank = "";
			String my_Account ="";
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(jtf1.getText().equals("") || jtf2.getText().equals("")) {
					JOptionPane.showMessageDialog
					(null,"공백란을 입력해주세요.");
					new BankApp_Transfer();
					dispose();
				}else {
				int money = Integer.parseInt(jtf2.getText());         //금액
				String account = jtf1.getText();         //계좌번호
				try {
					String radio = "";
					if (a.isSelected()) {
						radio = a.getText();
					} else if (b.isSelected()) {
						radio = b.getText();
					} else if (c.isSelected()) {
						radio = c.getText();
					}
					transfer.setBankname(radio);
					transfer.setAccount(jtf1.getText());
					transfer.setMoney(jtf2.getText());
					
					
					String sql = "SELECT BANKNAME, NAME, PWD, ACCOUNT, DESPOIT FROM MEMBER WHERE NAME=?";
					String custom_sql = "SELECT BANKNAME, NAME, ACCOUNT, DESPOIT FROM MEMBER WHERE BANKNAME=? AND ACCOUNT=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, BankApp_Login.w_name);
					rs = pstmt.executeQuery();
					pstmt3 = conn.prepareStatement(custom_sql);
					pstmt3.setString(1, radio);
					pstmt3.setString(2, account);
					rs2 = pstmt3.executeQuery();
					if(rs.next()) {
						my_Bank = rs.getString(1);
						if(my_Bank.equals(radio)) {
							Commission = 0;
						}else {
							Commission = 500;
						}
						if(rs.getInt(5) < money) {
							JOptionPane.showMessageDialog
							(null,BankApp_Login.w_name+"님의 잔액이 부족합니다.");
						}else if (rs.getInt(5) < (money+Commission)) {
							JOptionPane.showMessageDialog
							(null,BankApp_Login.w_name+"님의 수수료가 부족합니다.");
						}else {
							myMoney = rs.getInt(5) - (money + Commission);
							mission ++ ;
						}
					}
					if(rs2.next()) {
						if(my_Account.equals(account)) {
							JOptionPane.showMessageDialog
							(null,"본인계좌에는 이체할 수 없습니다.");
							new BankApp_Transfer();
							dispose();
						}
				
						else if(!account.equals(rs2.getString(3))) {
							JOptionPane.showMessageDialog
							(null,"정보를 다시 입력해주세요.");
							new BankApp_Transfer();
							dispose();
						}
						else {
							System.out.println("account: " + account);
							System.out.println("rs.getString: " +rs.getString(3));

							transName = rs2.getString(2);
							transMoney = money + rs2.getInt(4);
							pstmt2 = conn.prepareStatement(AppDao.update());
							pstmt2.setInt(1, myMoney);
							pstmt2.setString(2, BankApp_Login.w_name);
							pstmt2.executeUpdate();
							pstmt4 = conn.prepareStatement(AppDao.update2());
							pstmt4.setInt(1, transMoney);
							pstmt4.setString(2, account);
							pstmt4.executeUpdate();
							if(mission > 0) {
								JOptionPane.showMessageDialog
								(null,transName+"님에게 이체를 성공하셨습니다.\n"
										+ "이체 금액은" + money + "이며 수수료는" + Commission + "원 입니다.");
								appdao.trans_insert();
								mission = 0;
								new BankApp_Transfer();
								dispose();
							}

						}
					}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
			}
			}
		});
		
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
			case "채팅":{
				new test.Ex24(7979);
				new test.Ex26("localhost");		
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
				new BankApp_Transfer();
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
