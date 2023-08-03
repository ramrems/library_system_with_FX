package com.example.librarydemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.Iterator;

public class BookFile implements Instance {
    private static BookFile instance=new BookFile();

    public ObservableList<Book> getKitaplistesi() {
        return kitaplistesi;
    }

    public ObservableList<String> getKitaplistesiDegisken() {
        return kitaplistesiDegisken;
    }


    private ObservableList<Book> kitaplistesi;
    private ObservableList<String> kitaplistesiDegisken;

    public ObservableList<String> kitaplistesiOdunc;
    private BookFile(){

    }
    public static BookFile getInstance(){
        return instance;
    }
    public void getBooks() throws IOException {
        kitaplistesi= FXCollections.observableArrayList();
        kitaplistesiDegisken= FXCollections.observableArrayList();
        kitaplistesiOdunc= FXCollections.observableArrayList();

        BufferedReader oku = new BufferedReader(new FileReader("src/main/resources/com/example/librarydemo/kutuphane.txt"));
        String kutuphane;
        while ((kutuphane=oku.readLine())!=null) {
            String[] kitapOzellikleri  = kutuphane.split("\t");
            String kitap_isim=String.valueOf(kitapOzellikleri[0]);
            String yazar=kitapOzellikleri[1];
            String tur=kitapOzellikleri[2];
            String sayfa= String.valueOf(kitapOzellikleri[3]);
            String yayin=kitapOzellikleri[4];
            Book book= new Book(kitap_isim,yazar,tur,sayfa,yayin);
            kitaplistesi.add(book);
            kitaplistesiDegisken.add(book.getKitap_ismi());
        }
    }
    public void writeBooks() throws IOException {
        try (BufferedWriter yaz = new BufferedWriter(new FileWriter("src/main/resources/com/example/librarydemo/kutuphaneDegisken.txt"))) {
            Iterator<String> iterator = kitaplistesiDegisken.iterator();
            while (iterator.hasNext()) {
                String kitap = iterator.next();
                yaz.write(String.format("%s\t", kitap));
                yaz.newLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        };
    }
    public void oduncAl(String kitap) throws IOException {
        kitaplistesiOdunc.add(kitap);
        kitaplistesiDegisken.remove(kitap);
        writeBooks();

    }
    public void iadeEt(String kitap){
        kitaplistesiDegisken.add(kitap);
        kitaplistesiOdunc.remove(kitap);

    }

}
