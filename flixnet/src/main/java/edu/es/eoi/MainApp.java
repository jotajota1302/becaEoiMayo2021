package edu.es.eoi;

import org.apache.log4j.Logger;

import edu.es.eoi.flixnet.view.LoginView;

public class MainApp {
	
	private static Logger logger=Logger.getLogger(MainApp.class);
	
	public static void main(String[] args) {	
					
		logger.info("inicio el metodo main");
		
		LoginView.printLogin();		
		
		logger.info("finalizo el metodo main");
		
		main(args);		
		
	}

	

}
