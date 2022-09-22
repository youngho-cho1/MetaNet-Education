package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.UserInfoDao;
import test.UserInfo;


public class UserInfoLoginController implements Controller {
	private UserInfoDao userinfoDao;
	public UserInfoLoginController setUserInfoDao(UserInfoDao userinfoDao) {
		this.userinfoDao = userinfoDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		
		if(model.get("userinfo") == null){
			return "Login.jsp";
		}else {
			UserInfo loginInfo = (UserInfo) model.get("userinfo");
			UserInfo userinfo = userinfoDao.exist(loginInfo.getId(), loginInfo.getPwd());
			if(userinfo != null) {
				HttpSession session = (HttpSession) model.get("session");
				session.setAttribute("userinfo", userinfo);
				return "redirect:../userinfo/list.do";
			}
			else {
				return "Error.jsp";
			}
		}
	}

}
