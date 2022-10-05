package bankCommand;

import dao.Dao;

public class DbGetGrade {
	public String getGrade(String sessionId) {
		String rs ="";
		int grade=0;
		Dao dao = Dao.getInstance();
		grade = dao.getUserGrade(sessionId);
		
		if(grade ==1) {
			rs="VVIP";
		}else if(grade ==2) {
			rs="VIP";
		}else if(grade ==3) {
			rs="일반회원";
		}else {
			rs="0";
		}
		
		return rs;
	}
}
