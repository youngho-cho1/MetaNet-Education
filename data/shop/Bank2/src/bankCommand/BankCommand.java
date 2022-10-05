package bankCommand;

import java.util.ArrayList;
import java.util.Random;

import bankDto.Account;
import bankDto.HistoryDto;
import exception.LoginError;
import exception.LoginIdNullPointError;
import exception.LoginNotExistId;
import exception.LoginPwNullPointError;

public class BankCommand implements BankInterface {
	ArrayList<Account> userList = new ArrayList<>();
	ArrayList<HistoryDto> list = new ArrayList<HistoryDto>();

	// 회원가입
	@Override
	public void joinAccount(String userId, String userPw) {
		// , String account, int balance) {
		int idChk = 0;
		int accChk = 0;
		int grade = 3;
		int balance = 0;
		String account = accountCreate();

		for (Account acc : userList) {
			if (acc.getUserId().equals(userId)) {
				idChk = 1;
				break;
			}
		}
		for (Account acc : userList) {
			if (acc.getAccount().equals(account)) {
				accChk = 1;
				if (accChk == 1) {
					account = accountCreate();
					break;
				} else {
					accChk = 0;
				}
			}
		}
		// 아이디 중복 확인
		if (idChk == 0) {
			userList.add(new Account(userId, userPw, account, balance, grade));
			for (Account acc : userList) {
				System.out.println("아이디 : " + acc.getUserId() + "\t 비밀번호 : " + acc.getUserPw() + "\t계좌번호 : "
						+ acc.getAccount() + "\t 잔고 : " + acc.getBalance() + "원\t 회원 등급 : " + acc.getGrade());
			}
			System.out.println(userList.size());
		} else {
			System.out.println("아이디 중복");
		}
	}

	// 로그인
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public String login(String userId, String userPw) {
		String id = "";
		try {
			// null값 확인
			if (userId.equals(""))
				throw new LoginIdNullPointError();
			if (userPw.equals(""))
				throw new LoginPwNullPointError();
			for (Account acc : userList) {
				int chk = 0;
				chk++;
				if (acc.getUserId().equals(userId) && userList.size() > 0) {
					if (acc.getUserPw().equals(userPw)) {
						System.out.println("로그인 성공");
						id = userId;
					} else {
						// 비밀번호 확인
						throw new LoginError();
					}
				}
				// 아이디 존재 여부 확인
				else if (chk == userList.size() && userList.contains(acc.getUserId()) == false) {
					throw new LoginNotExistId();
				}
			}
		} catch (LoginIdNullPointError e) {
			id = "아이디를 입력하세요";
		} catch (LoginPwNullPointError e) {
			id = "비밀번호를 입력하세요";
		} catch (LoginError e) {
			id = "비밀번호를 확인하세요";
		} catch (LoginNotExistId e) {
			id = "존재하지 않는 아이디 입니다.";
		}
		System.out.println(id);
		return id;
	}

	// 입금
	@Override
	public void deposit(String userId, int money) {
		for (Account acc : userList) {
			if (acc.getUserId().equals(userId)) {
				acc.setBalance(acc.getBalance() + money);
				list.add(new HistoryDto(userId, money));
			}
			if(acc.getBalance()>10000000 && acc.getBalance()<100000000) {
				acc.setGrade(2);
			}else if(acc.getBalance()>100000000) {
				acc.setGrade(1);
			}else {
				acc.setGrade(3);
			}
		}
	}

	// 출금
	@Override
	public void withdraw(String userId, int money) {
		int money2 = (int) (Math.round((double) money * 1.01));
		for (Account acc : userList) {
			if (acc.getGrade() == 3 || acc.getGrade() == 2) {
				if (acc.getUserId().equals(userId)) {
					acc.setBalance(acc.getBalance() - money2);
					list.add(new HistoryDto(userId, money));
				} else if (acc.getGrade() == 2 && money >= 50000000) {
					acc.setBalance(acc.getBalance() - money);
					list.add(new HistoryDto(userId, money));
				} else {
					acc.setBalance(acc.getBalance() - money);
					list.add(new HistoryDto(userId, money));
				}
			}
		}
	}

	// 잔고확인
	@Override
	public int balanceChk(String userId) {
		int balance = 0;
		for (Account acc : userList) {
			if (acc.getUserId().equals(userId)) {
				balance = acc.getBalance();
			}
		}
		return balance;
	}

	// 송금
	@Override
	public void remittance(String sessionId, String userId, int money) {
		int userChk = 0;
		int money2 = (int) (Math.round((double) money * 1.01));
		// 보내는사람 계좌 있는지 확인
		for (Account acc : userList) {
			if (acc.getUserId().equals(userId)) {
				System.out.println("계좌 찾음 ");
				userChk = 1;
				break;
			}
		}

		if (userChk == 1) {
			for (Account acc : userList) {
				// 돈 보내는사람
				if (acc.getGrade() == 3 || acc.getGrade() == 2) {
					if (acc.getUserId().equals(userId)) {
						acc.setBalance(acc.getBalance() - money2);
						list.add(new HistoryDto(userId, money));
					} else if (acc.getGrade() == 2 && money >= 50000000) {
						acc.setBalance(acc.getBalance() - money);
						list.add(new HistoryDto(userId, money));
					} else {
						acc.setBalance(acc.getBalance() - money);
						list.add(new HistoryDto(userId, money));
					}
				}
				// 돈 받는 사람
				if (acc.getUserId().equals(userId)) {
					acc.setBalance(acc.getBalance() + money);
				}
			}
		} else {
			System.out.println("받는사람 아이디 확인");
		}
	}

	@Override
	public String getGrade(String sessionId) {
		String grade = "";
		for (Account acc : userList) {
			if (acc.getUserId().equals(sessionId)) {
				if (acc.getGrade() == 1) {
					grade = "VVIP";
				} else if (acc.getGrade() == 2) {
					grade = "VIP";
				} else {
					grade = "일반회원";
				}
			}
		}
		return grade;
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
