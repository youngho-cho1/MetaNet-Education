package test;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserInfoDao;

/**
 * Servlet implementation class UserInfoAddSservlet
 */
@WebServlet("/UserInfoAddServlet")
public class UserInfoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInfoAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charaset=UTF-8");
		RequestDispatcher rd = request.getRequestDispatcher("view/Join.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd1 = request.getRequestDispatcher("UserinfoListServlet");
		RequestDispatcher rd2 = request.getRequestDispatcher("UserInfoAddServlet");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charaset=UTF-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String pwdc = request.getParameter("pwdcheck");
		try {
			UserInfoDao userinfoDao = new UserInfoDaoImpl();
			
			UserInfo userinfo = new UserInfo().setId(id).setPwd(pwd);
			
			int result = userinfoDao.insert(userinfo);
			
			if(result > 0) {
				rd1.include(request, response);
			}else {
				rd2.include(request, response);
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}

		doGet(request,response);
		
		}
	
		
	}



