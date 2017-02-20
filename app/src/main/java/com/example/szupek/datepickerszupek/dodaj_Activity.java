package com.example.szupek.datepickerszupek;


import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.szupek.datepickerszupek.model.Wesele;


public class dodaj_Activity extends AppCompatActivity {

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_);
        TextView data_view = (TextView) findViewById(R.id.textView_dodaj);
        data_view.setText(getIntent().getStringExtra("Data_wybrana"));

}


    public void DodajSzczegoluButton(View view) {

        TextView data = (TextView) findViewById(R.id.textView_dodaj);
        EditText miejscowosc = (EditText) findViewById(R.id.editText_miejscowosc);
        EditText lokal = (EditText) findViewById(R.id.editTextLokal);
        EditText imie = (EditText) findViewById(R.id.editImie);
        EditText nazwisko = (EditText) findViewById(R.id.editNazwisko);
        EditText uklon = (EditText) findViewById(R.id.editUklon);
        EditText godzinaUklonu = (EditText) findViewById(R.id.editgodzinaUklonu);
        EditText cena = (EditText) findViewById(R.id.editCena);
        EditText wyjazd = (EditText) findViewById(R.id.editGodzinaWyjazdu);
        EditText tel_mlody = (EditText) findViewById(R.id.edittelefonMlody);
        EditText tel_mloda = (EditText) findViewById(R.id.editTelefonMloda);
        //TODO Zrobić dodawanie notatek
        EditText notatki = (EditText) findViewById(R.id.editText_miejscowosc);

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

        Wesele wesele = new Wesele(data1,miejscowosc1,lokal1,imie1,nazwisko1,uklon1,godzinaUklonu1,
                cena1,wyjazd1,tel_mlody1,tel_mloda1,notatki1);

        DAO nowy = new DAO(new DBManager(this));

        boolean dodalo = nowy.Dodaj_Wesele(wesele);
        if (dodalo = true) {
            Toast.makeText(dodaj_Activity.this, "Wesele dodano do bazy", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,dodaj_Activity2.class);
            intent.putExtra("dataUmowy",data1);
            startActivity(intent);
        }else {
            Toast.makeText(dodaj_Activity.this, "Błąd podczas dodawania do bazy", Toast.LENGTH_SHORT).show();
        }


    }


}



