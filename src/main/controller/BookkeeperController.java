package main.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import main.logic.model.Account;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class BookkeeperController implements Initializable {
    Account account;
    @FXML
    public AnchorPane body;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
setScreen();
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    void setScreen(){
        try {
            Node  node = FXMLLoader.load(getClass().getResource("/main/resources/fxml/stockitems.fxml"));
            body.getChildren().add(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
