package edu.es.eoi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	static ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

	public static void main(String[] args) {
		
		Usuario user1 = context.getBean(Usuario.class);
		Usuario user2 = context.getBean(Usuario.class);	
				
		System.out.println("Nombre: " + user1.getNombre());
		System.out.println("Nombre: " + user2.getNombre());		

	}

}
