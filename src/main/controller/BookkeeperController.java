package main.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import main.logic.model.Account;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
public class BookkeeperController implements Initializable {
    Account account;
    @FXML
     AnchorPane body;
    @FXML
    Pane pdnew;
 @FXML
    Pane pdupd;
 @FXML
    Pane pdacc;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
setScreen("/main/resources/fxml/stockitems.fxml");
setNodeSel(pdnew);
        pdnew.setOnMouseClicked(mouseEvent -> {
            setScreen("/main/resources/fxml/stockitems.fxml");
            setNodeSel(pdnew);
        });
        pdacc.setOnMouseClicked(mouseEvent -> {
            setScreen("/main/resources/fxml/suppliers.fxml");
            setNodeSel(pdacc);
        });
        pdupd.setOnMouseClicked(mouseEvent -> {
            setScreen("/main/resources/fxml/stockitemsupd.fxml");

            setNodeSel(pdupd);
        });
    }

    void clrNodeSel(Pane[] arr) {

        for (Pane pane : arr) {
            pane.setStyle("-fx-background-color: #ccccff");
            ((Label) pane.getChildren().get(0)).setTextFill(Color.valueOf("black"));
        }
    }

    void setNodeSel(Pane pane) {
        Pane[] panes = {pdacc,pdnew,pdupd};
        clrNodeSel(panes);
        pane.setStyle("-fx-background-color:#666666");

        ((Label) pane.getChildren().get(0)).setTextFill(Color.valueOf("white"));
    }

    void setScreen(String fxml) {
        try {
            Node node = FXMLLoader.load(getClass().getResource(fxml));
            body.getChildren().removeAll(body.getChildren());
            body.getChildren().add(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
