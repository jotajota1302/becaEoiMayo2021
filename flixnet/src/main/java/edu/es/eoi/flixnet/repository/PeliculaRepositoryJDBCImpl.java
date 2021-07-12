package edu.es.eoi.flixnet.repository;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import edu.es.eoi.flixnet.entities.Actor;
import edu.es.eoi.flixnet.entities.Pelicula;

@Repository
public class PeliculaRepositoryJDBCImpl implements PeliculaRepository {

	private static Logger logger= Logger.getLogger(PeliculaRepositoryJDBCImpl.class);
	
	private Connection connection;

	private Connection getConection() throws Exception {

		if (connection == null) {
			
			logger.debug("accediendo al fichero de properties");
			
			Properties properties = new Properties();
			properties.load(new FileInputStream(new File("src/main/resources/application.properties")));

			return DriverManager.getConnection(
					properties.getProperty("database.url").concat("/")
							.concat(properties.getProperty("database.schema")),
					properties.getProperty("database.user"), properties.getProperty("database.password"));
		} else {
			
			return connection;

		}

	}

	@Override
	public List<Pelicula> buscarPorActor(Actor actor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pelicula> buscarPorGenero(String genero) throws Exception  {

		logger.info("accediendo al metodo buscar por genero");
		
		List<Pelicula> peliculas= new ArrayList<Pelicula>();
		
		Connection con = getConection();
		PreparedStatement statement = con.prepareStatement("SELECT * FROM pelicula p WHERE p.genero=?");
		statement.setString(1, genero);
		
		logger.debug("query:" + statement.toString());
		
		ResultSet rs = statement.executeQuery();		
		
		while (rs.next()) {
			
			Pelicula p= new Pelicula();
			p.setId(rs.getInt("id"));
			p.setNombre(rs.getString("nombre"));
			p.setGenero(rs.getString("genero"));
		
			peliculas.add(p);
		
		}
		
		return peliculas;
	}

	@Override
	public List<Pelicula> buscarPorNombre(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

}
