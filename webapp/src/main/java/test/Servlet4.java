package test;

import java.awt.Window;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


/**
 * Servlet implementation class Servlet4
 */
@WebServlet("/Servlet4")
public class Servlet4 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet4() {
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
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		ResultSet rs = null;
		List<UserInfo> data = new ArrayList<>();
		Connection conn = DBUtil.getInstance().getConnection();
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSetMetaData rsmd = null;
		RequestDispatcher dispatcher4 = request.getRequestDispatcher("UserInfoAddServlet");
		RequestDispatcher dispatcher5 = request.getRequestDispatcher("UserinfoListServlet");
		String pwd = request.getParameter("pwd");
		String pwdc = request.getParameter("pwdcheck");
		String id = request.getParameter("id");
		Iterator<UserInfo> iterator = data.iterator();
		try {
			pstmt = conn.prepareStatement("insert into member(id,pwd) values(?,?)");
			pstmt2 = conn.prepareStatement("select id, pwd from member");
			rs = pstmt2.executeQuery();
			rsmd=rs.getMetaData();

			RequestDispatcher dispatcher2 = request.getRequestDispatcher("IDfail");
			RequestDispatcher dispatcher3 = request.getRequestDispatcher("PWDfail");
			PrintWriter out = response.getWriter();
			out.print("<html><body>");
			dispatcher2.include(request, response);
			out.print("<hr>");
			
			out.print("<p>");
			out.print("Welcome Join");
			out.print("<p>");
			out.print("<hr>");
			dispatcher3.include(request, response);
			out.print("</body></html>");
			
			while(rs.next()) {
				UserInfo user = new UserInfo().setId(rs.getString(1)).setPwd(rs.getString(2));
				if(id.equals(user.getId()) || !pwd.equals(pwdc)) {
					dispatcher4.forward(request, response);
					break;
				}else {
					dispatcher5.forward(request, response);
					break;
				}
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}

		
	}

}
