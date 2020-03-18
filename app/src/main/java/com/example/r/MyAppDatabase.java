package com.example.r;

import androidx.room.Database;
import androidx.room.RoomDatabase;
//clasa abstracta
@Database(entities = {User.class}, version = 1)
public abstract class MyAppDatabase extends RoomDatabase {

    //are metoda abstracta
    public abstract MyDao myDao();

}

