package edu.es.eoi.flixnet.repository;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.apache.log4j.Logger;

import edu.es.eoi.flixnet.entities.Usuario;

public class UsuarioRepositoryJDBCImpl implements UsuarioRepository {

	private static Logger logger = Logger.getLogger(UsuarioRepositoryJDBCImpl.class);

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
	public boolean comprueba(Usuario usuario) throws Exception {

		logger.info("accediendo al metodo comprobar usuario");

		Connection con = getConection();
		PreparedStatement statement = con
				.prepareStatement("SELECT * FROM beca.usuario u WHERE u.usuario=? AND u.password=?");
		statement.setString(1, usuario.getUsuario());
		statement.setString(2, usuario.getPassword());

		logger.debug("query:" + statement.toString());

		ResultSet rs = statement.executeQuery();

		return true;

	}

	@Override
	public void alta(Usuario usuario) {
		// TODO Auto-generated method stub

	}

}
