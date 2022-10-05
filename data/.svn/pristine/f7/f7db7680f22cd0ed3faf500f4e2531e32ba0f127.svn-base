package bankCommand;

import java.util.Random;

import dao.Dao;

public class DBAccCreate {
	public void joinAccount(String userId, String userPw) {
		int rs =0;
		Dao dao = Dao.getInstance();
		String account = accountCreate();
		rs = dao.joinAcc(userId, userPw, account);
		
		if(rs!=1) {
			account = accountCreate();
			rs = dao.joinAcc(userId, userPw, account);
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
