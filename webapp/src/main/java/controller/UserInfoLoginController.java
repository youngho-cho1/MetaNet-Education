package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import component.Component;
import dao.UserInfoDao;
import servlet.DataBinding;
import test.UserInfo;

@Component("/userinfo/login.do")
public class UserInfoLoginController implements Controller, DataBinding {
	private UserInfoDao userinfoDao;
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
				"userinfo", test.UserInfo.class
		};
	}
	public UserInfoLoginController setUserInfoDao(UserInfoDao userinfoDao) {
		this.userinfoDao = userinfoDao;
		return this;
	}
	@SuppressWarnings("unused")
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		
		if(model.get("userinfo") == null){
			return "/Login.jsp";
		}else {
			UserInfo loginInfo = (UserInfo) model.get("userinfo");
			System.out.println("loginInfo" + loginInfo.getId());
			System.out.println("loginInfo" + loginInfo.getPwd());
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
