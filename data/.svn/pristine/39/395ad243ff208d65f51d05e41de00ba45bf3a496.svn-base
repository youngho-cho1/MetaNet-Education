package controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bankCommand.BankCommand;
import exception.MoneyNullPointError;
import exception.MoneyOverInputError;
import exception.NoneUserIdInput;

public class BankController {
	static String sessionId = "";

	public BankController() {
		BankCommand command = new BankCommand();
		// 프레임 생성
		JFrame indexFrame = new JFrame("indexFrame");
		JFrame accountJoinFrame = new JFrame("회원가입");
		JFrame loginFrame = new JFrame("로그인");
		JFrame menuFrame = new JFrame("메뉴");
		JFrame balanceChkFrame = new JFrame("잔고확인");
		JFrame depositFrame = new JFrame("입금");
		JFrame withdrawFrame = new JFrame("출금");
		JFrame remittanceFrame = new JFrame("송금");
		JFrame alertFrame = new JFrame("경고");

		// 첫 panel 생성
		JPanel p1 = new JPanel(); // 첫페이지 레이아웃
		JPanel accountJoinPanel = new JPanel(); // 회원가입 페이지 레이아웃
		JPanel loginPanel = new JPanel();// 로그인 페이지 레이아웃
		JPanel menuPanel = new JPanel(); // 로그인후 메뉴 페이지 레이아웃
		JPanel balanceChkPanel = new JPanel(); // 잔고확인 페이지 레이아웃
		JPanel depositPanel = new JPanel(); // 입금 페이지 레이아웃
		JPanel withdrawPanel = new JPanel(); // 출금 페이지 레이아웃
		JPanel remittancePanel = new JPanel(); // 송금 페이지 레이아웃
		JPanel alertPanel = new JPanel(); // 송금 페이지 레이아웃

		// 인덱스 버튼 추가 패널
		JPanel btnPanel = new JPanel();
		JPanel btnPanel2 = new JPanel();

		// 회원가입 추가 패널
		JPanel joinInput = new JPanel();
		JPanel joinBtnPanel = new JPanel();

		// 로그인 추가패널
		JPanel loginInput = new JPanel();
		JPanel loginBtnPanel = new JPanel();

		// 메뉴 페이지 추가 패널
		JPanel menuBtn = new JPanel();
		JPanel menuTitlePanel = new JPanel();
		// 잔고 페이지 추가 패널
		JPanel balanceChkBtnPanel = new JPanel();
		// JPanel balanceChkBtnPanel2 =new JPanel();
		JPanel balanceChkLabel = new JPanel();

		// 입금페이지 추가 패널
		JPanel depositInputPanel = new JPanel();
		JPanel depositInputPanel2 = new JPanel();
		JPanel depositInputFinal = new JPanel();
		JPanel depositBtnPaenl = new JPanel();

		// 출금페이지 추가 패널
		JPanel withdrawInputPanel = new JPanel();
		JPanel withdrawInputPanel2 = new JPanel();
		JPanel withdrawInputFinal = new JPanel();
		JPanel withdrawBtnPaenl = new JPanel();

		// 송금 페이지 추가 패널
		JPanel remittanceInputPanel = new JPanel();
		JPanel remittanceInputPanel2 = new JPanel();
		JPanel remittanceInputFinal = new JPanel();
		JPanel remittanceBtnPaenl = new JPanel();

		// 경고창 추가 패널
		JPanel alertLabelPanel = new JPanel();
		JPanel alertBtnPanel = new JPanel();

		// title
		JLabel title1 = new JLabel("BANK");
		JLabel title2 = new JLabel("회원가입");
		JLabel title3 = new JLabel("로그인");
		JLabel userInfo = new JLabel();
		JLabel title4 = new JLabel("메뉴");
		JLabel title5 = new JLabel("잔고");
		JLabel title6 = new JLabel("입금");
		JLabel title7 = new JLabel("출금");
		JLabel title8 = new JLabel("송금");
		JLabel alertTitle = new JLabel("경고");

		// 라벨 가운데 정렬
		title1.setHorizontalAlignment(JLabel.CENTER);
		title1.setPreferredSize(new Dimension(150, 50));

		title2.setHorizontalAlignment(JLabel.CENTER);
		title2.setPreferredSize(new Dimension(300, 50));

		title3.setHorizontalAlignment(JLabel.CENTER);
		title3.setPreferredSize(new Dimension(300, 50));

		title4.setHorizontalAlignment(JLabel.CENTER);
		title4.setPreferredSize(new Dimension(300, 50));

		title5.setHorizontalAlignment(JLabel.CENTER);
		title5.setPreferredSize(new Dimension(300, 50));

		title6.setHorizontalAlignment(JLabel.CENTER);
		title6.setPreferredSize(new Dimension(300, 50));

		title7.setHorizontalAlignment(JLabel.CENTER);
		title7.setPreferredSize(new Dimension(300, 50));

		title8.setHorizontalAlignment(JLabel.CENTER);
		title8.setPreferredSize(new Dimension(300, 20));

		userInfo.setHorizontalAlignment(JLabel.CENTER);
		userInfo.setPreferredSize(new Dimension(300, 20));

		alertTitle.setHorizontalAlignment(JLabel.CENTER);
		alertTitle.setPreferredSize(new Dimension(300, 20));

		// -----회원가입 페이지 input 설정
		// 계좌생성 input
		JLabel joinUserId_la = new JLabel("아이디");
		JTextField joinUserId_tf = new JTextField(12);
		JLabel joinUserPw_la = new JLabel("비밀번호");
		JTextField joinUserPw_tf = new JTextField(12);
		// JLabel joinAccount_la =new JLabel("사용할 계좌번호");
		// JTextField joinAccount_tf = new JTextField();

		// 계좌생성 input들 panel에 담기
		// joinInput.setLayout(new GridLayout(3, 2));
		joinInput.setLayout(new GridLayout(2, 2));
		joinInput.add(joinUserId_la);
		joinInput.add(joinUserId_tf);
		joinInput.add(joinUserPw_la);
		joinInput.add(joinUserPw_tf);
		// joinInput.add(joinAccount_la);
		// joinInput.add(joinAccount_tf);

		// 로그인 페이지 input설정
		// 로그인 input
		JLabel loginInfo_la = new JLabel();
		JLabel loginUserId_la = new JLabel("아이디");
		JTextField loginUserId_tf = new JTextField(12);
		JLabel loginUserPw_la = new JLabel("비밀번호");
		JTextField loginUserPw_tf = new JTextField(12);
		// 로그인 input들 panel 에 담기
		loginInput.setLayout(new GridLayout(2, 2));
		loginInput.add(loginUserId_la);
		loginInput.add(loginUserId_tf);
		loginInput.add(loginUserPw_la);
		loginInput.add(loginUserPw_tf);

		// 잔고페이지 input설정
		// 잔고확인페이지 Lable
		JLabel balance_la1 = new JLabel();
		JLabel balance_la2 = new JLabel();
		JLabel balance_la3 = new JLabel();
		JLabel balance_la4 = new JLabel();
		JLabel balanceUserInfo = new JLabel();
		balance_la1.setHorizontalAlignment(JLabel.CENTER);
		balance_la1.setPreferredSize(new Dimension(300, 30));
		balanceUserInfo.setHorizontalAlignment(JLabel.CENTER);
		balanceUserInfo.setPreferredSize(new Dimension(500, 30));
		// 잔고확인 페이지 Label패널에 남기
		balanceChkLabel.add(balance_la1);

		// 입금 페이지 input설정
		// 입금 페이지 input
		JLabel depositInfo = new JLabel();
		JLabel deposit_la = new JLabel("입금 금액");
		JTextField deposit_tf = new JTextField(12);
		// 입금 페이지 Label패널에 남기
		depositInputFinal.setLayout(new GridLayout(2, 1));
		depositInputPanel.setLayout(new GridLayout(1, 2));
		depositInputPanel2.setLayout(new GridLayout(2, 1));
		depositInputPanel2.add(depositInfo);
		depositInputPanel2.add(balance_la2);
		depositInputPanel.add(deposit_la);
		depositInputPanel.add(deposit_tf);
		depositInputFinal.add(depositInputPanel2);
		depositInputFinal.add(depositInputPanel);

		// 출금 페이지 input설정
		// 출금 페이지 input
		JLabel withdrawInfo = new JLabel();
		JLabel withdraw_la = new JLabel("출금 금액");
		JTextField withdraw_tf = new JTextField(12);
		// 출금 페이지 Label패널에 남기
		withdrawInputFinal.setLayout(new GridLayout(2, 1));
		withdrawInputPanel.setLayout(new GridLayout(2, 2));
		withdrawInputPanel2.setLayout(new GridLayout(2, 1));
		withdrawInputPanel2.add(withdrawInfo);
		withdrawInputPanel2.add(balance_la3);
		withdrawInputPanel.add(withdraw_la);
		withdrawInputPanel.add(withdraw_tf);
		withdrawInputFinal.add(withdrawInputPanel2);
		withdrawInputFinal.add(withdrawInputPanel);

		// 송금 페이지 input 설정
		// 송금 페이지 input
		JLabel remittanceInfo = new JLabel();
		JLabel remittance_la = new JLabel("송금 금액");
		JLabel remittanceUserId_la = new JLabel("받는 사람 ID");
		JTextField remittance_tf = new JTextField(12);
		JTextField remittanceUserId_tf = new JTextField(12);
		// 송금 페이지 label패널에 담기
		remittanceInputFinal.setLayout(new GridLayout(2, 1));
		remittanceInputPanel.setLayout(new GridLayout(2, 2));
		remittanceInputPanel2.setLayout(new GridLayout(2, 1));
		remittanceInputPanel2.add(remittanceInfo);
		remittanceInputPanel2.add(balance_la4);
		remittanceInputPanel.add(remittanceUserId_la);
		remittanceInputPanel.add(remittanceUserId_tf);
		remittanceInputPanel.add(remittance_la);
		remittanceInputPanel.add(remittance_tf);
		remittanceInputFinal.add(remittanceInputPanel2);
		remittanceInputFinal.add(remittanceInputPanel);

		// 경고페이지 레이아웃
		JLabel alertText_la = new JLabel();
		alertText_la.setHorizontalAlignment(JLabel.CENTER);
		alertText_la.setPreferredSize(new Dimension(300, 20));
		alertLabelPanel.setLayout(new GridLayout(2, 1));
		alertLabelPanel.add(alertTitle);
		alertLabelPanel.add(alertText_la);

		// ----------------------button생성
		// 첫화면 버튼
		JButton logBtn1 = new JButton("로그인"); // 로그인 이동 btn
		JButton joinBtn1 = new JButton("회원가입"); // 회원가입 이동 btn
		JButton extiBtn = new JButton("종료");

		// 회원가입 화면 버튼
		JButton joinHome = new JButton("Home");
		JButton joinBtn2 = new JButton("회원가입"); // 회원가입 실행 btn

		// 로그인 화면 버튼
		JButton loginHome = new JButton("Home");
		JButton logBtn2 = new JButton("로그인"); // 로그인 실행 btn

		// 메뉴페이지 버튼
		JButton menuLogOut = new JButton("로그아웃");
		JButton menuDeposite = new JButton("입금");
		JButton menuWithdraw = new JButton("출금");
		JButton menuRemittance = new JButton("송금");
		JButton menuBalanceChk = new JButton("잔고 확인");

		// 잔고확인 페이지 버튼
		JButton balanceMenu = new JButton("메뉴");
		JButton balanceDeposite = new JButton("입금");
		JButton balanceWithdraw = new JButton("출금");
		JButton balanceRemittance = new JButton("송금");

		// 입금 페이지 버튼
		JButton depositMenuBtn = new JButton("메뉴");
		JButton depositConfirmBtn = new JButton("입금하기");

		// 출금 페이지 버튼
		JButton withdrawMenuBtn = new JButton("메뉴");
		JButton withdrawConfirmBtn = new JButton("출금하기");

		// 송금페이지 버튼
		JButton remittanceMenuBtn = new JButton("메뉴");
		JButton remittanceConfirmBtn = new JButton("송금하기");

		// 경고페이지 버튼
		JButton alertConfirmBtn = new JButton("확인");

		// ------------프레임들 레이아웃 설정
		p1.setLayout(new BorderLayout());
		accountJoinFrame.setLayout(new BorderLayout());
		loginFrame.setLayout(new BorderLayout());
		menuFrame.setLayout(new BorderLayout());
		balanceChkFrame.setLayout(new BorderLayout());
		withdrawFrame.setLayout(new BorderLayout());
		depositFrame.setLayout(new BorderLayout());
		remittanceFrame.setLayout(new BorderLayout());
		alertConfirmBtn.setLayout(new BorderLayout());

		// --------버튼 크기 조절
		// index
		logBtn1.setPreferredSize(new Dimension(150, 50));
		joinBtn1.setPreferredSize(new Dimension(150, 50));
		extiBtn.setPreferredSize(new Dimension(150, 50));
		// accountjoin
		joinBtn2.setPreferredSize(new Dimension(150, 50));
		joinHome.setPreferredSize(new Dimension(150, 50));
		// login
		logBtn2.setPreferredSize(new Dimension(150, 50));
		loginHome.setPreferredSize(new Dimension(150, 50));
		// menu
		menuLogOut.setPreferredSize(new Dimension(150, 50));
		menuDeposite.setPreferredSize(new Dimension(150, 50));
		menuWithdraw.setPreferredSize(new Dimension(150, 50));
		menuRemittance.setPreferredSize(new Dimension(150, 50));
		menuBalanceChk.setPreferredSize(new Dimension(150, 50));
		// balanceChk
		balanceMenu.setPreferredSize(new Dimension(150, 50));
		balanceDeposite.setPreferredSize(new Dimension(150, 50));
		balanceWithdraw.setPreferredSize(new Dimension(150, 50));
		balanceRemittance.setPreferredSize(new Dimension(150, 50));
		// withdraw
		withdrawMenuBtn.setPreferredSize(new Dimension(150, 50));
		withdrawConfirmBtn.setPreferredSize(new Dimension(150, 50));
		// deposit
		depositMenuBtn.setPreferredSize(new Dimension(150, 50));
		depositConfirmBtn.setPreferredSize(new Dimension(150, 50));
		// remittance
		remittanceMenuBtn.setPreferredSize(new Dimension(150, 50));
		remittanceConfirmBtn.setPreferredSize(new Dimension(150, 50));
		// alert
		alertConfirmBtn.setPreferredSize(new Dimension(100, 30));

		// ---------------------------frame에 panel삽입
		// 첫 페이지
		// 인덱스 버튼 패널 center
		btnPanel.add(logBtn1);
		btnPanel.add(joinBtn1);
		// 인덱스 버튼 패널 south
		btnPanel2.add(extiBtn);
		p1.add(title1, BorderLayout.NORTH);
		p1.add(btnPanel, BorderLayout.CENTER);
		p1.add(btnPanel2, BorderLayout.SOUTH);

		// 회원 가입 페이지
		joinBtnPanel.add(joinHome);
		joinBtnPanel.add(joinBtn2);
		accountJoinPanel.add(title2, BorderLayout.NORTH);
		accountJoinPanel.add(joinInput, BorderLayout.CENTER);
		accountJoinPanel.add(joinBtnPanel, BorderLayout.SOUTH);

		// 로그인 페이지
		loginBtnPanel.add(loginHome);
		loginBtnPanel.add(logBtn2);
		loginPanel.add(loginInfo_la, BorderLayout.NORTH);
		loginPanel.add(title3, BorderLayout.NORTH);
		loginPanel.add(loginInput, BorderLayout.CENTER);
		loginPanel.add(loginBtnPanel, BorderLayout.SOUTH);

		// menu페이지
//		menuPanel.setLayout(new GridLayout(4,1));
		menuBtn.setLayout(new GridLayout(5, 1));
		menuBtn.add(menuBalanceChk);
		menuBtn.add(menuDeposite);
		menuBtn.add(menuWithdraw);
		menuBtn.add(menuRemittance);
		menuBtn.add(menuLogOut);
//		menuTitlePanel.add(title4);
//		menuTitlePanel.add(userInfo);
		menuPanel.add(title4, BorderLayout.NORTH);
		menuPanel.add(menuTitlePanel, BorderLayout.NORTH);
		menuPanel.add(menuBtn, BorderLayout.SOUTH);
//		menuPanel.add(title4);
//		menuPanel.add(userInfo);
//		menuPanel.add(menuTitlePanel);
//		menuPanel.add(menuBtn);

		// 잔고확인 페이지
		balanceChkBtnPanel.setLayout(new GridLayout(4, 1));
		balanceChkBtnPanel.add(balanceDeposite);
		balanceChkBtnPanel.add(balanceWithdraw);
		balanceChkBtnPanel.add(balanceRemittance);
		balanceChkBtnPanel.add(balanceMenu);
		balanceChkPanel.add(title5, BorderLayout.NORTH);
		balanceChkPanel.add(balanceUserInfo, BorderLayout.NORTH);
		balanceChkPanel.add(balanceChkLabel, BorderLayout.CENTER);
		balanceChkPanel.add(balanceChkBtnPanel, BorderLayout.SOUTH);
		// balanceChkPanel.add(balanceChkBtnPanel2,BorderLayout.SOUTH);

		// 입금 페이지
		depositBtnPaenl.setLayout(new GridLayout(1, 2));
		depositBtnPaenl.add(depositMenuBtn);
		depositBtnPaenl.add(depositConfirmBtn);
		depositPanel.add(title6, BorderLayout.NORTH);
		depositPanel.add(depositInputFinal, BorderLayout.CENTER);
		depositPanel.add(depositBtnPaenl, BorderLayout.SOUTH);

		// 출금 페이지
		withdrawBtnPaenl.setLayout(new GridLayout(1, 2));
		withdrawBtnPaenl.add(withdrawMenuBtn);
		withdrawBtnPaenl.add(withdrawConfirmBtn);
		withdrawPanel.add(title7, BorderLayout.NORTH);
		withdrawPanel.add(withdrawInputFinal, BorderLayout.CENTER);
		withdrawPanel.add(withdrawBtnPaenl, BorderLayout.SOUTH);

		// 송금 페이지
		remittanceBtnPaenl.setLayout(new GridLayout(1, 2));
		remittanceBtnPaenl.add(remittanceMenuBtn);
		remittanceBtnPaenl.add(remittanceConfirmBtn);
		remittancePanel.add(title8, BorderLayout.NORTH);
		remittancePanel.add(remittanceInputFinal, BorderLayout.CENTER);
		remittancePanel.add(remittanceBtnPaenl, BorderLayout.SOUTH);

		// 경고페이지
		alertBtnPanel.add(alertConfirmBtn);
		alertPanel.add(alertLabelPanel, BorderLayout.CENTER);
		alertPanel.add(alertBtnPanel, BorderLayout.SOUTH);

		// ------------------버튼 설정--------------------------------------
		// index페이지 회원가입 페이지 이동
		joinBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				accountJoinFrame.setVisible(true);
				indexFrame.dispose();
			}
		});
		// index페이지 로그인 페이지 이동
		logBtn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginFrame.setVisible(true);
				indexFrame.dispose();

			}
		});

		// index페이지 종료 버튼 설정
		extiBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				indexFrame.dispose();
			}
		});

		// 계좌 생성 페이지 joinHome 버튼 설정
		joinHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				indexFrame.setVisible(true);
				accountJoinFrame.dispose();
			}
		});
		// 회원가입 페이지 joinBtn2 버튼 설정
		joinBtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userId = joinUserId_tf.getText();
				String userPw = joinUserPw_tf.getText();
