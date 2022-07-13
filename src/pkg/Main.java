package pkg;
	
import pkg.java.enums.SceneName;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	private final static String viewPath = "resource/view/";
	
	private final static String firstView = "FirstView.fxml";
	private final static String secondView = "SecondView.fxml";
	
	private static Map<SceneName, Scene> sceneMap;
	private static Stage currentStage;
	
	private void initialize() {
		try {
			sceneMap = new HashMap<SceneName, Scene>();
			sceneMap.put(SceneName.firstScene, new Scene( FXMLLoader.load(getClass().getResource(viewPath+firstView)) ));
			sceneMap.put(SceneName.secondScene, new Scene( FXMLLoader.load(getClass().getResource(viewPath+secondView)) ));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
    public void start(Stage primaryStage) {
        try {
        	initialize();
        	
        	currentStage = primaryStage;
        	changeScene(SceneName.firstScene);
        	currentStage.setTitle("창제목");
        	currentStage.setResizable(true);
        	currentStage.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public static void main(String[] args) {
        launch(args);
    }
    
    public static Stage getCurrentStage() {
    	return currentStage;
    }
    
    public static void changeScene(SceneName sceneName) {
    	currentStage.setScene(sceneMap.get(sceneName));
    }
}
