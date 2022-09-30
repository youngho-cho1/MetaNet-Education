package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import component.Component;
import dao.UserInfoDao;
import servlet.DataBinding;
import test.UserInfo;
@Component("/userinfo/add.do")
public class UserInfoAddController implements Controller, DataBinding {
	private UserInfoDao userinfoDao;
	
	public UserInfoAddController setUserInfoDao(UserInfoDao userinfoDao) {
		this.userinfoDao = userinfoDao;
		return this;
	}
	public String execute(Map<String, Object> model) throws Exception {
		
		if(model.get("userinfo") == null) {
			return "Join.jsp";
		}else {
			
			UserInfo addInfo = (UserInfo) model.get("userinfo");
			int result = userinfoDao.insert(addInfo);
			if(result > -1) {
				HttpSession session = (HttpSession) model.get("session");
				session.setAttribute("result", result);
				return "redirect:../userinfo/list.do";
			}else {
				return "error.jsp";
			}
		}
		
	}
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
				"userinfo", test.UserInfo.class
		};
	}

}
