package com.example.szupek.datepickerszupek;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by szupek on 2016-11-26.
 */

public class DBManager extends SQLiteOpenHelper {

    public static final String database_name = "BazaArto";
    public static final String table_name = "Umowy";


    public DBManager(Context context) {

        super(context, database_name, null, 5);
    }


    public void onCreate(SQLiteDatabase db) {
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



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists " + table_name);
        onCreate(db);

    }
}
