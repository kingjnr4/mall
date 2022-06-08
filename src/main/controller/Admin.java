package main.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Admin implements Initializable {
    @FXML
    Pane pdsup;
    @FXML
    Pane pdstat;
    @FXML
    Pane pdemp;
    @FXML
    AnchorPane body;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setScreen("/main/resources/fxml/admin_emp.fxml");
        setNodeSel(pdemp);
        pdemp.setOnMouseClicked(mouseEvent -> {
            setScreen("/main/resources/fxml/admin_emp.fxml");
            setNodeSel(pdemp);
        });
        pdsup.setOnMouseClicked(mouseEvent -> {
            setScreen("/main/resources/fxml/suppliers.fxml");
            setNodeSel(pdsup);
        });
        pdstat.setOnMouseClicked(mouseEvent -> {
            setScreen("/main/resources/fxml/statistics.fxml");

            setNodeSel(pdstat);
        });
        }

    void clrNodeSel(Pane[] arr) {

        for (Pane pane : arr) {
            pane.setStyle("-fx-background-color: #ccccff");
            ((Label) pane.getChildren().get(0)).setTextFill(Color.valueOf("black"));
        }
    }

    void setNodeSel(Pane pane) {
        Pane[] panes = {pdemp,pdstat,pdsup};
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


