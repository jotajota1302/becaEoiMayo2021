package edu.es.eoi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PeliculasServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PeliculasService service= new PeliculasService();
		
		resp.getOutputStream().println(service.findPeliculaById(2).getNombre());
		
		
	}
	
	
	
	

}
