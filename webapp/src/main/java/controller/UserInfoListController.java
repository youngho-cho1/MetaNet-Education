package controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import dao.UserInfoDao;
import test.UserInfo;


public class UserInfoListController implements Controller {

	private UserInfoDao userinfoDao;
	@Override
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
				"userinfo", test.UserInfo.class
		};
	}
	public UserInfoListController setUserInfoDao(UserInfoDao userinfoDao) {
		this.userinfoDao = userinfoDao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		List<UserInfo> userInfo = userinfoDao.selectList();
		if(userInfo != null) {
			HttpSession session = (HttpSession) model.get("session");
			session.setAttribute("userInfo", userInfo);
			return "redirect:../UserInfoList.jsp";
		}else {
			return "/Error.jsp";
		}
//		if(userInfo != null) {
//			UserInfoDao userinfodao = (UserInfoDao)model.get("userinfodao");
//			model.put("userInfo", userinfodao.selectList());
//			return "redirect:../UserInfoList.jsp";
//		}else {
//			return "error.jsp";
//		}
		
	}
}
