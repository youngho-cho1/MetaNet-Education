package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.UserInfo;
import test.UserInfoDaoImpl;

public class UserInfoLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		HttpSession session = request.getSession();
		try {
			UserInfo userinfo = new UserInfoDaoImpl().exist(id,pwd);
			if(userinfo != null) { // 로그인 성공 후 세션 저장
				session.setAttribute("userinfo", userinfo);
				response.sendRedirect("ControllerServlet?command=list");
			}else {
				response.sendRedirect("view/Login.jsp"); // 로그인 실패 시 로그인 페이지로 다시 이동
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}