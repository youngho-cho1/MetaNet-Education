package app;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;

import com.mysql.cj.xdevapi.Statement;

public class BankApp_Login extends JFrame {
	static int cnt = 0;
	List<User> data = new ArrayList<>();
	static String w_name = "";
	static String y_bank = "";

	public BankApp_Login() {

		super("Login");
		JPanel title = new JPanel();
		JLabel login = new JLabel("로그인 화면");
		title.add(login);

		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(4, 2));
		JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel jlb1 = new JLabel("아이디 : ", JLabel.CENTER);

		idPanel.add(jlb1);
		// 아이디 라벨
		JPanel idPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField jtf1 = new JTextField(10);

		idPanel2.add(jtf1);
		// 아이디 필드 입력칸

		JPanel pwdPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel jlb2 = new JLabel("비밀번호 : ", JLabel.CENTER);
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
		JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton jLogin = new JButton("로그인");
		JPanel joinPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton join = new JButton("회원가입");
		loginPanel.add(jLogin);
		joinPanel.add(join);
		jp1.add(loginPanel);
		jp1.add(joinPanel);
		// 로그인 회원가입 패널
		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout(FlowLayout.LEFT,0, 0));
		jp2.add(jp1);
		setLayout(new BorderLayout());
		add(title, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		setBounds(200, 200, 380, 250);
		
		setResizable(false);
		setVisible(true);

		jLogin.addActionListener(new ActionListener() {
			int cnt = 0;
			Connection conn = AppDao.getInstance().getConnection();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ResultSetMetaData rsmd = null;
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					pstmt =conn.prepareStatement(AppDao.select());
					rs = pstmt.executeQuery();
					rsmd = rs.getMetaData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					String radio = "";
					if (a.isSelected()) {
						radio = a.getText();
					} else if (b.isSelected()) {
						radio = b.getText();
					} else if (c.isSelected()) {
						radio = c.getText();
					}
					
					while (rs.next()) {
						User user = new User().setBankname(rs.getString(1)).setName(rs.getString(2))
								.setId(rs.getString(3)).setPw(rs.getString(4));
						// bankname, name, account, pw
	
						data.add(user);
					}
					
					Iterator<User> iterator = data.iterator();
					while(iterator.hasNext()) {
						User userinfo = iterator.next();
						if(userinfo.getBankname().equals(radio)) {
							if(userinfo.getId().equals(jtf1.getText())) {
								if(userinfo.getPw().equals(String.valueOf(jtf2.getPassword()))) {
									  JOptionPane.showMessageDialog(null,
	                                   userinfo.getBankname() + "은행 " + userinfo.getName() + " 고객님 안녕하세요.");
									   w_name = userinfo.getName();
									   y_bank = radio;
                                       new BankApp_Main();
                                       dispose();
                                       cnt++;
                                       break;
								} 
							}else {
									  JOptionPane.showMessageDialog(null,"로그인 정보가 맞지 않습니다.");
									  break;
							}
						}else {
							  JOptionPane.showMessageDialog(null,"로그인 정보가 맞지 않습니다.");
							  break;
					}
					}
				}
				 catch (Exception ex) {
					ex.printStackTrace();
				} 
			}

		});

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BankApp_Join();
				dispose();
			}
		});

	}

	public static void main(String[] args) {
		new BankApp_Login();
	}

}
