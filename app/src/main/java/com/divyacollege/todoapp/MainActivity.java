package com.divyacollege.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
FloatingActionButton fab ;
RecyclerView recyclerView;
DbHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fab = findViewById(R.id.main_add_btn);
        recyclerView =  findViewById(R.id.main_rv);

        dbHelper = new DbHelper(this);




        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            startActivity(intent);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Todo> todoList = dbHelper.fetchAllData();
        TodoAdapter adapter = new TodoAdapter(todoList,this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}