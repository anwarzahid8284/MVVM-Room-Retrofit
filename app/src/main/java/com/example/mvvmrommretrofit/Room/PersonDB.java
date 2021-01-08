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
public abstract class PersonDB extends RoomDatabase {
    private static final String DATABASE_NAME="database";
    public abstract PersonDao personDao();
    private static volatile PersonDB DATABASE_INSTANCE;

    public static PersonDB getInstance(Context context){
        if(DATABASE_INSTANCE==null){
            synchronized (PersonDB.class){
                DATABASE_INSTANCE= Room.databaseBuilder(context, PersonDB.class,DATABASE_NAME)
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
        public PopulateData(PersonDB personDB){
            personDao= personDB.personDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            personDao.deletePerson();
            return null;
        }
    }
}
