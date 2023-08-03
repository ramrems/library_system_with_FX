package com.example.librarydemo;

public class Book {
    private String kitap_ismi;
    private String yazar;
    private String yayin;
    private String tur;
    private String sayfa;

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getSayfa() {
        return sayfa;
    }

    public void setSayfa(String sayfa) {
        this.sayfa = sayfa;
    }

    public String getKitap_ismi() {
        return kitap_ismi;
    }

    public Book(String kitap_ismi, String yazar, String tur,String sayfa,String yayin) {
        this.kitap_ismi = kitap_ismi;
        this.yazar = yazar;
        this.tur=tur;
        this.sayfa=sayfa;
        this.yayin = yayin;

    }

    public void setKitap_ismi(String kitap_ismi) {
        this.kitap_ismi = kitap_ismi;
    }

    public String getYazar() {
        return yazar;
    }

    public void setYazar(String yazar) {
        this.yazar = yazar;
    }

    public String getYayin() {
        return yayin;
    }

    @Override
    public String toString() {
        return "" +
                "kitap_ismi='" + kitap_ismi + '\'' +
                ", yazar='" + yazar + '\'' +
                ", tur='" + tur + '\'' +
                ", sayfa='" + sayfa + '\'' +
                ", yayin='" + yayin + '\'' +
                '}';
    }

    public void setYayin(String yayin) {
        this.yayin = yayin;
    }
}
