package controller;

import java.util.List;
import java.util.Map;

import dao.UserInfoDao;
import test.UserInfo;

public class UserInfoDeleteController implements Controller {

	private UserInfoDao userinfodao;
	public UserInfoDeleteController setUserInfoDao(UserInfoDao userinfodao) {
		this.userinfodao = userinfodao;
		return this;
	}
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		// TODO Auto-generated method stub
		List<UserInfo> userInfo = userinfodao.selectList();
		if(userInfo != null) {
			System.out.println("리스트" + userInfo);
//			model.put("UserInfoList", userinfodao.delete())
		}
		return null;
	}

	

}
