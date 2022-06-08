package main.controller;

import io.github.palexdev.materialfx.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import main.logic.Role;
import main.logic.model.Account;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    private double xOffset;
    private double yOffset;
    @FXML
    MFXComboBox cmbrole;
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
        ObservableList<String> roles = FXCollections.observableArrayList(Role.ADMIN.toString(),Role.BOOKKEEPER.toString(),Role.CASHIER.toString());
        cmbrole.setItems(roles);
        setBtn();
        close.setOnMouseClicked((MouseEvent e)->{
          close.getScene().getWindow().hide();
        });
        minimize.setOnMouseClicked((MouseEvent e)->{
            ((Stage) minimize.getScene().getWindow()).setIconified(true);
        });
        txtpass.setAnimated(true);
        txtuser.textProperty().addListener(((observableValue, s, t1) -> setBtn()));
        txtpass.textProperty().addListener(((observableValue, s, t1) -> setBtn()));
        cmbrole.textProperty().addListener(((observableValue, s, t1) -> setBtn()));
        button.setOnMouseClicked(mouseEvent -> {
            switch (cmbrole.getSelectedIndex()){
                case 1:
                    navigate("/main/resources/fxml/bookkeeper.fxml");
                    break;
                case 0:
                    navigate("/main/resources/fxml/admin.fxml");
                    break;
                case 2:
                    navigate("/main/resources/fxml/cashier.fxml");
                    break;
            }
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
    void setBtn (){
        if (txtuser.getText().isEmpty() || txtpass.getText().isEmpty() ||cmbrole.getValue()==null){
            button.setDisable(true);
            return;

        }
        button.setDisable(false);
    }
    void navigate(String fxml){
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        try {
            Parent root = loader.load();
//
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
