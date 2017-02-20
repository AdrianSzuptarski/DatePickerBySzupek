package com.example.szupek.datepickerszupek;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PokazWszystkie extends AppCompatActivity {

    TextView wyswietl, wszystkieLacznie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokazwszystkie);
        wyswietl = (TextView)findViewById(R.id.TXTPokazWszystkie);
        wyswietl.setText("");
        wszystkieLacznie = (TextView)findViewById(R.id.TXTWszystkielacznie);
        wszystkieLacznie.setText("");


        DAO zb = new DAO(new DBManager(this));
        Cursor k = zb.pokazWszystkie();
        int numer = 1;
        while(k.moveToNext()){
            String data = k.getString(0);
            String miejscowosc = k.getString(1);
            String lokal = k.getString(2);
            String imie = k.getString(3);
            String nazwisko = k.getString(4);
            String uklon = k.getString(5);
            String godzinaUklonu = k.getString(6);
            String cena = k.getString(7);
            String wyjazd = k.getString(8);
            String tel_Mlody = k.getString(9);
            String tel_Mloda = k.getString(10);
            String notatki = k.getString(11);
            wyswietl.setText(wyswietl.getText()+"\n"+numer+" "+data+" "+miejscowosc+" "+lokal+
                    " "+imie+" "+nazwisko+" "+uklon+" "+godzinaUklonu+" "+cena+" "+wyjazd+
                    " "+tel_Mlody+" "+tel_Mloda+" "+notatki+"\n");
            numer ++;
        }
        wszystkieLacznie.setText("Wszystkich wesel lacznie jest :   "+(numer-1));



    }
}
