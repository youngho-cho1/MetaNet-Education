package test;

public class AccountEx {
	public static void main(String[] args) {
		Account account = new Account();
		// 예금
		account.deposit(10000);
		System.out.println("예금액: " + account.getBalance()+"원");
		// 출금
		try {
			account.withdraw(15000);
			System.out.println("잔액 : "+account.getBalance()+"원");
		}catch(BalanceInsufficientException e) {
			String message = e.getMessage();
			System.out.println(message);
		}
	}
}
