package controller;
import java.util.Map;

import javax.servlet.http.HttpSession;

import component.Component;
import dao.UserInfoDao;
import servlet.DataBinding;
import test.UserInfo;

@Component("/userinfo/delete.do")
public class UserInfoDeleteController implements Controller, DataBinding {
	private UserInfoDao userinfoDao;
	
	public UserInfoDeleteController setUserInfoDao(UserInfoDao userinfoDao) {
		this.userinfoDao = userinfoDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
	
		if(model.get("userinfo") == null) {
			return "/userinfo/list.do";
		}else {
			UserInfo addInfo = (UserInfo) model.get("userinfo");
			
			int result = userinfoDao.delete(addInfo.getId());
			if(result > -1) {
				HttpSession session = (HttpSession) model.get("session");
				session.setAttribute("result", result);
				return "redirect:../userinfo/list.do";
			}else {
				return "Error.jsp";
			}
		}
		
	
	}
	
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
				"userinfo", test.UserInfo.class
		};
	}
	

}
