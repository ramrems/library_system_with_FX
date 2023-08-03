package com.example.librarydemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Optional;
import java.util.ResourceBundle;

//import static jdk.javadoc.internal.doclets.toolkit.util.DocPath.empty;

public class HelloController  {
    @FXML
    private Button giris;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtisim;
    @FXML
    private Label sonuc;

    @FXML
    private TextField txtsoyisim;

    @FXML
    public void onGirisYap(ActionEvent e) throws IOException {
        String isim = txtisim.getText().trim();
        String soyisim = txtsoyisim.getText().trim();
        String id = txtid.getText().trim();

        //System.out.println("Uyeler"+MemberFile.getInstance().getUyelistesi());

       if(MemberFile.getInstance().Kontrol(isim,soyisim,id)) {
           sonuc.setText("Giriş Başarılı");
           giris.getScene().getWindow().hide();
           Parent root = FXMLLoader.load(getClass().getResource("GirisYap.fxml"));
           Stage stage=new Stage();
           Scene scene = new Scene(root, 600, 400);
           stage.setScene(scene);
           stage.setTitle("Hello!");
           stage.show();}
       else if (isim.isEmpty() || soyisim.isEmpty()||id.isEmpty()) {
           sonuc.setText("Lütfen Boşlukları Doldurunuz");

       } else {
           sonuc.setText("Giriş Başarısız");
       }
    }
    @FXML
    public void onUyeOl() throws IOException {

        String isim = txtisim.getText().trim();
        String soyisim = txtsoyisim.getText().trim();
        String id = txtid.getText().trim();

        if(MemberFile.getInstance().Kontrol(isim,soyisim,id)) {
            sonuc.setText("Zaten üyesiniz");
           } else if (isim.isEmpty() || soyisim.isEmpty()||id.isEmpty()) {
            sonuc.setText("Lütfen Boşlukları Doldurunuz");

        } else {
            Member uye=new Member(isim,soyisim,id);
            MemberFile.getInstance().uyeOl(uye);
            MemberFile.getInstance().writeMembers();
            sonuc.setText("Üye oldunuz Giriş yapınız");
        }
    }
}
