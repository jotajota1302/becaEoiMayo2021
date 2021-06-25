package edu.es.eoi;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class App {

	private static Connection getConection() throws Exception {

		Properties properties = new Properties();
		properties.load(new FileInputStream(new File("src/main/resources/application.properties")));

		return DriverManager.getConnection(
				properties.getProperty("database.url").concat("/").concat(properties.getProperty("database.schema")),
				properties.getProperty("database.user"), properties.getProperty("database.password"));
		
	
		
	}

	public static void main(String[] args) throws Exception{

		try {
			Connection con = getConection();
			PreparedStatement statement = con.prepareStatement("SELECT * FROM ALUMNO");
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {				
				System.out.println(rs.getString("dni"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
