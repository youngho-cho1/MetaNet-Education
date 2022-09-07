package app;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

@SuppressWarnings("serial")
public class App extends JFrame {
	static Member member = new Member();
	static List<Member> members= new ArrayList<>();
	public App() {
		super("Login");
		JPanel title = new JPanel();
		JLabel login = new JLabel("로그인 화면");
//		String str = BankApp_Join.member.getName();
		title.add(login);
		
		JPanel jp1 = new JPanel();
		jp1.setLayout(new GridLayout(4, 2));
		JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel jlb1 = new JLabel("이름 : ", JLabel.CENTER);
		
		idPanel.add(jlb1);
		//아이디 라벨 
		JPanel idPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JTextField jtf1 = new JTextField(10);
		
		idPanel2.add(jtf1);
		// 아이디 필드 입력칸
		
	
		JPanel pwdPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JLabel jlb2 = new JLabel("비밀번호 : ", JLabel.CENTER);
		JPanel pwdPanel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPasswordField jtf2 = new JPasswordField(10);
		
		pwdPanel.add(jlb2);
		//비밀번호 라벨 
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
		bg.add(a); bg.add(b); bg.add(c);
		
		// radio panel
		JPanel radioPanel = new JPanel();
		radioPanel.add(a);
		radioPanel.add(b);
		radioPanel.add(c);
		
		bankPanel.add(jlb3);
		//은행 라벨 
		bankPanel2.add(radioPanel);
		//은행 라디오 버튼
		
		jp1.add(bankPanel);jp1.add(bankPanel2);
		// 은행 패널, 은행 선택 라디오 버튼
		jp1.add(idPanel);jp1.add(idPanel2);
		// 아이디 입력칸, 아이디 패널
		jp1.add(pwdPanel); jp1.add(pwdPanel2);
		// 비밀번호 입력칸, 비밀번호 패널
		
		JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton jLogin = new JButton("로그인");
		JPanel joinPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton join = new JButton("회원가입");
		
		loginPanel.add(jLogin); joinPanel.add(join);
		jp1.add(loginPanel); jp1.add(joinPanel);
		// 로그인 회원가입 패널
		
		JPanel jp2 = new JPanel();
		jp2.setLayout(new FlowLayout());
		jp2.add(jp1);
		
		setLayout(new BorderLayout());
		add(title, BorderLayout.NORTH);
		add(jp2, BorderLayout.CENTER);
		setBounds(200, 200, 400, 250);
//		setResizable(false); 
		// 크기 고정
		setVisible(true);
		
		jLogin.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String myId = jtf1.getText();
				String myPwd = new String(jtf2.getPassword());
				String myBank = null;

				if(a.isSelected()==true) {
					myBank = a.getText();
				}else if(b.isSelected()==true) {
					myBank = b.getText();
				}else if(c.isSelected()==true) {
					myBank = c.getText();
				}
				JOptionPane.showMessageDialog
				(null,members.size());


//				for(int i =0; i < members.size(); i++) {
//					if(members.get(i).getName().equals(jtf1.getText())) {
//						JOptionPane.showMessageDialog
//						(null,myBank+"은행 "+ myId+ "고객님 안녕하세요.");
//						new BankApp_Main();
//						
//					}
//					else {
//						JOptionPane.showMessageDialog
//						(null,"로그인 정보가 맞지 않습니다.");
//						new BankApp_Login();
//						dispose();
//					}
//					
//				}
		
				
	
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
		new App();
	}

}

