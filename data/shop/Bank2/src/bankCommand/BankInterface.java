package bankCommand;

public interface BankInterface {
	//회원가입
	//void joinAccount(String userId, String userPw, String account, int balance);
	void joinAccount(String userId, String userPw);
	//로그인
	String login(String userId, String userPw);
	//입금 
	void deposit(String userId, int money);
	//출금
	void withdraw(String userId, int money);
	//잔고 확인
	int balanceChk(String userId);
	//송금 remittance
	void remittance(String sessionId, String userId, int money);
	//등급 가져오기
	String getGrade(String sessionId);
}
