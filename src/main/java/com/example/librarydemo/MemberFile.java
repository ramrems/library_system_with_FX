package com.example.librarydemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.Iterator;
import java.util.Objects;
public class MemberFile implements Instance{
    private static MemberFile instance=new MemberFile();
    private ObservableList<Member> uyelistesi;
    public ObservableList<Member> getUyelistesi() {
        return uyelistesi;
    }
    private MemberFile(){

    }
    public static MemberFile getInstance(){
        return instance;
    }
    public void getMembers() throws IOException {
        uyelistesi= FXCollections.observableArrayList();
        BufferedReader read = new BufferedReader(new FileReader("src/main/resources/com/example/librarydemo/UyeListesi.txt"));
        String Uyeler;
        while ((Uyeler=read.readLine())!=null) {
            String[] uyeBilgi  = Uyeler.split("\t");
            String ad=uyeBilgi[0];
            String soyad=uyeBilgi[1];
            String id=String.valueOf(uyeBilgi[2]);
            Member member= new Member(ad,soyad,id);
            uyelistesi.add(member);
        }
    }
    public void writeMembers() {
        try(BufferedWriter write = new BufferedWriter(new FileWriter("src/main/resources/com/example/librarydemo/UyeListesi.txt"))) {
            Iterator<Member> iterator = uyelistesi.iterator();
            while (iterator.hasNext()) {
                Member newMember = iterator.next();
                write.write(String.format("%s\t%s\t%s", newMember.getAd(), newMember.getSoyad(), newMember.getId()));
                write.newLine();
            }
        }
        catch (IOException e) {
                e.printStackTrace();
            };
    }
    public boolean Kontrol(String isim,String soyisim,String id) throws IOException {
        uyelistesi= FXCollections.observableArrayList();
        BufferedReader read = new BufferedReader(new FileReader("src/main/resources/com/example/librarydemo/UyeListesi.txt"));
        String Uyeler;
        int x=0;
        while ((Uyeler=read.readLine())!=null) {
            String[] uyeBilgi  = Uyeler.split("\t");
            String ad=uyeBilgi[0];
            String soyad=uyeBilgi[1];
            String id1 =String.valueOf(uyeBilgi[2]);
            if((Objects.equals(isim, ad)) && (Objects.equals(soyisim, soyad)) && (Objects.equals(id, id1))){
                x=1;
            }

        }
        if (x==1){
            return true;
        }
        else {
            return false;
        }

    }
    public void uyeOl(Member member) {
        uyelistesi.add(member);
        //writeMembers();
    }
}

