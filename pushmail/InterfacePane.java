package com.pushmail;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pack.straw.ui.InvalidLoginWindow;

// Class - 1

public class InterfacePane extends Application 
{
	/*
	 * GUI IS built using Java-FX and Scene Builder*/
	private Stage primaryStage;
	private AnchorPane rootLayout;
	private FXMLLoader loader;
	private Scene scene;
	
	private String senderEmail;
	private String senderPassword;
	private String recieverEmail;
	private String emailSubject;
	private String emailContent;
	
	@FXML private TextField SenderEmailField;
	@FXML private TextField SenderPasswordField;
	@FXML private TextField RecieverEmailField;
	@FXML private TextField EmailSubjectField;
	@FXML private TextArea EmailContentField;
	@FXML private Button SendButton;
	
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		this.primaryStage = primaryStage;
		loader = new FXMLLoader();
		loader.setLocation(InterfacePane.class.getResource("InterfacePane.fxml"));
		rootLayout = (AnchorPane)loader.load();
		scene = new Scene(rootLayout);
		
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent t) {
				KeyCode key = t.getCode();
				if(key == KeyCode.ESCAPE) {
					primaryStage.close();
				}
			}
		});
		
		primaryStage.setScene(scene);
		
		// Design for transparent window
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
	}
	
	public void click_SendButton()
	{
		senderEmail = SenderEmailField.getText();
		senderPassword = SenderPasswordField.getText();
		recieverEmail = RecieverEmailField.getText();
		emailSubject = EmailSubjectField.getText();
		emailContent = EmailContentField.getText();
		
		if(authenticate(senderEmail, senderPassword, recieverEmail, emailSubject, emailContent))
		{
			// Authenticated Login
			
			SiteSelect objSiteSelect = new SiteSelect();
			objSiteSelect.run(senderEmail, senderPassword, recieverEmail, emailSubject, emailContent);
			primaryStage = (Stage) SendButton.getScene().getWindow();
			primaryStage.close();
		
		}
		else
		{
			// Un-Authenticated Login
			// Then pop up a window for invalid login credentials
			InvalidLoginWindow loginPop = new InvalidLoginWindow();
			try
			{
				loginPop.openInvalid_Popup();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
		}
	}
	
	private boolean authenticate(String senderEmail, String senderPassword, String recieverEmail, String emailSubject, String emailContent)
	{
		if(senderEmail.length()>0 && 
				senderPassword.length()>0 &&
				recieverEmail.length()>0 &&
				emailSubject.length()>0 &&
				emailContent.length()>0)
			return true;
		return false;
	}

	public static void main(String[] args) 
	{
		launch(args);
	}
}
