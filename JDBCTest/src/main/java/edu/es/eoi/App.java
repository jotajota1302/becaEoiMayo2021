package edu.es.eoi;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class App {

	private static Connection getConection() throws Exception {

		Properties properties = new Properties();
		properties.load(new FileInputStream(new File("C://Users/jjimerod/Desktop/application.properties")));

		return DriverManager.getConnection(
				properties.getProperty("database.url").concat("/").concat(properties.getProperty("database.schema")),
				properties.getProperty("database.user"), properties.getProperty("database.password"));

	}

	public static void main(String[] args) throws Exception {

//		String dni="11111111";
		
		Alumno alumno= findAlumno(args[0]);
		
		double media=0.0;
		double acumulada=0.0;
		
		for (Nota nota : alumno.getNotas()) {
			
			 acumulada=acumulada+nota.getCalificacion();
		}
		
		media=Math.round(acumulada/alumno.getNotas().size());
		
		System.out.println("La media del alumno es : " + media);

	}
	
	
	public static Alumno findAlumno(String dni) throws Exception {
		
		Connection con = getConection();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM alumno a JOIN notas n on a.id=n.idalumno WHERE a.dni=?");
		statement.setString(1, dni);
		ResultSet rs = statement.executeQuery();

		Alumno alumno=new Alumno();
		List<Nota> notas= new ArrayList<Nota>();
		alumno.setNotas(notas);
		
		while (rs.next()) {
			
			//componer el arbol de objetos	
			alumno.setDni(rs.getString("dni"));			
			alumno.setNombre(rs.getString("apellidos"));
			Nota nota= new Nota(rs.getDouble("calificacion"),rs.getString("materia"));			
			alumno.getNotas().add(nota);			
		}
		
		
		return alumno;
		
	}

}
