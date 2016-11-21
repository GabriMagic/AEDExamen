import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import aed.examen.model.Conexion;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Conexion con = new Conexion();

		con.setRuta("jdbc:mysql:");
		con.setHost("");
		con.setDb("bdbiblioteca");
		con.setPuerto(3306);
		con.setUser("root");
		con.setPassword("");

		con.conectar();

		try {
			PreparedStatement query = con.getConexion().prepareStatement("select * from autores");
			ResultSet res = query.executeQuery();
			
			System.out.println("Codigo  |Nombre");
			while (res.next()) {
				System.out.println(res.getString("codAutor")+"     |"+res.getString("nombreAutor"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
