package main.scenes.luancher;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.controller.SplashController;

public class Splash extends Preloader {
    private Stage preloaderStage;
    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        if(info.getType()== StateChangeNotification.Type.BEFORE_START){
            preloaderStage.hide();
        }
    }

    @Override
    public void handleProgressNotification(ProgressNotification info) {

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.preloaderStage=primaryStage;

     
    }

    @Override
    public void init() throws Exception {
    }
}