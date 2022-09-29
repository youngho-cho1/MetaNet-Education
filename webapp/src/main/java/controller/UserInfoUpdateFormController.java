package controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.UserInfoDao;
import servlet.DataBinding;
import servlet.UserInfoDaoImpl;
import test.UserInfo;

public class UserInfoUpdateFormController implements Controller, DataBinding {
	private UserInfoDao userinfoDao;
	public Object setUserInfoDao(UserInfoDaoImpl userinfoDao) {
		// TODO Auto-generated method stub
		this.userinfoDao = userinfoDao;
		return this;
	}

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		if(model.get("userinfo")==null) {
			return "userInfoUpdateForm.jsp";
		}else {
			UserInfo addInfo = (UserInfo) model.get("userinfo");
			System.out.println("model.get: "+model.get("userinfo"));
			
			UserInfo userinfo = userinfoDao.selectOne(addInfo.getId());
			HttpSession session = (HttpSession)model.get("session");
			session.setAttribute("userinfo", userinfo);
			
			return "redirect:/webapp/UserInfoUpdateForm.jsp";
			
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
