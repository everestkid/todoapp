package com.divyacollege.todoapp;

public class Todo {
    int ID;
    public String title;
    public String description;
    public int status;

    public Todo(int ID, String title, String description, int status) {
        this.ID = ID;
        this.title = title;
        this.description = description;
        this.status = status;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
