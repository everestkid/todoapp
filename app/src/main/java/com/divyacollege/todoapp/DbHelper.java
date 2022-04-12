package com.divyacollege.todoapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class DbHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "mydb";
    public static final String TABLE_NAME = "todo";

    public DbHelper( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE "+TABLE_NAME +"(ID INTEGER  PRIMARY KEY AUTOINCREMENT, title TEXT, description TEXT, status INTEGER )";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertData(Todo todo){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues =new  ContentValues();
        contentValues.put("title",todo.getTitle());
        contentValues.put("description",todo.getDescription());
        contentValues.put("status",todo.getStatus());

        db.insert(TABLE_NAME,null,contentValues);


    }

    public List<Todo> fetchAllData(){
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * from  "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        Log.d("cursor",cursor.toString());

        List<Todo> todoList = new ArrayList<>();

        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            String description = cursor.getString(2);
            int status = cursor.getInt(3);

            Todo todo = new Todo(id,title,description,status);
            todoList.add(todo);

        }

        return todoList;
    }



}
