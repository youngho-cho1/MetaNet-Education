package controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserInfoDao;
import servlet.UserInfoDaoImpl;
import test.UserInfo;

public class UserInfoAddController {
	private UserInfoDao userinfoDao;
	public Object[] getDataBinders() {
		// TODO Auto-generated method stub
		return new Object[] {
				"userinfo", test.UserInfo.class
		};
	}
	public UserInfoAddController setUserInfoDao(UserInfoDao userinfoDao) {
		this.userinfoDao = userinfoDao;
		return this;
	}
	public String execute(Map<String, Object> model) throws Exception {
		UserInfo userinfo = (UserInfo) model.get("userinfo");
		
		return null;
		
	}
//	@Override
//	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		try {
//			System.out.println(request.getParameter("id"));
//			System.out.println(request.getParameter("pwd"));
//			if(request.getParameter("id") != null) {
//				
//				// 여기서 중복검사를 함.
//				UserInfoDao userinfoDao = new UserInfoDaoImpl();
//				userinfoDao.insert(new UserInfo()
//				.setId(request.getParameter("id"))
//				.setPwd(request.getParameter("pwd")));
//				response.sendRedirect("ControllerServlet?command=list");
//			}else {
//				response.sendRedirect("Join.jsp");
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
}
