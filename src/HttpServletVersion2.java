import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpServletVersion2 extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public HashMap<String, String> getParams(HttpServletRequest request){
		HashMap<String, String> list = new HashMap<String, String>();
		String query = request.getRequestURI();
		String[] params = query.split("/");
		String[] attributes = new String[]{"server", "app", "servlet", "action", "id"};
		for (int i = 0; i < params.length; i++) {
			list.put(attributes[i], params[i]);
		} 
		return list;
	}
	
	public HashMap<String, Object> getFormParameters(HttpServletRequest request){
		Enumeration<String> it = request.getParameterNames();
		HashMap<String, Object> list = new HashMap<String, Object>();
		while ( it.hasMoreElements()  ) { 
			String s = it.nextElement();
			list.put(s, request.getParameter(s));
			
		}
		return list;
	}
	
	public void render(String name, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setAttribute("params", getParams(request));
		getServletConfig()
		.getServletContext()
		.getRequestDispatcher("/index.jsp")
		.forward(request, response);
	}
}
