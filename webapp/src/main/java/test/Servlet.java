package test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet({ "/Servlet", "/test" })
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet() {
        // TODO Auto-generated constructor stub
    	super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charaset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.print("<head>");
		out.print("</head>");
		out.print("<body>");
		out.print("<table border='10'>");
		for(int i = 2; i < 10; i++) {
				out.print("<th>" + i + "dan</th>");
				out.print("<tr>");
			for(int j = 1; j< 10; j++) {
				out.print("<td>");
				out.print(i + "*" + j + "="+i*j);
				out.print("</td>");
			}
			out.print("</tr>");
			
		}
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
