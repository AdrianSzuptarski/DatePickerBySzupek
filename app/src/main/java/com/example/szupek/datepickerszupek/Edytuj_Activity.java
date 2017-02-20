package com.example.szupek.datepickerszupek;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.szupek.datepickerszupek.model.Wesele;

public class Edytuj_Activity extends AppCompatActivity {

    TextView data;
    EditText miejscowosc,lokal,imie,nazwisko,uklon,godzinaUklonu,cena,wyjazd,tel_mlody,tel_mloda,
    notatki;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edytuj_);



        data = (TextView) findViewById(R.id.textView_dodaj);
        miejscowosc = (EditText) findViewById(R.id.editText_miejscowosc);
        lokal = (EditText) findViewById(R.id.editTextLokal);
        imie = (EditText) findViewById(R.id.editImie);
        nazwisko = (EditText) findViewById(R.id.editNazwisko);
        uklon = (EditText) findViewById(R.id.editUklon);
        godzinaUklonu = (EditText) findViewById(R.id.editgodzinaUklonu);
        cena = (EditText) findViewById(R.id.editCena);
        wyjazd = (EditText) findViewById(R.id.editGodzinaWyjazdu);
        tel_mlody = (EditText) findViewById(R.id.edittelefonMlody);
        tel_mloda = (EditText) findViewById(R.id.editTelefonMloda);
        //TODO Zrobić dodawanie notatek
        notatki = (EditText) findViewById(R.id.editText_miejscowosc);


        Intent intent= getIntent();

        DAO zb = new DAO(new DBManager(this));
        String databiezaca=intent.getStringExtra("dataDoEdycji");
        Wesele k = zb.pokazJednaUmowe(databiezaca);

        data.setText(k.getData());
        miejscowosc.setText(k.getMiejscowosc());
        lokal.setText(k.getLokal());
        imie.setText(k.getImie());
        nazwisko.setText(k.getNazwisko());
        uklon.setText(k.getUklon());
        godzinaUklonu.setText(k.getGodzinaUklonu());
        cena.setText(k.getCena());
        wyjazd.setText(k.getWyjazd());
        tel_mlody.setText(k.getTel_Mlody());
        tel_mloda.setText(k.getTel_Mloda());



        final Context con = this;
        Button ZatwierdzZmiany = (Button)findViewById(R.id.buttonZatwierdzZmiany);
        ZatwierdzZmiany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data1 = data.getText().toString();
                String miejscowosc1 = miejscowosc.getText().toString();
                String lokal1 = lokal.getText().toString();
                String imie1 = imie.getText().toString();
                String nazwisko1 = nazwisko.getText().toString();
                String uklon1 = uklon.getText().toString();
                String godzinaUklonu1 = godzinaUklonu.getText().toString();
                String cena1 = cena.getText().toString();
                String wyjazd1 = wyjazd.getText().toString();
                String tel_mlody1 = tel_mlody.getText().toString();
                String tel_mloda1 = tel_mloda.getText().toString();
                String notatki1 = notatki.getText().toString();

                Wesele wesele = new Wesele(data1, miejscowosc1, lokal1, imie1, nazwisko1, uklon1,
                        godzinaUklonu1, cena1, wyjazd1, tel_mlody1, tel_mloda1, notatki1);

                DAO nowy = new DAO(new DBManager(con));

                boolean dodalo = nowy.Dodaj_Wesele(wesele);
                if (dodalo = true){
                    Toast.makeText(Edytuj_Activity.this, "Pomyślnie zedytowano wesele",
                            Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Edytuj_Activity.this, dodaj_Activity2.class);
                    intent.putExtra("dataUmowy",data1);
                    startActivity(intent);
            }else{
                    Toast.makeText(Edytuj_Activity.this, "UPPPSS coś poszło nie tak :/",
                            Toast.LENGTH_SHORT).show();

                 }
            }
        });
    }
}
