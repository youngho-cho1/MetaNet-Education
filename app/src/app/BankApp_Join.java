package app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
@SuppressWarnings("serial")
public class BankApp_Join extends JFrame  {
	static Member member = new Member();
	static List<Member> members= new ArrayList<>();
	static int count = 0;
	String choice = null;
	public BankApp_Join() {
		setTitle("회원관리");
		JLabel title = new JLabel("회원가입", JLabel.CENTER);
		
		JButton join = new JButton("회원가입");
		JButton cancel = new JButton("취소");
		
		JTextField bank = new JTextField(10);
		JTextField name = new JTextField(10);
		JTextField account = new JTextField(10);
		JPasswordField pwd = new JPasswordField(10);
		
//		JPanel bankPanel = new JPanel();
//		bankPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
//		bankPanel.add(new JLabel("은행 : "));
//		bankPanel.add(bank);
		
		JRadioButton a = new JRadioButton("기업은행");
		JRadioButton b = new JRadioButton("농협은행");
		JRadioButton c = new JRadioButton("신한은행");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(a);bg.add(b);bg.add(c);
		
		JPanel radioPanel = new JPanel();
		radioPanel.add(a);
		radioPanel.add(b);
		radioPanel.add(c);
		
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
//		formPanel.add(bankPanel);
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
		setVisible(true);
		
		join.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				member.setName(name.getText());
				member.setAccount(account.getText());
				member.setPasswd(String.valueOf(pwd.getPassword()));
				
				if(a.isSelected()) {
					member.setBankname(a.getText());
				}else if(b.isSelected()) {
					member.setBankname(b.getText());
				}else if(a.isSelected()) {
					member.setBankname(c.getText());
				}
				members.add(member);
				
				try {
					if(member.getBankname().isEmpty() == true) {
						JOptionPane.showMessageDialog
						(null, "공백란을 입력해주세요.");
						new BankApp_Join();
						dispose();
					}
					else {
						JOptionPane.showMessageDialog
						(null, "은행 : "+ member.getBankname() + ", 이름 : "+ member.getName() +
								", 계좌 : "+ member.getAccount() + ", 비밀번호 : "+ member.getPasswd() + "\n"+
								members.size()+"번째 가입을 축하드립니다.");
						count ++ ;
						new BankApp_Login();
						dispose();
						
					}
				}
				catch(NullPointerException e1){
					System.out.println("공백란을 입력해주세요. " + e1.getMessage());
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
//else {
//	if(count > 0) {
//		if(members.size()> 0) {
//			for(int i=0;i<members.size()+1;i++) {
//				for(int j =i+1; j<members.size()+1;j++) {
//					if(members.get(i) == members.get(j)) {
//						JOptionPane.showMessageDialog
//						(null, "정보가 중복됩니다. 회원가입을 다시 해주세요");
//					}else {
//						JOptionPane.showMessageDialog
//						(null, "뚫림");
//					}
//				}
//			}
//		}
//	}else {
//		
//	}
//}
//else {
//	

//}
