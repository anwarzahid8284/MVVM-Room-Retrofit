package com.example.mvvmrommretrofit.MVVM;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mvvmrommretrofit.Model.Person;

import java.util.List;

public class PersonViewModel extends AndroidViewModel {
    private PersonRepository personRepository;
    private LiveData<List<Person>> personList;
    public PersonViewModel(@NonNull Application application) {
        super(application);
        personRepository =new PersonRepository(application);
        personList= personRepository.getGetAllPerson();
    }
    public LiveData<List<Person>> getPersonList(){
        return personList;
    }
    public void insert(List<Person> personList1){
        personRepository.insertPerson(personList1);
    }
}
