package naivgationdrawer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NaivgationDrawer extends Application {
	
	/**
	 * @author Nick Stajduhar
	 * @category Utility
	 * Version 2.0 rev4
	 * 
	 * This program is made for the St. Anne High School robotics team "Saints Bot".
	 *
	 * PitControl is the control panel for their pit in the classroom and at district events
	 * 
	 * Copyright 2018 Nick Stajduhar All Rights Reserved
	 */
	
	public static void main(String[] args) {
		Application.launch(args);

	}
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/FXMLDocument.fxml"));
        
        Scene scene = new Scene(root,800,425);
        
        stage.setScene(scene);
        stage.show();
    }


    
    
}
