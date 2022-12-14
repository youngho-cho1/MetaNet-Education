//package servlet;
//import java.io.IOException;
//import java.util.HashMap;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import context.ApplicationContext;
//import controller.Controller;
//import listener.ContextLoaderListener;
//import util.ServletRequestDataBinder;
//
//@SuppressWarnings("serial")
//@WebServlet("*.do")
//public class DispatcherServlet extends HttpServlet{
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp)
//	throws ServletException, IOException{
//		super.service(req, resp);
//		resp.setContentType("text/html, charset=UTF-8");
//		String servletPath = req.getServletPath();
//		try {
//
//			ApplicationContext ctx = ContextLoaderListener.getApplicationContext();
//			HashMap<String, Object> model = new HashMap<String, Object>();
//			model.put("session", req.getSession());
//			
//			Controller controller = (Controller) ctx.getBean(servletPath);
//			
//			if(controller == null) {
//				throw new Exception("요청한 서비스를 찾을 수 없습니다.");
//			}
//			if(controller instanceof DataBinding) {
//				prepareRequestData(req, model, (DataBinding)controller);
//			}
//			String viewUrl = controller.execute(model);
//			System.out.println("viewurl" + viewUrl);
//			for(String key: model.keySet()) {
//				req.setAttribute(key, model.get(key));
//			}
//			if(viewUrl.startsWith("redirect:")) {
//				resp.sendRedirect(viewUrl.substring(9));
//				return;
//			}else {
//				System.out.println("viewurl: " + viewUrl);
//				RequestDispatcher rd = req.getRequestDispatcher(viewUrl);
//				rd.include(req, resp);
//			}
//
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
//	private void prepareRequestData(HttpServletRequest request, HashMap<String, Object> model, DataBinding dataBinding)throws Exception {
//		// TODO Auto-generated method stub
//		Object[] dataBinders = dataBinding.getDataBinders();
//		String dataName = null;
//		Class<?> dataType = null;
//		Object dataObj = null;
//		for( int i = 0; i < dataBinders.length; i+=2) {
//			dataName = (String) dataBinders[i];
//			dataType = (Class<?>) dataBinders[i+1];
//			dataObj = ServletRequestDataBinder.bind(request, dataType, dataName);
//			model.put(dataName, dataObj);
//		}
//	}
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//	}
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//}
