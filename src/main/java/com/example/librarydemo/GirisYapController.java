package com.example.librarydemo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
public class GirisYapController  {

    @FXML
    private Button iade_odunc;

    @FXML
    private Button kitap;

    @FXML
    public void onAllBooks(ActionEvent event) throws IOException {
        kitap.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("kitap_listele.fxml"));
        Stage stage=new Stage();
        Scene scene = new Scene(root, 750, 500);
        stage.setScene(scene);
        stage.setTitle("Hello!");
        stage.show();}

    @FXML
    public void Iade_Odunc(ActionEvent event) throws IOException {
        iade_odunc.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("iade_odunc.fxml"));
        Stage stage=new Stage();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        stage.setTitle("iade odunc");
        stage.show();}

}
