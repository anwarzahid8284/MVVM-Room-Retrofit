package com.example.mvvmrommretrofit.Room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.mvvmrommretrofit.Model.Person;

import java.util.List;

@Dao
public interface PersonDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPerson(List<Person> personList);

    @Query("Select * from Person")
    LiveData<List<Person>> getAllPersons();

    @Query("Delete from Person")
    void deletePerson();
}
