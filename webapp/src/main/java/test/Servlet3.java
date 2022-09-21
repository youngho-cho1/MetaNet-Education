package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class Servlet3
 */
@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		ResultSet rs = null;
		List<UserInfo> data = new ArrayList<>();
		Connection conn = null;
		String sql = "select id, pwd from member";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp?autoReconnect=true", "root", "1234");
			PreparedStatement pstmt = null;
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("Servlet4");
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("IDfail");
			RequestDispatcher dispatcher3 = request.getRequestDispatcher("PWDfail");
//			dispatcher.forward(request, response);
			while(rs.next()) {
				UserInfo user = new UserInfo().setId(rs.getString(1)).setPwd(rs.getString(2));
			
				data.add(user);
			}
			Iterator<UserInfo> iterator = data.iterator();
			while(iterator.hasNext()) {
				UserInfo userinfo = iterator.next();
				if(id.equals(userinfo.getId())) {
					if(pwd.equals(userinfo.getPwd())) {
						out.print("로그인에 성공하셧습니다");
						out.print("<html><body>");
						out.print("<li>아이디 :"+ id +"</li>");
						out.print("<li>비밀번호 :"+ pwd +"</li>");
						out.print("</body></html>");
						dispatcher1.forward(request, response);
						return;
						
					} else {
						dispatcher3.forward(request, response);
						return;
					}

				}else {
					dispatcher2.forward(request, response);
					return;
				}
			
			}
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}

}
