package test;

public class LoginEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			login("white", "12345");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static void login(String id, String pwd) 
		throws NotExistIDException,
		WrongPasswordException{
			if(!id.equals("blue") || !pwd.equals("12345")){
				throw new NotExistIDException("정보가 틀립니다.");
			}
			else {
				System.out.println("로그인에 성공하셨습니다.");
			}
			
		}
	}


