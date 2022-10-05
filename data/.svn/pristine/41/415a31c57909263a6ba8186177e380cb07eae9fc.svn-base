package bankCommand;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringTokenizer;

import bankDto.Account;

public class AccCreate implements BankUserChkInter {
	List<Account> list= new ArrayList<Account>();
	public void joinAccount(String userId, String userPw) {
		seacrUserAcc();
		int idChk = 0;
		int accChk = 0;
		int grade = 3;
		int balance = 0;
		String account = accountCreate();
		// id중복확인
		for (Account acc : list) {
			if (acc.getUserId().equals(userId)) {
				idChk = 1;
				break;
			}
		}
		
		// 계좌 중복확인
		for (Account acc : list) {
			if (acc.getAccount().equals(account)) {
				accChk = 1;
				if (accChk == 1) {
					account = accountCreate();
				} else {
					accChk = 0;
				}
			}
		}
		
		// 회원가입
		if (idChk == 0) {
			fileInput(new Account(userId, userPw, account, balance, grade));
		} else {
			System.out.println("아이디 중복");
		}
//		list.stream().distinct();
//		for(Account acc : list) {
//			System.out.println(acc.getUserId());
//		}
	}

	public void fileInput(Account acc) {
		try {
			PrintWriter out = new PrintWriter(new FileWriter(new File("accList.txt"),true));

			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(acc.getUserId());
			stringBuilder.append("+");
			stringBuilder.append(acc.getUserPw());
			stringBuilder.append("+");
			stringBuilder.append(acc.getAccount());
			stringBuilder.append("+");
			stringBuilder.append(acc.getBalance());
			stringBuilder.append("+");
			stringBuilder.append(acc.getGrade());

			out.println(stringBuilder.toString());
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void seacrUserAcc() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("accList.txt")));

			while (bufferedReader.ready()) {
				StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine(), "+");
				while (stringTokenizer.hasMoreElements()) {
					Account acc = new Account(stringTokenizer.nextToken(), 
							stringTokenizer.nextToken(),
							stringTokenizer.nextToken(), 
							Integer.parseInt(stringTokenizer.nextToken()),
							Integer.parseInt(stringTokenizer.nextToken()));
					list.add(acc);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String accountCreate() {
		String account = "";

		Random rnd = new Random();
		String account1 = Integer.toString(rnd.nextInt(9999)) + "-";
		String account2 = Integer.toString(rnd.nextInt(9999)) + "-";
		String account3 = Integer.toString(rnd.nextInt(9999));

		if (account1.length() == 4) {
			account1 = "0" + account1;
		} else if (account1.length() == 3) {
			account1 = "00" + account1;
		} else if (account1.length() == 2) {
			account1 = "000" + account1;
		}
		if (account2.length() == 4) {
			account2 = "0" + account2;
		} else if (account2.length() == 3) {
			account2 = "00" + account2;
		} else if (account2.length() == 2) {
			account2 = "000" + account2;
		}
		if (account3.length() == 3) {
			account3 = "0" + account3;
		} else if (account3.length() == 2) {
			account3 = "00" + account3;
		} else if (account1.length() == 1) {
			account3 = "000" + account3;
		}

		account = account1 + account2 + account3;

		return account;
	}

}
