package me.aravind.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.plaf.basic.BasicToolTipUI;
import java.awt.*;
import java.util.Optional;

public class MyMain extends Application {

	public  static  void main(String[] args) {
		launch(args);

	}


	@Override
	public void start(Stage primaryStage) throws Exception {

		FXMLLoader loader = new
				FXMLLoader(getClass().getResource("app_layout.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);

		Scene scene = new Scene(rootNode);

		primaryStage.setScene(scene);
		primaryStage.setTitle("Temperature Converter Tool");
		primaryStage.show();

	}

	private MenuBar createMenu() {
		Menu fileMenu = new Menu("File");
		MenuItem newMenuItem = new MenuItem("New");
		newMenuItem.setOnAction(event -> System.out.println("Hello"));

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

		MenuItem quitMenuItem = new MenuItem("Quit");
		quitMenuItem.setOnAction(event -> {
			Platform.exit();
			System.exit(0);
		});
		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);


		Menu helpMenu = new Menu("Help");
		MenuItem aboutApp = new MenuItem("About");
		aboutApp.setOnAction(event -> aboutApp());
		helpMenu.getItems().addAll(aboutApp);


		//Menu Bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		return menuBar;
	}

	private void aboutApp() {
		Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
		alertDialog.setTitle("About this App");
		alertDialog.setHeaderText("Temperature Converter");
		alertDialog.setContentText("This is a tool that can be used to convert temperatures between Celcius and Farenheit!\n\n\nMade with ❤ by Aravind!");
		ButtonType yesBtn = new ButtonType("yes");
		ButtonType noButton = new ButtonType("no");
		alertDialog.getButtonTypes().setAll(yesBtn,noButton);
		Optional<ButtonType> clickedBtn = alertDialog.showAndWait();
		if(clickedBtn.isPresent() && clickedBtn.get() == yesBtn ){
			System.out.println("yes clicked");
		} else {
			System.out.println("No clicked");
		}

	}
}
