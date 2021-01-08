package com.example.mvvmrommretrofit.Retrofit;

import androidx.lifecycle.LiveData;

import com.example.mvvmrommretrofit.Model.Person;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiCall {
    @GET("data.php")
    Call<LiveData<List<Person>>> personList();
}
