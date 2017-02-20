package com.example.szupek.datepickerszupek.model;

/**
 * Created by szupek on 2016-12-29.
 */

public class Wesele {

    private String data;
    private String miejscowosc;
    private String lokal;
    private String imie;
    private String nazwisko;
    private String uklon;
    private String godzinaUklonu;
    private String cena;
    private String wyjazd;
    private String tel_Mlody;
    private String tel_Mloda;
    private String notatki;

    public Wesele(){

    }

    public Wesele(String data,
            String miejscowosc,
            String lokal,
            String imie,
            String nazwisko,
            String uklon,
            String godzinaUklonu,
            String cena,
            String wyjazd,
            String tel_Mlody,
            String tel_Mloda,
            String notatki){

        this.data=data;
        this.miejscowosc=miejscowosc;
        this.lokal=lokal;
        this.imie=imie;
        this.nazwisko=nazwisko;
        this.uklon=uklon;
        this.godzinaUklonu=godzinaUklonu;
        this.cena=cena;
        this.wyjazd=wyjazd;
        this.tel_Mlody=tel_Mlody;
        this.tel_Mloda=tel_Mloda;
        this.notatki=notatki;
    }

    public String getData() {  return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public String getLokal() {
        return lokal;
    }

    public void setLokal(String lokal) {
        this.lokal = lokal;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getUklon() {
        return uklon;
    }

    public void setUklon(String uklon) {
        this.uklon = uklon;
    }

    public String getGodzinaUklonu() {
        return godzinaUklonu;
    }

    public void setGodzinaUklonu(String godzinaUklonu) {
        this.godzinaUklonu = godzinaUklonu;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public String getWyjazd() {
        return wyjazd;
    }

    public void setWyjazd(String wyjazd) {
        this.wyjazd = wyjazd;
    }

    public String getTel_Mlody() {
        return tel_Mlody;
    }

    public void setTel_Mlody(String tel_Mlody) {
        this.tel_Mlody = tel_Mlody;
    }

    public String getTel_Mloda() {
        return tel_Mloda;
    }

    public void setTel_Mloda(String tel_Mloda) {
        this.tel_Mloda = tel_Mloda;
    }

    public String getNotatki() {
        return notatki;
    }

    public void setNotatki(String notatki) {
        this.notatki = notatki;
    }
}

