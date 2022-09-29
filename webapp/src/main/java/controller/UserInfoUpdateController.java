package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.UserInfoDao;
import servlet.DataBinding;
import servlet.UserInfoDaoImpl;
import test.UserInfo;

public class UserInfoUpdateController implements Controller, DataBinding {
	private UserInfoDao userinfoDao;
	public Object setUserInfoDao(UserInfoDaoImpl userinfoDao) {
		this.userinfoDao = userinfoDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		if(model.get("userinfo") == null) {
			return "/userinfo/list.do";
		}else {
			UserInfo addInfo = (UserInfo)model.get("userinfo");
			System.out.println("addInfo.getId: " + addInfo.getId());
			System.out.println("addInfo.getPwd: " + addInfo.getPwd());
			int result = userinfoDao.update(addInfo);
			System.out.println("result" + result);
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
