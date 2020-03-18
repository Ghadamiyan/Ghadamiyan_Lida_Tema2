package com.example.r;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName = "users")
public class User {
    @ColumnInfo(name="user_id")
    @PrimaryKey
    private int id;

    @ColumnInfo(name="user_name")
    private String name;

    @ColumnInfo(name="user_grade")
    private  Float grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }
}
