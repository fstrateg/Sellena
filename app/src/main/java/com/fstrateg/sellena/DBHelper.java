package com.fstrateg.sellena;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DBNAME="SellenaDb";
    private static final Integer VERSION=2;

    private SQLiteDatabase _dbo;

    public DBHelper(@Nullable Context context) {
        super(context,DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table task(id integer primary key AUTOINCREMENT,"+
                "name text," +
                "progress integer," +
                "pid integer," +
                "tab integer," +
                "typ integer"
                +");");
        _dbo=db;
        createData();
    }

    private void createData()
    {
        String[] tasks=new String[]{
                "Загрузка с базы данных:68",
                "Добавление задачи:1",
                "Форма подзадач:1",
                "Управление процессом выполнения:2",
                "Расчет процентов по дочерним элементам:0",
                "Признак выполнения:0"
        };
        TaskItem item;
        String[] t;
        for (int n=0;n<tasks.length;n++)
        {
            t=tasks[n].split(":");
            item = new TaskItem(t[0],Integer.parseInt(t[1]));
            item.Tab=n;
            addTask(item);
        }
    }

    private void addTask(TaskItem item)
    {
        _dbo.execSQL("insert into task(name,progress,tab) values (:name,:progress,:tab);",
                new Object[]{item.Text,item.Progress,item.Tab}
                );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
