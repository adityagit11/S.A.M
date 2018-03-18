package com.pushmail;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

// Class - 1.1 (Side class for class - 1)
public class InvalidLoginWindow 
{
	private Stage invalidWindow;
	private FXMLLoader loader;
	private AnchorPane rootLayout;
	private Scene scene;
	
	public void openInvalid_Popup() throws IOException
	{
		invalidWindow = new Stage();
		loader = new FXMLLoader();
		loader.setLocation(InvalidLoginWindow.class.getResource("InvalidLoginWindow.fxml"));
		rootLayout = (AnchorPane) loader.load();
		scene = new Scene(rootLayout);
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>(){
			@Override
			public void handle(KeyEvent t){
				KeyCode key = t.getCode();
				if(key == KeyCode.ESCAPE) {
					invalidWindow.close();
				}
			}
		});
		
		invalidWindow.setScene(scene);
		invalidWindow.show();
	}
}
