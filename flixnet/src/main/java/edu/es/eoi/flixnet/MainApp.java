package edu.es.eoi.flixnet;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.es.eoi.flixnet.config.AppConfig;
import edu.es.eoi.flixnet.view.LoginView;

public class MainApp {
	
	private static Logger logger=Logger.getLogger(MainApp.class);
	
	public static ApplicationContext context;
	
	public static void main(String[] args) {	
					
		context= new AnnotationConfigApplicationContext(AppConfig.class);
		
		logger.info("inicio el metodo main");
		
		LoginView.printLogin();		
		
		logger.info("finalizo el metodo main");
		
		main(args);		
		
	}

	

}
