package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.UserInfoDaoImpl;

public class UserInfoDeleteAction implements Action {

   @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
        	System.out.println("delete id: "+request.getParameter("id"));
            new UserInfoDaoImpl().delete(request.getParameter("id"));
            response.sendRedirect("ControllerServlet?command=list");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}