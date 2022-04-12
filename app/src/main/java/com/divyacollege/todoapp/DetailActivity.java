package com.divyacollege.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {
    Button mSaveBtn;
    EditText mTitleEt;
    EditText mDescriptionEt;
    CheckBox mStatusCb;
    DbHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        dbHelper = new DbHelper(this);
        mSaveBtn = findViewById(R.id.save_btn);
        mTitleEt = findViewById(R.id.title_et);
        mStatusCb  = findViewById(R.id.completed_cb);
        mDescriptionEt = findViewById(R.id.description_et);

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = mTitleEt.getText().toString();
                String description = mDescriptionEt.getText().toString();
                int status = mStatusCb.isChecked() ? 1 :0;

                Todo todo = new Todo(0,title,description,status);
                dbHelper.insertData(todo);
                finish();
            }
        });

    }
}