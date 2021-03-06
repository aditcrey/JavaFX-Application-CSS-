package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        setUserAgentStylesheet(STYLESHEET_CASPIAN);  //changing the application theme //default it "MODENA"
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}


/**
 * JavaFX allows to transform nodes in the scene graph i.e. we can animate them, zoom in on them, etc.
 */
