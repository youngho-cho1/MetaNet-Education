package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserInfoDao;
import servlet.UserInfoDaoImpl;
import test.UserInfo;

public class UserInfoUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pwd"));
		try {
			UserInfoDao userinfoDao = new UserInfoDaoImpl();
			userinfoDao.update(new UserInfo()
					.setId(request.getParameter("id"))
					.setPwd(request.getParameter("pwd")));
			
			response.sendRedirect("ControllerServlet?command=list");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
