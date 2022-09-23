package controller;

import java.util.List;
import java.util.Map;

import dao.UserInfoDao;
import test.UserInfo;


public class UserInfoListController implements Controller {

	private UserInfoDao userinfodao;
	public UserInfoListController setUserInfoDao(UserInfoDao userinfodao) {
		this.userinfodao = userinfodao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {

		List<UserInfo> userInfo = userinfodao.selectList();
		if(userInfo != null) {
			System.out.println("리스트"+userInfo);
			model.put("UserInfoList", 	userinfodao.selectList());
			return "redirect:../ControllerServlet?command=list";
		}else {
			return "error.jsp";
		}
		
	}

	
}
