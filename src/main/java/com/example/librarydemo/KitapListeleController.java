package com.example.librarydemo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class KitapListeleController implements Initializable {
    @FXML
    private Button geriGit;
    @FXML
    private ListView<String> kitaplistesi;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        kitaplistesi.setItems(BookFile.getInstance().getKitaplistesiDegisken());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("kitap_listele.fxml"));

    }
    public void GeriGit() throws IOException {
        geriGit.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("GirisYap.fxml"));
        Stage stage=new Stage();
        Scene scene = new Scene(root, 600, 390);
        stage.setScene(scene);
        stage.setTitle("Hello!");
        stage.show();}

}
