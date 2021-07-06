package edu.es.eoi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.es.eoi.entities.Cliente;
import com.es.eoi.entities.Cuenta;
import com.es.eoi.repositories.ClienteRepositoryJPAImpl;

public class MyServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String dni = req.getParameter("dni");
		String nombre = req.getParameter("nombre");

		ClienteRepositoryJPAImpl repository = new ClienteRepositoryJPAImpl();

		Cliente c = repository.findCliente(dni);

		if (c != null) {
			if (nombre.equals(c.getNombre())) {

				for (Cuenta cuenta : c.getCuentas()) {
					resp.getOutputStream().print(cuenta.getSaldo());
				}

			}
		}

	}

}
