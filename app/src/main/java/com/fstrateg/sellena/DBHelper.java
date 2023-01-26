package com.fstrateg.sellena;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DBNAME="SellenaDb";
    private static final Integer VERSION=1;

    public DBHelper(@Nullable Context context) {
        super(context,DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table task(id integer primary key AUTOINCREMENT,"
                +"name text,typ integer,progress integer"
                +");");
        //TODO: Создание тестовых проектов и задач на начало работы.
        //db.execSQL();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
