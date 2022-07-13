package pkg.java.controller;

import pkg.Main;
import pkg.java.dto.ComboBoxDto;
import pkg.java.enums.SceneName;
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
 
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.scene.control.ComboBox;
import javafx.scene.control.CheckBox;
import javafx.scene.chart.PieChart;

public class FirstController implements Initializable {
	
    @FXML
    private Button btnNextTo;
    
    @FXML
    private Button btnFile;
 
    @FXML
    private ComboBox<ComboBoxDto> cbList;
    
    @FXML
    private CheckBox ckbMale;
    
    @FXML
    private CheckBox ckbFemale;
    
    @FXML
    private PieChart pcChart;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
 
    	btnNextTo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	Main.changeScene(SceneName.secondScene);
            }
        });
    	
    	btnFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	FileChooser fileChooser = new FileChooser();
            	File file = fileChooser.showOpenDialog(Main.getCurrentStage());
        		
        		if (file != null) {
        			System.out.println(file.getAbsolutePath());
        		}
            }
        });
    	
    	ObservableList<ComboBoxDto> list = FXCollections.observableArrayList();
    	list.add(new ComboBoxDto("1", "One"));
    	list.add(new ComboBoxDto("2", "Two"));
    	list.add(new ComboBoxDto("3", "Three"));
    	cbList.setItems(list);
    	cbList.getSelectionModel().selectFirst();
    	
    	ckbMale.setSelected(false);
    	ckbMale.setSelected(true);
    	
    	ObservableList<PieChart.Data> pcData = FXCollections.observableArrayList();
    	pcData.add(new PieChart.Data("Grapefruit", 30));
    	pcData.add(new PieChart.Data("Oranges", 35));
    	pcData.add(new PieChart.Data("Plums", 35));
        pcChart.setData(pcData);
        pcChart.setTitle("Imported Fruits");
    }
}