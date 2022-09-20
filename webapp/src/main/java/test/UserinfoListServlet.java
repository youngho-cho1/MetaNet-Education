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
		PrintWriter out = response.getWriter();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		RequestDispatcher rd3 = request.getRequestDispatcher("view/UserInfoList.jsp");
		Connection conn = DBUtil.getInstance().getConnection();
		List<User> data = new ArrayList<>();
		
		try {	
			pstmt = conn.prepareStatement("SELECT id, pwd FROM MEMBER");
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			while(rs.next()) {
				User user = new User().setId(rs.getString(1)).setPwd(rs.getString(2));
				data.add(user);				
			}
			request.setAttribute("data", data);
			rd3.forward(request, response);
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null)pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {}
		}

//		response.sendRedirect("/UserInfoList.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

}
}
