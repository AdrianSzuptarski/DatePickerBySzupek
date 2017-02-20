package com.example.szupek.datepickerszupek;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.szupek.datepickerszupek.model.Wesele;

/**
 * Created by szupek on 2016-12-29.
 */

public class DAO {

    public static final String table_name = "Umowy";
    private DBManager dbManager;

    public DAO(DBManager dbManager) {
        this.dbManager = dbManager;
    }


    public boolean Dodaj_Wesele(Wesele wesele) {

        ContentValues wartosc = new ContentValues();
        wartosc.put("Data", wesele.getData());
        wartosc.put("Miejscowosc", wesele.getMiejscowosc());
        wartosc.put("Lokal", wesele.getLokal());
        wartosc.put("Imie", wesele.getImie());
        wartosc.put("Nazwisko", wesele.getNazwisko());
        wartosc.put("Miejsce_Uklonu", wesele.getUklon());
        wartosc.put("Godzina_Uklonu", wesele.getGodzinaUklonu());
        wartosc.put("Cena", wesele.getCena());
        wartosc.put("Wyjazd", wesele.getWyjazd());
        wartosc.put("Tel_Mlody", wesele.getTel_Mlody());
        wartosc.put("Tel_Mloda", wesele.getTel_Mloda());
        wartosc.put("Notatki", wesele.getNotatki());

        SQLiteDatabase db = dbManager.getWritableDatabase();
        long result = db.insertOrThrow("Umowy", null, wartosc);
        if (result == -1)
            return false;
        else
            return true;

    }

    public void AnulujUmowe(String data){
        SQLiteDatabase db = dbManager.getWritableDatabase();
        String[] argument={""+data};
        db.delete(table_name,"Data=?",argument);

    }

    public boolean sprawdz(String data){
        String aktualnaData = data;
        String dataPobrana ="";
        SQLiteDatabase db = dbManager.getReadableDatabase();
        String[] kolumny = {"Data"};
        String filtr[] = {data + ""};
        Cursor kursor1 = db.query(table_name, kolumny, "Data=?", filtr, null, null, null, null);
        while (kursor1.moveToNext()) {
            dataPobrana = (kursor1.getString(0));
        }
        if (aktualnaData.equals(dataPobrana)){
       return true;
        }else{
            return false;
        }

    }


    public Wesele pokazJednaUmowe(String data) {
        Wesele kontakt = new Wesele();
        SQLiteDatabase db = dbManager.getReadableDatabase();
        String[] kolumny = {"Data", "Miejscowosc", "Lokal", "Imie", "Nazwisko", "Miejsce_Uklonu",
                "Godzina_Uklonu", "Cena", "Wyjazd", "Tel_Mlody", "Tel_Mloda", "Notatki"};
        String filtr[] = {data + ""};
        Cursor kursor1 = db.query(table_name, kolumny, "Data=?", filtr, null, null, null, null);

        while (kursor1.moveToNext()) {
            kontakt.setData(kursor1.getString(0));
            kontakt.setMiejscowosc(kursor1.getString(1));
            kontakt.setLokal(kursor1.getString(2));
            kontakt.setImie(kursor1.getString(3));
            kontakt.setNazwisko(kursor1.getString(4));
            kontakt.setUklon(kursor1.getString(5));
            kontakt.setGodzinaUklonu(kursor1.getString(6));
            kontakt.setCena(kursor1.getString(7));
            kontakt.setWyjazd(kursor1.getString(8));
            kontakt.setTel_Mlody(kursor1.getString(9));
            kontakt.setTel_Mloda(kursor1.getString(10));
            kontakt.setNotatki(kursor1.getString(11));
        }
        return kontakt;
    }

    public void createTable(SQLiteDatabase db) {
        db.execSQL("create table " + table_name + "(ID_Umowy INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Data TEXT ," +
                "Miejscowosc TEXT ," +
                "Lokal TEXT ," +
                "Imie TEXT ," +
                "Nazwisko TEXT ," +
                "Miejsce_Uklonu TEXT ," +
                "Godzina_Uklonu TEXT ," +
                "Cena TEXT ," +
                "Wyjazd TEXT ," +
                "Tel_Mlody TEXT ," +
                "Tel_Mloda TEXT ," +
                "Notatki TEXT" +
                ")");
    }


    public Cursor pokazWszystkie() {

        SQLiteDatabase db = dbManager.getReadableDatabase();
        String[] kolumny = {"Data", "Miejscowosc", "Lokal", "Imie", "Nazwisko", "Miejsce_Uklonu",
                "Godzina_Uklonu", "Cena", "Wyjazd", "Tel_Mlody", "Tel_Mloda", "Notatki"};

        Cursor kursor1 = db.query(table_name, kolumny, null, null, null, null, null);

        return kursor1;
    }



}
