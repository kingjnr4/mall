package main.controller;

import io.github.palexdev.materialfx.controls.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.ResourceBundle;

public class StockitemsController implements Initializable {
    @FXML
    MFXButton btnSel;
    @FXML
    MFXTableView sTable;
    @FXML
    MFXComboBox combo;
    @FXML
    MFXTextField txtSpl;
    @FXML
    MFXTextField txtPname;
    @FXML
    MFXTextField txtQty;
    @FXML
    MFXTextField txtRprice;
    @FXML
    MFXTextField txtCprice;
    @FXML
    ImageView imgbar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtQty.onActionProperty();
    }
    private  void setImage(BufferedImage img,ImageView view){
        Image image = SwingFXUtils.toFXImage(img,null);
        view.setImage(image);
    }
}
