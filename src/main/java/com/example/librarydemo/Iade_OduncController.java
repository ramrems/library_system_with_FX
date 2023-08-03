package com.example.librarydemo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Iade_OduncController {
    @FXML
    private Button geri;
    @FXML
    private TextField txtKitap_ismi;

    @FXML
    private Button iade;

    @FXML
    private Button odunc;

    @FXML
    private Label mesaj;
    @FXML
    public void KitapOduncAl() {
            String kitap_ismi = txtKitap_ismi.getText().trim();
            if(BookFile.getInstance().getKitaplistesiDegisken().contains(kitap_ismi)) {
                mesaj.setText(kitap_ismi + " kitabını ödünç aldınız");
                odunc.setOnAction(event1 -> {
                    try {
                        BookFile.getInstance().oduncAl(kitap_ismi);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
           else if (kitap_ismi.isEmpty()) {
            mesaj.setText("Lütfen Boşluğu Doldurunuz");
        }
        else {
            mesaj.setText("Kitap mevcut olmadığı için ödünç alamazsınız ");}
    }
    @FXML
    public void KitapIadeEt() {
        String kitap_ismi = txtKitap_ismi.getText().trim();
        if (BookFile.getInstance().kitaplistesiOdunc.contains(kitap_ismi)) {
            mesaj.setText(kitap_ismi + " kitabını iade ettiniz");
            iade.setOnAction(event1 -> BookFile.getInstance().iadeEt(kitap_ismi));
        }
        else if (kitap_ismi.isEmpty()) {
            mesaj.setText("Lütfen Boşluğu Doldurunuz");
        }
        else {
            mesaj.setText("Kitap sizde olmadığı için iade edemezsiniz ");}
    }
    @FXML
    public void GeriGit() throws IOException {
        geri.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("GirisYap.fxml"));
        Stage stage=new Stage();
        Scene scene = new Scene(root, 600, 390);
        stage.setScene(scene);
        stage.setTitle("Hello!");
        stage.show();}

    }