package app;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class BankApp_Main_Ex extends JFrame {
	JPanel jp = new JPanel();
	JButton push = new JButton("예금");
	JButton pull = new JButton("출금");
	JButton balance = new JButton("잔액조회");
	JButton logout = new JButton("로그아웃");
	public BankApp_Main_Ex() {
		super("Main");
		
		
		jp.setPreferredSize(new Dimension(10,10));
		jp.add(push);jp.add(pull);jp.add(balance);jp.add(logout);
		jp.setLayout(new GridLayout(2,2));
		add(jp);
		setBounds(200, 200, 500, 500);
		setResizable(false); 
		setVisible(true);

		logout.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				JOptionPane.showMessageDialog
				(null, "로그아웃하셨습니다.");
				new BankApp_Login();
				setVisible(false);
	
			}
			
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BankApp_Main_Ex();
	}

}
