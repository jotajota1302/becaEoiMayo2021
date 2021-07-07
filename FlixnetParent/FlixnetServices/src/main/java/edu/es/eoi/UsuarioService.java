package edu.es.eoi;

import edu.es.eoi.flixnet.repository.UsuarioRepositoryJPAImpl;

public class UsuarioService {
	
	UsuarioRepositoryJPAImpl repository= new UsuarioRepositoryJPAImpl();
	
	public boolean login(String user, String password) {
		
			if(this.repository.find(1)!=null) {
					
					return true;
			};
		
			return false;
		}

}
