package aed.examen.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private Connection conexion;

	private String ruta, host, db, user, password, link;
	private int puerto;
	private int connected;

	public Conexion() {

	}

	public int conectar() {

		switch (ruta) {
		case "jdbc:mysql:":
			try {
				Class.forName("com.mysql.jdbc.Driver");
				link = ruta + "//" + host + ":" + puerto + "/" + db;
				this.conexion = DriverManager.getConnection(link, user, password);
				System.out.println("Conexión estbalecida conrrectamente con MYSQL");
				connected = 1;
			} catch (SQLException | ClassNotFoundException e) {
				System.out.println("Error al conectar");
				connected = 0;
			}
			break;
		case "jdbc:ucanaccess:":
			try {
				Class.forName("org.hsqldb.jdbcDriver");
				this.conexion = DriverManager.getConnection(ruta + "//" + host);
				System.out.println("Conexión estbalecida conrrectamente con ACCESS");
				connected = 2;
			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				System.out.println("Error al conectar");
				connected = 0;
			}
			break;
		}
		return connected;
	}

	public Connection getConexion() {
		return conexion;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public int isConnected() {
		return connected;
	}

	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

}
