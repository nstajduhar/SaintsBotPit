package naivgationdrawer;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class NaivgationDrawer extends Application {
	
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
