package com.fstrateg.sellena;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<TaskItem> items;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadValues();
        RecyclerView view=findViewById(R.id.idRecycler);
        TaskAdapter adapter=new TaskAdapter(this,items);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        view.setLayoutManager(linearLayoutManager);
        view.setAdapter(adapter);
    }

    private void loadValues() {
        items=new ArrayList<>();
        items.add(new TaskItem("Начисление рекламы",85));
        items.add(new TaskItem("Начисление НДС", 55));
    }
}