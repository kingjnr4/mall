 package main.scenes.luancher;

 import javafx.application.Application;
 import javafx.application.Preloader;
 import javafx.fxml.FXMLLoader;
 import javafx.scene.Parent;
 import javafx.scene.Scene;
 import javafx.scene.paint.Color;
 import javafx.stage.Stage;
 import javafx.stage.StageStyle;
 import main.controller.SplashController;

 public class Launcher extends Application {


     @Override
     public void start(Stage primaryStage) throws Exception {

         Parent root = FXMLLoader.load(this.getClass().getResource("/main/resources/fxml/splash.fxml"));
         Scene scene = new Scene(root);
         primaryStage.initStyle(StageStyle.TRANSPARENT);
         primaryStage.setScene(scene);
         primaryStage.setResizable(false);
         scene.setFill(Color.TRANSPARENT);
         primaryStage.show();
     }

     public static void main(String[] args) {
         launch(args);
     }
 }
