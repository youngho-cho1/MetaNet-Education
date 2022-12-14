package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserInfoDao;
import servlet.UserInfoDaoImpl;
import test.UserInfo;

public class UserInfoAddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			System.out.println(request.getParameter("id"));
			System.out.println(request.getParameter("pwd"));
			if(request.getParameter("id") != null) {
				
				// 여기서 중복검사를 함.
				UserInfoDao userinfoDao = new UserInfoDaoImpl();
				userinfoDao.insert(new UserInfo()
				.setId(request.getParameter("id"))
				.setPwd(request.getParameter("pwd")));
				response.sendRedirect("ControllerServlet?command=list");
			}else {
				response.sendRedirect("Join.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
