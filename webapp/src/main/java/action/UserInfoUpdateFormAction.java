package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserInfoDao;
import servlet.UserInfoDaoImpl;
import test.UserInfo;

public class UserInfoUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			UserInfoDao userinfoDao = new UserInfoDaoImpl();
			UserInfo userinfo = userinfoDao.selectOne(request.getParameter("id"));
			request.setAttribute("userinfo", userinfo);
			RequestDispatcher rd = request.getRequestDispatcher("UserInfoUpdateForm.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
