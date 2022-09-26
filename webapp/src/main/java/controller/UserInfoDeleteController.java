package controller;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.UserInfoDao;
import test.UserInfo;


public class UserInfoDeleteController implements Controller {
	private UserInfoDao userinfoDao;
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
				"userinfo", test.UserInfo.class
		};
	}
	public UserInfoDeleteController setUserInfoDao(UserInfoDao userinfoDao) {
		this.userinfoDao = userinfoDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
	
		UserInfo userinfo = (UserInfo) model.get("userinfo");
		if(userinfo != null) {
			HttpSession session = (HttpSession) model.get("session");
			session.setAttribute("userInfo", userinfo);
			int result = userinfoDao.delete("id");
			if(result > -1) {
				return "redirect:../UserInfoList.jsp";
			}
			else {
				return "/Error.jsp";
			}
		}
		return "/Error.jsp";
	
	}

	

}
