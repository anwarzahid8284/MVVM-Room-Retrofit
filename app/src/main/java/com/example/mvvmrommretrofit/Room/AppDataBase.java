package com.example.mvvmrommretrofit.Room;

import android.app.Person;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Person.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {
    private static final String DATABASE_NAME="database";
    public abstract PersonDao personDao();
    private static volatile   AppDataBase DATABASE_INSTANCE;

    public static AppDataBase getInstance(Context context){
        if(DATABASE_INSTANCE==null){
            synchronized (AppDataBase.class){
                DATABASE_INSTANCE= Room.databaseBuilder(context,AppDataBase.class,DATABASE_NAME)
                        .addCallback(callback)
                        .build();
            }
        }
        return DATABASE_INSTANCE;
    }
    static Callback callback=new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
    };
    public static class PopulateData extends AsyncTask<Void,Void,Void> {
        public PersonDao personDao;
        public PopulateData(AppDataBase appDataBase){
            personDao=appDataBase.personDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            personDao.deletePerson();
            return null;
        }
    }
}
