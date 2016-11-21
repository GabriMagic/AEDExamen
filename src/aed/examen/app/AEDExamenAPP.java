package aed.examen.app;

import aed.examen.controller.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AEDExamenAPP extends Application {

	private MainController mainController;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		mainController = new MainController(primaryStage);
		
		primaryStage.setScene(new Scene(mainController.getView()));
		primaryStage.setTitle("AED Base de Datos - Examen");
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}

}
