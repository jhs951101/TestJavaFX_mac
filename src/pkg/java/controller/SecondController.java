package pkg.java.controller;

import pkg.Main;
import pkg.java.enums.SceneName;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
 
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
 
public class SecondController implements Initializable {
	
    @FXML
    private Button btnStop;
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
 
        btnStop.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Main.changeScene(SceneName.firstScene);
            }
        });
    }
}