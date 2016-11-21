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

	
	}

}
