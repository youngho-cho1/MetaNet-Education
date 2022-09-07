package app;
import javax.swing.*;
import java.util.*;

public class BankApp implements Bank {
	static Member member = new Member(); 
	static int cnt = 0;
	static List<Member> members= new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu=0;
		String id,pwd,bank,account;
		BankApp app = new BankApp();
		/* app.login("농협", "홍길동", 1, "1234"); */
		while(menu!=6) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("0.회원가입 | 1.로그인 | 2.예금 | 3.출금 | 4.잔고 | 5.로그아웃 | 6.종료");
			System.out.println("-----------------------------------------------------------");
			Scanner sc = new Scanner(System.in);
			System.out.print("선택: ");
			menu = sc.nextInt();
			if (cnt == 0) {
				if(menu == 6) {
					menu = 6;
				}
				else if(menu == 5) {
					System.out.println("로그인 하지 않으셨습니다.");
					menu = 1;
				}
				else if(menu == 0) {
					System.out.println("회원가입을 진행하겠습니다.");
				}
				else {
					System.out.println("로그인을 하세요.");
					menu = 1;
				}	
				
			}
			switch(menu) {
			case 0:{
//				app.join("농협", "홍길동", 1, "1234");
				System.out.print("은행 입력: ");
				member.setBankname(sc.next());
				System.out.print("이름 입력: ");
				member.setName(sc.next());
				System.out.print("계좌 입력: ");
				member.setAccount(sc.next());
				System.out.print("비밀번호 입력: ");
				member.setPasswd(sc.next());
				
				members.add(member);
				System.out.println("회원가입에 성공하였습니다.");
				break;
				
				}
			case 1:{
				System.out.print("은행 입력: ");
				bank = sc.next();
				System.out.print("이름 입력: ");
				id = sc.next();
				System.out.print("비밀번호를 입력: ");
				pwd = sc.next();
				
				app.login(bank, id, pwd);
				
				break;
			}
			case 2:{
				app.push("농협", "홍길동", "1", 5000, "1234");
				break;
			}
			case 3:{
				app.pull("신협", "홍길동", "1", 5000, "1234");
				break;
			}
			case 4:{
				app.balance("농협", "홍길동", "1", "1234");
				break;
			}
			case 5:{
				app.logout();
				break;
			}
			case 6:{
				System.out.print("프로그램 종료");
				break;
			}
			
		}
	  }

	}

	@Override
	public boolean push(String bankname, String name, String account, int money, String passwd) {
		// TODO Auto-generated method stub
		boolean result = false;
		if(bankname.equals(member.getBankname())
				&& name.equals(member.getName()) && account.equals(member.getAccount())
				&& passwd.equals(member.getPasswd())) {
			System.out.println(member.getName() + "님");
			member.setDeposit(money + member.getDeposit());
			System.out.println(member.getName() + "님 " + money + "원이 입급 되었습니다.");
			System.out.println(member.getName() + "님의 잔액은 " + member.getDeposit() + "원입니다.");
			result = true;
		
		}
		else if(!bankname.equals(member.getBankname())) {
			System.out.println("입금 수수료가 부과됩니다 (500원).");
			member.setDeposit(member.getDeposit() - (money+500));
			System.out.println(member.getName() + "님 " + money + "원이 입금 되었습니다. ");
			System.out.println(member.getName() + "님의 잔액은 " + member.getDeposit() + "원입니다.");
		}
		else {
			System.out.println("예금 은행, 이름, 계좌, 비밀번호를 확인해주세요.");
		}
		return result;
	}

	@Override
	public boolean pull(String bankname, String name, String account, int money, String passwd) {
		// TODO Auto-generated method stub
		boolean result = false;
		if(bankname.equals(member.getBankname())
				&& name.equals(member.getName()) && account.equals(member.getAccount())
				&& passwd.equals(member.getPasswd())) {
			member.setDeposit(member.getDeposit() - money);
			System.out.println(member.getName() + "님 " + money + "원이 출금 되었습니다.");
			System.out.println(member.getName() + "님의 잔액은 " + member.getDeposit() + "원입니다.");
			result = true;
		}
		else if(!bankname.equals(member.getBankname())) {
			System.out.println("출금 수수료가 부과됩니다 (500원).");
			member.setDeposit(member.getDeposit() - (money+500));
			System.out.println(member.getName() + "님 " + money + "원이 출금 되었습니다. ");
			System.out.println(member.getName() + "님의 잔액은 " + member.getDeposit() + "원입니다.");
		}
		else {
			System.out.println("예금 은행, 이름, 계좌, 비밀번호를 확인해주세요.");
		}
		return result;
	}

	@Override
	public boolean balance(String bankname, String name, String account, String passwd) {
		// TODO Auto-generated method stub
		boolean result = false;
		if(bankname.equals(member.getBankname())
				&& name.equals(member.getName()) && account.equals(member.getAccount())
				&& passwd.equals(member.getPasswd())) {
			System.out.println(member.getName() + "님의 잔액은 " + member.getDeposit() + "원입니다.");
		}
		else {
			System.out.println("사용자의 은행, 이름, 계좌, 비밀번호를 확인해주세요.");
		}
			
		return result;
	}

	@Override
	public boolean login(String bankname, String name, String passwd) {
		// TODO Auto-generated method stub
		boolean result = false;
		if(bankname.equals(member.getBankname())
				&& name.equals(member.getName()) 
				&& passwd.equals(member.getPasswd())) {
			System.out.println(member.getName() + "님 환영합니다.");
			result = true;
			cnt ++;
		}
		else {
			System.out.println("로그인 정보를 다시 확인해주세요.");
		}
		return result;
	}

	@Override
	public boolean deposit(int money) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean logout() {
		boolean result = false;
			System.out.println("로그아웃에 성공하셨습니다.");
			cnt = 0;
			result = true;
		return result;
	}
	public boolean join(String bankname, String name, String account, String passwd) {
		boolean result = false;
//		System.out.println(member.getName() + "님 환영합니다.");
//		Member member = new Member(bankname, name, account, passwd);
		members.add(member);
		return result;

	}
}
