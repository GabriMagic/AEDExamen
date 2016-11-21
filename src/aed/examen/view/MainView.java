package aed.examen.view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;

public class MainView extends BorderPane {
	private ToolBar toolBar;
	private Button actualizarButton;
	private TextField hostText, puertoText, dbText, userText;
	private PasswordField passwordField;
	private ComboBox<String> rutaBox;
	private ArrayList<String> optionList;

	public MainView() {
		toolBar = new ToolBar();
		optionList = new ArrayList<>();
		optionList.add("jdbc:mysql:");
		optionList.add("jdbc:ucanaccess:");
		actualizarButton = new Button("Actualizar");
		actualizarButton.setDefaultButton(true);
		actualizarButton.setDisable(true);
		rutaBox = new ComboBox<>();
		rutaBox.setItems(FXCollections.observableArrayList(optionList));
		rutaBox.getSelectionModel().select(0);
		hostText = new TextField("localhost");
		hostText.setPromptText("Host...");
		puertoText = new TextField("3306");
		puertoText.setPromptText("Puerto...");
		userText = new TextField("root");
		userText.setPromptText("Usuario...");
		dbText = new TextField("bdbiblioteca");
		dbText.setPromptText("Base de datos...");
		passwordField = new PasswordField();
		passwordField.setPromptText("Contraseña...");
		toolBar.getItems().addAll(rutaBox, hostText, puertoText, dbText, userText, passwordField, actualizarButton);
		setTop(toolBar);
	}

	public ToolBar getToolBar() {
		return toolBar;
	}

	public TextField getHostText() {
		return hostText;
	}

	public Button getActualizarButton() {
		return actualizarButton;
	}

	public TextField getPuertoText() {
		return puertoText;
	}

	public TextField getDbText() {
		return dbText;
	}

	public TextField getUserText() {
		return userText;
	}

	public PasswordField getPasswordField() {
		return passwordField;
	}

	public ComboBox<String> getRutaBox() {
		return rutaBox;
	}

	public ArrayList<String> getOptionList() {
		return optionList;
	}

}
