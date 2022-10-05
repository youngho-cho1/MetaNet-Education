package bankCommand;

import dao.Dao;

public class DBLogin {
	public String login(String userId,String userPw) {
		String id ="";
		int rs =0;
		Dao dao = Dao.getInstance();
		
		rs = dao.login(userId,userPw);
		if(rs==1) {
			id=userId;
		}else {
			id="0";
		}
		
		return id;
	}
}
