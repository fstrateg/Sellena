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
        int i=0;
        TaskItem item=new TaskItem("Загрузка с базы данных",68);
        item.Tab = i++;
        addTask(item);

        item=new TaskItem("Добавление задачи",1);
        item.Tab = i++;
        addTask(item);

        item=new TaskItem("Форма подзадач",1);
        item.Tab = i++;
        addTask(item);

        item=new TaskItem("Управление процессом выполнения",2);
        item.Tab = i++;
        addTask(item);

        item=new TaskItem("Расчет процентов по дочерним элементам",0);
        item.Tab = i++;
        addTask(item);

        item=new TaskItem("Признак выполнения",0);
        item.Tab = i;
        addTask(item);
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
