package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserInfoDao;
import test.UserInfo;
import test.UserInfoDaoImpl;

public class UserInfoListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			UserInfoDao userinfoDao = new UserInfoDaoImpl();
			List<UserInfo> userinfos = userinfoDao.selectList();
			request.setAttribute("userinfos", userinfos);
			response.sendRedirect("UserinfoListServlet");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
