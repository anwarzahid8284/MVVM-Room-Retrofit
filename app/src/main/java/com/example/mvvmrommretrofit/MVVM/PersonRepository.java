package com.example.mvvmrommretrofit.MVVM;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.mvvmrommretrofit.Model.Person;
import com.example.mvvmrommretrofit.Room.PersonDB;
import com.example.mvvmrommretrofit.Room.PersonDao;

import java.util.List;

public class PersonRepository {
    private PersonDB personDB;
    private LiveData<List<Person>> getAllPerson;
    public PersonRepository(Application application){
        personDB = PersonDB.getInstance(application);
        getAllPerson= personDB.personDao().getAllPersons();
    }

    public LiveData<List<Person>> getGetAllPerson(){
        return getAllPerson;
    }
    public void insertPerson(List<Person> personList){
        new InsertAsysncTask(personDB).execute(personList);

    }
    public static class  InsertAsysncTask extends AsyncTask<List<Person>,Void,Void>{
        public PersonDao personDao;
        public InsertAsysncTask(PersonDB personDB){
            personDao= personDB.personDao();
        }
        @Override
        protected Void doInBackground(List<Person>... lists) {
            personDao.insertPerson(lists[0]);
            return null;
        }
    }
}
