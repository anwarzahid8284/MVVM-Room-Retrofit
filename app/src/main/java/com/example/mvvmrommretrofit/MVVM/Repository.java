package com.example.mvvmrommretrofit.MVVM;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.mvvmrommretrofit.Model.Person;
import com.example.mvvmrommretrofit.Room.AppDataBase;
import com.example.mvvmrommretrofit.Room.PersonDao;

import java.util.List;

public class Repository {
    private AppDataBase appDataBase;
    private LiveData<List<Person>> getAllPerson;
    public Repository(Application application){
        appDataBase=AppDataBase.getInstance(application);
        getAllPerson=appDataBase.personDao().getAllPersons();
    }

    public LiveData<List<Person>> getGetAllPerson(){
        return getAllPerson;
    }
    public void insertPerson(List<Person> personList){
        new InsertAsysncTask(appDataBase).execute(personList);

    }
    public static class  InsertAsysncTask extends AsyncTask<List<Person>,Void,Void>{
        public PersonDao personDao;
        public InsertAsysncTask(AppDataBase appDataBase){
            personDao=appDataBase.personDao();
        }
        @Override
        protected Void doInBackground(List<Person>... lists) {
            personDao.insertPerson(lists[0]);
            return null;
        }
    }
}
