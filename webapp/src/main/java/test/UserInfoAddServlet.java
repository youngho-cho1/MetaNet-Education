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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charaset=UTF-8");
		ResultSet rs = null;
		List<User> data = new ArrayList<>();
		Connection conn = DBUtil.getInstance().getConnection();
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSetMetaData rsmd = null;
		String pwd = request.getParameter("pwd");
		String pwdc = request.getParameter("pwdcheck");
		String id = request.getParameter("id");
		PrintWriter out = response.getWriter();
		Iterator<User> iterator = data.iterator();
		try {
			pstmt = conn.prepareStatement("insert into member(id,pwd) values(?,?)");
			pstmt2 = conn.prepareStatement("select id, pwd from member");
			rs = pstmt2.executeQuery();
			rsmd=rs.getMetaData();
			
			while(rs.next()) {
				User user = new User().setId(rs.getString(1)).setPwd(rs.getString(2));
				if(id.equals(user.getId())) {
					out.print("<script type='text/javascript'>");
					out.print("alert('Id overlap !!.')</script>");
					break;
				}else if (!pwd.equals(pwdc)){
					out.print("<script type='text/javascript'>");
					out.print("alert('Check your Pwd !!.')</script>");
					break;
				}
			
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print("id" + id + "pwd" + pwd);
		doGet(request,response);
		}
	
		
	}



