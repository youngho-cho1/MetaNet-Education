package app;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.mysql.cj.xdevapi.Statement;
@SuppressWarnings("serial")
public class BankApp_Join extends JFrame  {
	static Member member = new Member();
	static List<Member> members= new ArrayList<>();
	static int count = 0, sus = 0;
	AppDao appdao = new AppDao();
	String choice = null;
	public BankApp_Join() {
		Random rd = new Random();
		setTitle("회원관리");
		JLabel title = new JLabel("회원가입", JLabel.CENTER);
		
		JButton join = new JButton("회원가입");
		JButton cancel = new JButton("취소");
		
		JTextField bank = new JTextField(10);
		JTextField name = new JTextField(10);
		JTextField account = new JTextField(10);
		account.setText((rd.nextInt(8)+1)+rd.nextInt(9)+rd.nextInt(9)+"-"+rd.nextInt(9)+rd.nextInt(9)+rd.nextInt(9)+rd.nextInt(9)+rd.nextInt(9)+rd.nextInt(9)+"-"+rd.nextInt(9)+rd.nextInt(9)+"-"+rd.nextInt(9)+rd.nextInt(9)+rd.nextInt(9));
		account.setEditable(false);
		JTextField id = new JTextField(10);
		JPasswordField pwd = new JPasswordField(10);
		
		JRadioButton a = new JRadioButton("기업");
		JRadioButton b = new JRadioButton("농협");
		JRadioButton c = new JRadioButton("신한");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(a);bg.add(b);bg.add(c);
		
		JPanel radioPanel = new JPanel();
		radioPanel.add(a);
		radioPanel.add(b);
		radioPanel.add(c);
		
		JPanel idPanel = new JPanel();
		idPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		idPanel.add(new JLabel("아이디 : "));
		idPanel.add(id);
		
		JPanel namePanel = new JPanel();
		namePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		namePanel.add(new JLabel("이름 : "));
		namePanel.add(name);
		
		JPanel accountPanel = new JPanel();
		accountPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		accountPanel.add(new JLabel("계좌 : "));
		accountPanel.add(account);
		
		JPanel pwdPanel = new JPanel();
		pwdPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pwdPanel.add(new JLabel("비밀번호 : "));
		pwdPanel.add(pwd);
		
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(4, 1));
		formPanel.add(idPanel);
		formPanel.add(namePanel);
		formPanel.add(accountPanel);
		formPanel.add(pwdPanel);
		
		// radio + form panel
		JPanel contentPanel = new JPanel();
		contentPanel.setLayout(new FlowLayout());
		contentPanel.add(radioPanel);
		contentPanel.add(formPanel);
		
		JPanel panel = new JPanel();
		panel.add(join);
		panel.add(cancel);
		
		add(title, BorderLayout.NORTH);
		add(contentPanel, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		setBounds(200, 200, 250, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
		
		join.addActionListener(new ActionListener() {
			
			Connection conn = AppDao.getInstance().getConnection();
			PreparedStatement pstmt = null;
			Statement stmt = null;
			ResultSet rs = null;
			ResultSetMetaData rsmd = null;
			List<Info> data = new ArrayList<>();
			public void actionPerformed(ActionEvent e) {
				
				member.setName(name.getText());
				member.setId(id.getText());
				member.setAccount(account.getText());
				member.setPasswd(String.valueOf(pwd.getPassword()));
				try {
					pstmt =conn.prepareStatement(AppDao.select());
					rs = pstmt.executeQuery();
					rsmd = rs.getMetaData();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(a.isSelected()) {
					member.setBankname(a.getText());
				}else if(b.isSelected()) {
					member.setBankname(b.getText());
				}else if(c.isSelected()) {
					member.setBankname(c.getText());
				}
				members.add(member);
			
	
				appdao.insert();
				if(sus > 0) {
					new BankApp_Login();
					dispose();
				}
				
				
			}
		});
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new BankApp_Login();
				dispose();
			}
		});
	}
}
