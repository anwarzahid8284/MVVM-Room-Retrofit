package com.example.mvvmrommretrofit.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.mvvmrommretrofit.MVVM.PersonViewModel;
import com.example.mvvmrommretrofit.Model.Person;
import com.example.mvvmrommretrofit.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
   private PersonViewModel personViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personViewModel=new ViewModelProvider(this).get(PersonViewModel.class);
        personViewModel.getPersonList().observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(List<Person> personList) {

            }
        });
    }
}