package edu.es.eoi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UsuarioService service= new UsuarioService();
		
		boolean permitido = service.login(req.getParameter("user"),req.getParameter("password"));					
		
		if(permitido) {
			resp.sendRedirect("http://localhost:8090/FlixnetJSP/menu.jsp");			
			//pasale el nombre del usuario
		}else {			
			resp.sendRedirect("http://localhost:8090/FlixnetJSP/login.jsp");
		}		
		
	}
	
	
	
	
}
