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

public class dodaj_Activity2 extends AppCompatActivity {

    String dataBiezaca;
    TextView data, miejscowosc,lokal,imie,nazwisko,uklon,godzinaUklonu,cena,wyjazd,tel_mlody,
            tel_mloda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_2);

        TextView data = (TextView)findViewById(R.id.textView_data2);
        TextView miejscowosc = (TextView)findViewById(R.id.editText_miejscowosc2);
        TextView lokal = (TextView)findViewById(R.id.editTextLokal2);
        TextView imie = (TextView)findViewById(R.id.editImie2);
        TextView nazwisko = (TextView)findViewById(R.id.editNazwisko2);
        TextView uklon = (TextView)findViewById(R.id.editUklon2);
        TextView godzinaUklonu = (TextView)findViewById(R.id.editgodzinaUklonu2);
        TextView cena = (TextView)findViewById(R.id.editCena2);
        TextView wyjazd = (TextView)findViewById(R.id.editGodzinaWyjazdu2);
        TextView tel_mlody = (TextView)findViewById(R.id.edittelefonMlody2);
        TextView tel_mloda = (TextView)findViewById(R.id.editTelefonMloda2);

        Intent intent= getIntent();

        DAO zb = new DAO(new DBManager(this));
        dataBiezaca= intent.getStringExtra("dataUmowy");
        Wesele k = zb.pokazJednaUmowe(dataBiezaca);
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



        final Context kon=this;
        Button UsunWesele=(Button)findViewById(R.id.buttonUsunWesele);
        UsunWesele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DAO zb = new DAO(new DBManager(kon));
                zb.AnulujUmowe(dataBiezaca);
                Toast.makeText(dodaj_Activity2.this, "Wesele pomyślnie usunięto z bazy",
                        Toast.LENGTH_SHORT).show();
                Intent przenies = new Intent(kon,MainActivity.class);
                startActivity(przenies);
            }
        });

    }

    public void EdytujUmowe(View view) {

        Intent intent = new Intent (this,Edytuj_Activity.class);
        intent.putExtra("dataDoEdycji",dataBiezaca);
        startActivity(intent);
    }


}


