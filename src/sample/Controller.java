package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

public class Controller {
    @FXML
    private Label label;

    @FXML
    private Button button4;

    @FXML
    private GridPane gridPane;


    public void initialize(){
        button4.setEffect(new DropShadow());

    }

    @FXML
    public void handleMouseEnter(){
        label.setScaleX(2.0);
        label.setScaleY(2.0);
    }

    @FXML
    public void handleMouseExit(){
        label.setScaleX(1.0);
        label.setScaleY(1.0);
    }

    @FXML
    public void handleClick(){

        FileChooser chooser = new FileChooser();
        //we are gonna call the show open dialog method which shows the filechooser in open mode but to do that
        //we need to pass in a parent window for the filechoose...so we need to assign fx:id to our GridPane
//        chooser.showOpenDialog(null); //in this case you'll be able to interact with the application window even though the open dialog is open //not wanted
//        chooser.showOpenDialog(gridPane.getScene().getWindow());


        chooser.setTitle("Save Application File");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Text","*.txt"),
                new FileChooser.ExtensionFilter("PDF","*.pdf"),
                new FileChooser.ExtensionFilter("Images","*.jgp","*.png","*.gif"),
                new FileChooser.ExtensionFilter("All Files","*.*")
        );

//        File file = chooser.showSaveDialog(gridPane.getScene().getWindow());
//        File file = chooser.showOpenDialog(gridPane.getScene().getWindow());

        List<File> file = chooser.showOpenMultipleDialog(gridPane.getScene().getWindow());  //this returns the list of file hence allowing multiple files to be selected
        if(file!=null){
            for(int i=0;i<file.size();i++) {
                System.out.println(file.get(i).getPath());
            }
        }else{
            System.out.println("Chooser was cancelled");
        }



        /*
        //using DirectoryChooser to be able to select a folder(directory)
        DirectoryChooser chooser = new DirectoryChooser();


        File file  = chooser.showDialog(gridPane.getScene().getWindow()); //here we need to use showDialog instead of showOpenDialog  //file collects the return value
        if(file!=null){
            System.out.println(file.getPath());
        }else{
            System.out.println("Chooser was cancelled");
        }

*/












    }

    @FXML
    public void handleLinkClick(){

//        System.out.println("The link was clicked!");


        try{
            Desktop.getDesktop().browse(new URI("https://www.javafx .com"));
        }catch(IOException | URISyntaxException e){
            e.printStackTrace();
        }

    }
}


/**
 link for all the effects in javaFX : https://docs.oracle.com/javase/8/javafx/api/javafx/scene/effect/package-frame.html
 **/


/**
 * we can the open and save feature for our application using file chooser class...but it doesn't descend from the node class
 * and hence can't be added to the scene graph...in other words, we can't add to layouts  ...but there is no need
 * the file chooser ui does it by itself and we don't have to worry about embedding it with the layout
 *
 *
 * if we want to choose a folder(directory) instead of a file then we need to use directoryChooser instead of fileChooser
 *
 **/