package aed.examen.view;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class MainView extends BorderPane {
	private VBox toolBar;
	private Button conectarButton;
	private TextField hostText, puertoText, dbText, userText;
	private PasswordField passwordField;
	private ComboBox<String> rutaBox;
	private ArrayList<String> optionList;

	public MainView() {
		optionList = new ArrayList<>();
		optionList.add("jdbc:mysql:");
		optionList.add("jdbc:ucanaccess:");
		conectarButton = new Button("Conectar");
		conectarButton.setDefaultButton(true);
		rutaBox = new ComboBox<>();
		rutaBox.setMaxWidth(Double.MAX_VALUE);
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
		toolBar = new VBox(5, rutaBox, hostText, puertoText, dbText, userText, passwordField, conectarButton);
		setTop(toolBar);
		setPadding(new Insets(10));		
	}

	public VBox getToolBar() {
		return toolBar;
	}

	public TextField getHostText() {
		return hostText;
	}

	public Button getConectarButton() {
		return conectarButton;
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
