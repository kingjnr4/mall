package main.controller;

import io.github.palexdev.materialfx.controls.MFXCheckListView;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    Button button;



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
}
