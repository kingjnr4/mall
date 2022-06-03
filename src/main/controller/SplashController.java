package main.controller;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.scenes.luancher.Splash;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SplashController implements Initializable {
    @FXML
    public AnchorPane pane;
    @FXML
    public ProgressBar indicator;
    @FXML
    public Label lbl;
    private String[] loaders = {"Checking memory","Loading images","Loading screens","Initialize login ","Complete"};
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        splash();
    }
    public void  splash(){
        Task task = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try{
                    for (int i = 0; i <=10; i++) {

                        indicator.setProgress(i/10f);
                        Thread.sleep(10);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Stage stage = new Stage();
                            Parent root = FXMLLoader.load(getClass().getResource("/main/resources/fxml/login.fxml"));
                            Scene scene = new Scene(root);
                            stage.initStyle(StageStyle.UNDECORATED);
                            stage.setScene(scene);
                            stage.show();

                            pane.getScene().getWindow().hide();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                return null;
            }
        };
        new Thread(task).start();

    }
}
