package aed.examen.controller;

import java.sql.SQLException;

import aed.examen.model.Conexion;
import aed.examen.view.MainView;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class MainController {

	private Conexion conexion;
	private MainView view;
	private Stage app;

	public MainController(Stage primaryStage) {

		view = new MainView();

		app = primaryStage;
		conexion = new Conexion();

		view.getActualizarButton().setOnAction(e -> inicializarConexion(e));

	}

	private void inicializarConexion(ActionEvent e2) {

		view.getActualizarButton().setDisable(false);

		conexion.setRuta(view.getRutaBox().getValue());
		conexion.setHost(view.getHostText().getText());
		conexion.setPuerto(Integer.parseInt(view.getPuertoText().getText()));
		conexion.setDb(view.getDbText().getText());
		conexion.setUser(view.getUserText().getText());
		conexion.setPassword(view.getPasswordField().getText());

		conexion.conectar();

		try {

			switch (conexion.isConnected()) {
			case 1:
				app.setTitle("Conectado a: MySQL");
				break;
			case 2:
				app.setTitle("Conectado a: ACCESS");
				break;
			case 3:
				app.setTitle("Conectado a: SQL Server");
				break;
			case 0:
				Alert errorConnect = new Alert(AlertType.ERROR);
				errorConnect.setHeaderText(null);
				errorConnect.setContentText("Error al conectar con la base de datos: " + view.getDbText().getText());
				errorConnect.show();
				app.setTitle("-------");
				break;
			}

		} catch (NumberFormatException | NullPointerException e) {
			e.printStackTrace();
			Alert errorFormat = new Alert(AlertType.ERROR);
			errorFormat.setTitle("Conexión SQL");
			errorFormat.setHeaderText("Error al conectar");
			errorFormat.setContentText("Complete los campos correctamente.");
			errorFormat.show();
			app.setTitle("-------");
			try {
				conexion.getConexion().close();
			} catch (SQLException err) {
				System.out.println("HEREE");
			}
		}
	}

	public MainView getView() {
		return view;
	}

	public Conexion getConexion() {
		return conexion;
	}
}
