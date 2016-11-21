package aed.examen.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import aed.examen.model.Conexion;
import aed.examen.view.MainView;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

public class MainController {

	private Conexion conexion;
	private MainView view;
	// private Stage app;

	public MainController(Stage primaryStage) {

		view = new MainView();

		// app = primaryStage;
		conexion = new Conexion();

		view.getConectarButton().setOnAction(e -> inicializarConexion(e));

	}

	private void inicializarConexion(ActionEvent e2) {

		view.getConectarButton().setDisable(false);

		conexion.setRuta(view.getRutaBox().getValue());
		conexion.setHost(view.getHostText().getText());
		conexion.setPuerto(Integer.parseInt(view.getPuertoText().getText()));
		conexion.setDb(view.getDbText().getText());
		conexion.setUser(view.getUserText().getText());
		conexion.setPassword(view.getPasswordField().getText());

		conexion.conectar();

		try {
			PreparedStatement query = conexion.getConexion().prepareStatement("SELECT * FROM libros");
			ResultSet res = query.executeQuery();

			while (res.next()) {
				System.out.println("Código libro: " + res.getInt("codLibro"));
				System.out.println("Nombre libro: " + res.getString(2));
				System.out.println("ISBN: " + res.getString(3));
				System.out.println("Fecha Intro: " + res.getDate(4).toString());
				System.out.println("--------------------");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public MainView getView() {
		return view;
	}

	public Conexion getConexion() {
		return conexion;
	}
}
