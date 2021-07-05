package edu.es.eoi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.es.eoi.flixnet.repository.PeliculaRepositoryJPAImpl;

public class MyServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PeliculaRepositoryJPAImpl repo=new PeliculaRepositoryJPAImpl();
		
		resp.getOutputStream().print(repo.find(Integer.valueOf(req.getParameter("id"))).getNombre());
		
	}
	
	

}