//				String account = joinAccount_tf.getText();
//				int balance =0;
				// command.joinAccount(userId, userPw, account, balance);
				command.joinAccount(userId, userPw);
				accountJoinFrame.dispose();
				loginFrame.setVisible(true);
				joinUserId_tf.setText("");
				joinUserPw_tf.setText("");
//				joinAccount_tf.setText("");
			}
		});

		// 로그인페이지 HOME버튼 설정
		loginHome.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				indexFrame.setVisible(true);
				loginFrame.dispose();
			}
		});
		// 로그인 페이지 login 버튼 설정
		logBtn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userId = loginUserId_tf.getText();
				String userPw = loginUserPw_tf.getText();
				sessionId = command.login(userId, userPw);
				if (sessionId.equals(userId)) {
					loginFrame.dispose();
					menuFrame.setVisible(true);
					loginUserId_tf.setText("");
					loginUserPw_tf.setText("");
					String grade = command.getGrade(sessionId);
					balanceUserInfo.setText(userId + "님/회원 등급 : " + grade);
				} else {
					loginUserId_tf.setText("");
					loginUserPw_tf.setText("");
					loginInfo_la.setText(sessionId);
					System.out.println(sessionId);
				}
			}
		});

		// 메뉴페이지 로그아웃
		menuLogOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				indexFrame.setVisible(true);
				menuFrame.dispose();
			}
		});

		// 메뉴페이지 잔고확인
		menuBalanceChk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuFrame.dispose();
				int balanceChk = 0;
				balanceChk = command.balanceChk(sessionId);
				String grade = command.getGrade(sessionId);
				balance_la1.setText(balanceChk + "원");
				balanceUserInfo.setText(sessionId + "님/회원 등급 : " + grade);
				balanceChkFrame.setVisible(true);
			}
		});
		// 메뉴페이지 입금
		menuDeposite.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuFrame.dispose();
				int balanceChk = 0;
				balanceChk = command.balanceChk(sessionId);

				balance_la2.setText("통장 잔고" + balanceChk + "원");

				depositFrame.setVisible(true);
			}
		});
		// 메뉴페이지 출금
		menuWithdraw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuFrame.dispose();
				int balanceChk = 0;
				balanceChk = command.balanceChk(sessionId);

				balance_la3.setText("통장 잔고" + balanceChk + "원");

				withdrawFrame.setVisible(true);
			}
		});

		// 메뉴페이지 송금
		menuRemittance.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuFrame.dispose();
				int balanceChk = 0;
				balanceChk = command.balanceChk(sessionId);

				balance_la4.setText("통장 잔고" + balanceChk + "원");

				remittanceFrame.setVisible(true);
			}
		});

		// 메뉴페이지 로그아웃
		menuLogOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sessionId = "";
				menuFrame.dispose();
				indexFrame.setVisible(true);
			}
		});

		// 잔고확인 페이지 메뉴
		balanceMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				balanceChkFrame.dispose();
				menuFrame.setVisible(true);
			}
		});
		// 잔고확인 페이지 입금
		balanceDeposite.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				balanceChkFrame.dispose();
				int balanceChk = 0;
				balanceChk = command.balanceChk(sessionId);

				balance_la2.setText("통장 잔고" + balanceChk + "원");

				depositFrame.setVisible(true);
			}
		});
		// 잔고확인 페이지 출금
		balanceWithdraw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				balanceChkFrame.dispose();
				int balanceChk = 0;
				balanceChk = command.balanceChk(sessionId);

				balance_la3.setText("통장 잔고" + balanceChk + "원");

				withdrawFrame.setVisible(true);
			}
		});

		// 잔고확인 페이지 송금
		balanceRemittance.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				balanceChkFrame.dispose();
				int balanceChk = 0;
				balanceChk = command.balanceChk(sessionId);

				balance_la4.setText("통장 잔고" + balanceChk + "원");

				remittanceFrame.setVisible(true);
			}
		});

		// 입금 페이지 메뉴 버튼
		depositMenuBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				depositFrame.dispose();
				menuFrame.setVisible(true);
			}
		});

		// 입금 페이지 입금하기 버튼
		depositConfirmBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int balance = 0;
				try {
					if (deposit_tf.equals(""))
						throw new NumberFormatException();
					int money = Integer.parseInt(deposit_tf.getText());
					if (money < 0) {
						depositInfo.setText("입금 금액을 확인해주세요");
					} else {
						depositInfo.setText("");
						command.deposit(sessionId, money);
						balance = command.balanceChk(sessionId);
						balance_la1.setText(Integer.toString(balance) + "원");
						balanceChkFrame.setVisible(true);
						depositFrame.dispose();
						deposit_tf.setText("");
						String grade = command.getGrade(sessionId);
						balanceUserInfo.setText(sessionId + "님/회원 등급 : " + grade);
					}
				} catch (NumberFormatException e3) {
					alertText_la.setText("금액을 입력하세요");
					alertFrame.setVisible(true);
				}
			}
		});

		// 출금 페이지 메뉴 버튼
		withdrawMenuBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				withdrawFrame.dispose();
				menuFrame.setVisible(true);
			}
		});
		// 출금 페이지 출금하기 버튼
		withdrawConfirmBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int balance = 0;
				try {
					if (remittance_tf.equals(""))
						throw new NumberFormatException();
					if (withdraw_tf.equals(""))
						throw new MoneyNullPointError();
					int money = Integer.parseInt(withdraw_tf.getText());
					int money2 = (int) (Math.round((double) money * 1.01));
					if (money < 0 || money2 > Integer
							.parseInt(balance_la3.getText().substring(5, balance_la3.getText().length() - 1))) {
						withdrawInfo.setText("출금 금액을 확인해주세요");
					} else {
						withdrawInfo.setText("");
						command.withdraw(sessionId, money);
						command.balanceChk(sessionId);
						balance = command.balanceChk(sessionId);
						balance_la1.setText("통장 잔고" + balance + "원");
						balanceChkFrame.setVisible(true);
						withdrawFrame.dispose();
						withdraw_tf.setText("");
						String grade = command.getGrade(sessionId);
						balanceUserInfo.setText(sessionId + "님/회원 등급 : " + grade);
					}
				} catch (MoneyNullPointError e4) {
					alertText_la.setText("금액을 입력하세요");
					alertFrame.setVisible(true);
				} catch (NumberFormatException e4) {
					alertText_la.setText("금액을 입력하세요");
					alertFrame.setVisible(true);
				}
			}
		});

		// 송금 페이지 메뉴 버튼
		remittanceMenuBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remittanceFrame.dispose();
				menuFrame.setVisible(true);
			}
		});

		// 송금페이지 송금하기 버튼
		remittanceConfirmBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int balance = 0;
				try {
					int money = Integer.parseInt(remittance_tf.getText());
					//아이디 안적었을때
					if (remittanceUserId_tf.getText().equals("")) {
						throw new NoneUserIdInput();
					//아이디는 적음
					}else{
						//아이디는 적었는데 금액 안적었을때
						if (remittance_tf.getText().equals("")) {
							throw new NumberFormatException();
							//아이디 적었는대 금액이 잔고보다 크거나 0보다 작을때
						} else if (money < 0 || money > Integer
								.parseInt(balance_la4.getText().substring(5, balance_la4.getText().length() - 1))) {
							throw new MoneyOverInputError();
//						remittanceInfo.setText("송금 금액을 확인해주세요");
						}else{
							remittanceInfo.setText("");
							String userId = remittanceUserId_tf.getText();
							command.remittance(sessionId, userId, money);
							command.balanceChk(sessionId);
							balance = command.balanceChk(sessionId);
							balance_la1.setText(Integer.toString(balance));
							balanceChkFrame.setVisible(true);
							remittanceFrame.dispose();
							remittance_tf.setText("");
							remittanceUserId_tf.setText("");
							String grade = command.getGrade(sessionId);
							balanceUserInfo.setText(sessionId + "님/회원 등급 : " + grade);
						}
					}
				} catch (NoneUserIdInput e2) {
					alertText_la.setText("받는 사람을 입력하세요");
					alertFrame.setVisible(true);
				} catch (MoneyOverInputError e2) {
					alertText_la.setText("잔고보다 보내는 금액이 큽니다.");
					alertFrame.setVisible(true);
				} catch (NumberFormatException e2) {
					alertText_la.setText("금액을 입력하세요");
					alertFrame.setVisible(true);
				}
			}
		});

		// 경고페이지 확인 버튼
		alertConfirmBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				alertFrame.dispose();
			}
		});

		// ---------------------frame설정
		indexFrame.add(p1);

		indexFrame.setVisible(true); // 창 보이기
		indexFrame.setResizable(false); // 창 크기 조절 안되게
		indexFrame.setSize(300, 400); // 창크기 설정
		indexFrame.setLocationRelativeTo(null); // 창 위치 null로 정해놓으면 중앙에 보임
		indexFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x눌렀을때 종료 되도록

		accountJoinFrame.add(accountJoinPanel);

		accountJoinFrame.setVisible(false); // 창 보이기
		accountJoinFrame.setResizable(false); // 창 크기 조절 안되게
		accountJoinFrame.setSize(300, 400); // 창크기 설정
		accountJoinFrame.setLocationRelativeTo(null); // 창 위치 null로 정해놓으면 중앙에 보임
		accountJoinFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x눌렀을때 종료 되도록

		loginFrame.add(loginPanel);

		loginFrame.setVisible(false); // 창 보이기
		loginFrame.setResizable(false); // 창 크기 조절 안되게
		loginFrame.setSize(300, 300); // 창크기 설정
		loginFrame.setLocationRelativeTo(null); // 창 위치 null로 정해놓으면 중앙에 보임
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x눌렀을때 종료 되도록
		loginFrame.add(loginPanel);

		menuFrame.add(menuPanel);

		menuFrame.setVisible(false); // 창 보이기
		menuFrame.setResizable(false); // 창 크기 조절 안되게
		menuFrame.setSize(300, 400); // 창크기 설정
		menuFrame.setLocationRelativeTo(null); // 창 위치 null로 정해놓으면 중앙에 보임
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x눌렀을때 종료 되도록

		balanceChkFrame.add(balanceChkPanel);

		balanceChkFrame.setVisible(false); // 창 보이기
		balanceChkFrame.setResizable(false); // 창 크기 조절 안되게
		balanceChkFrame.setSize(400, 400); // 창크기 설정
		balanceChkFrame.setLocationRelativeTo(null); // 창 위치 null로 정해놓으면 중앙에 보임
		balanceChkFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x눌렀을때 종료 되도록

		depositFrame.add(depositPanel);

		depositFrame.setVisible(false); // 창 보이기
		depositFrame.setResizable(false); // 창 크기 조절 안되게
		depositFrame.setSize(500, 400); // 창크기 설정
		depositFrame.setLocationRelativeTo(null); // 창 위치 null로 정해놓으면 중앙에 보임
		depositFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x눌렀을때 종료 되도록

		withdrawFrame.add(withdrawPanel);

		withdrawFrame.setVisible(false); // 창 보이기
		withdrawFrame.setResizable(false); // 창 크기 조절 안되게
		withdrawFrame.setSize(500, 400); // 창크기 설정
		withdrawFrame.setLocationRelativeTo(null); // 창 위치 null로 정해놓으면 중앙에 보임
		withdrawFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x눌렀을때 종료 되도록

		remittanceFrame.add(remittancePanel);

		remittanceFrame.setVisible(false); // 창 보이기
		remittanceFrame.setResizable(false); // 창 크기 조절 안되게
		remittanceFrame.setSize(500, 400); // 창크기 설정
		remittanceFrame.setLocationRelativeTo(null); // 창 위치 null로 정해놓으면 중앙에 보임
		remittanceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x눌렀을때 종료 되도록

		alertFrame.add(alertPanel);

		alertFrame.setVisible(false); // 창 보이기
		alertFrame.setResizable(false); // 창 크기 조절 안되게
		alertFrame.setSize(300, 200); // 창크기 설정
		alertFrame.setLocationRelativeTo(null); // 창 위치 null로 정해놓으면 중앙에 보임
		alertFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // x눌렀을때 종료 되도록
	}

	public static void main(String[] args) {
		new BankController();
	}
}