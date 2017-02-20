package com.example.szupek.datepickerszupek;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.roomorama.caldroid.CaldroidFragment;
import java.util.Calendar;


public class MainActivity extends FragmentActivity {
    CalendarView simpleCalendarView;
//    TextView dateDisplay;
    Calendar c;
    public static String data;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ColorDrawable green = new ColorDrawable(Color.GREEN);
        CaldroidFragment caldroidFragment = new CaldroidFragment();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        dateDisplay = (TextView) findViewById(R.id.textView_display);
//        dateDisplay.setText("Date: ");

        simpleCalendarView = (CalendarView) findViewById(R.id.simpleCalendarView); // get the reference of CalendarView
        simpleCalendarView.setFirstDayOfWeek(2);
        simpleCalendarView.setWeekSeparatorLineColor(Color.GREEN); // green color for the week separator line+


        c = Calendar.getInstance();
        int year_c = c.get(Calendar.YEAR);
        int mont_c = c.get(Calendar.MONTH);
        int day_c = c.get(Calendar.DAY_OF_MONTH);
//        dateDisplay.setText("Date: " + year_c + " / " + (mont_c + 1) + " / " + day_c);
        data = (day_c + " / " + (mont_c + 1) + " / " + year_c);
        simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

//            dateDisplay.setText("Date: " + dayOfMonth + " / " + (month + 1) + " / " + year);
            data = (dayOfMonth + " / " + (month + 1) + " / " + year);

            }

        });


        final Context kon = this;
        Button dodaj_btn = (Button) findViewById(R.id.button_dodaj);

        dodaj_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DAO zb = new DAO(new DBManager(kon));
                boolean sprawdzenie = zb.sprawdz(data);
                if(sprawdzenie == false){
                    context = getApplicationContext();
                    Intent intent = new Intent(context, dodaj_Activity.class);
                    intent.putExtra("Data_wybrana", data);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Nie można dodac dwóch wesel na jeden termin",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });



        Button PokazWszystkie = (Button)findViewById(R.id.btnWszystkie);
        PokazWszystkie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PokazWszystkie.class);
                startActivity(intent);
            }
        });
    }




    public void PokazUmowe(View view) {

        DAO zb = new DAO(new DBManager(this));
        boolean sprawdzenie = zb.sprawdz(data);
        if(sprawdzenie == false){
            Toast.makeText(MainActivity.this, "Nie ma wesela na ten termin",
                    Toast.LENGTH_SHORT).show();
        }else{
            Intent myIntent = new Intent(this, dodaj_Activity2.class);
            myIntent.putExtra("dataUmowy",data);
            startActivity(myIntent);
        }

    }


}

