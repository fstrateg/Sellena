package com.fstrateg.sellena;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private DBHelper dbHelper;
    SQLiteDatabase dbo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerView view=findViewById(R.id.idRecycler);
        view.setLayoutManager(linearLayoutManager);

        dbHelper = new DBHelper(getApplicationContext());
    }

    @Override
    public void onResume()
    {
        super.onResume();
        dbo=dbHelper.getWritableDatabase();
        Cursor c=dbo.rawQuery("select * from task order by tab", null);
        ArrayList<TaskItem> items = new ArrayList<>();
        while (c.moveToNext())
        {
            items.add(new TaskItem(c.getString(1), c.getInt(2)));
        }
        c.close();
        dbo.close();
        TaskAdapter adapter=new TaskAdapter(this,items);
        RecyclerView view=findViewById(R.id.idRecycler);
        view.setAdapter(adapter);
    }
}