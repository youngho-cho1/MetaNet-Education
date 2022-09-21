package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserInfoDao;


/**
 * Servlet implementation class UserinfoListServlet
 */
@WebServlet("/UserinfoListServlet")
public class UserinfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserinfoListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charaset=UTF-8");
//		response.sendRedirect("/UserInfoList.jsp");
		/* model 2 pattern : DAO */
		try {
			UserInfoDao userinfoDao = new UserInfoDaoImpl();
			List<UserInfo> userinfos = userinfoDao.selectList();
			request.setAttribute("userinfos", userinfos);
			RequestDispatcher rd = request.getRequestDispatcher("view/UserInfoList.jsp");
			rd.forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

}
}
