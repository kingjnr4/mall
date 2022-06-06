package main.controller;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXCheckListView;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.logic.model.Account;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    private double xOffset;
    private double yOffset;
    @FXML
    AnchorPane header;
    @FXML
    MFXTextField txtuser;
    @FXML
    MFXPasswordField txtpass;
    @FXML
    MFXCheckListView checkList;
    @FXML
    ImageView close;
    @FXML
    ImageView minimize;
    @FXML
    MFXButton button;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        close.setOnMouseClicked((MouseEvent e)->{
          close.getScene().getWindow().hide();
        });
        minimize.setOnMouseClicked((MouseEvent e)->{
            ((Stage) minimize.getScene().getWindow()).setIconified(true);
        });
        txtpass.setAnimated(true);
        button.setOnMouseClicked(mouseEvent -> {
            Switch();
        });
        header.setOnMousePressed(event -> {
            xOffset = ((Stage) close.getScene().getWindow()).getX() - event.getScreenX();
            yOffset = ((Stage) close.getScene().getWindow()).getY() - event.getScreenY();
        });
        header.setOnMouseDragged(event -> {
            ((Stage) close.getScene().getWindow()).setX(event.getScreenX() + xOffset);
            ((Stage) close.getScene().getWindow()).setY(event.getScreenY() + yOffset);
        });
    }
    void Switch(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main/resources/fxml/stockitemsupd.fxml.fxml"));
        try {
            Parent root = loader.load();
            BookkeeperController controller = loader.getController();
           // controller.setAccount(new Account().setFullname("Noble abaeze").setUsername("Kingjnr"));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setResizable(false);
            close.getScene().getWindow().hide();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
