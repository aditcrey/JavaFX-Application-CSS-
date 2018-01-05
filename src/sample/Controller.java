package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label label;


    public void initialize(){
        label.setScaleX(2.0);
        label.setScaleY(2.0);
    }
}
