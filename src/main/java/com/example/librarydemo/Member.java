package com.example.librarydemo;

public class Member {
    private String ad;
    private String soyad;
    private String id;

    public Member(String ad, String soyad, String id) {
        this.ad = ad;
        this.soyad = soyad;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Member{" +
                "ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
