package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionServFumaca {
	
	  	public String driver = "com.mysql.jdbc.Driver";
	    public String hostname = "192.168.10.7";
	    public String port = "3306";
	    public String username = "bdtafu";
	    public String password = "tafuMySQL1965";
	    
	    public static Connection conn = null;
	    
	    
	    public  ConexionServFumaca() {
	    }
	    
	    public Connection conectarEtiquetas() {
	    	String database = "Etiquetas";
	    	String url;
	    	url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
	    	
	    	try {
	    		Class.forName(driver);
	    		conn = DriverManager.getConnection(url, username, password);
	        } catch (ClassNotFoundException | SQLException e) {
	        	e.printStackTrace();
	        }

			return conn;
	    }
	    public Connection conectarCiudades() {
	    	String database = "Ciudades";
	    	String url;
	    	url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
	    	
	    	try {
	    		Class.forName(driver);
	    		conn = DriverManager.getConnection(url, username, password);
	        } catch (ClassNotFoundException | SQLException e) {
	        	e.printStackTrace();
	        }

			return conn;
	    }
	    public static void cerrar() throws SQLException {
	    	if (conn != null) {
	    		conn.close();
	    	}
	   }
} // Fin Clase ConexionServFumaca