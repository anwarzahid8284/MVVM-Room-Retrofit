package com.example.mvvmrommretrofit.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmrommretrofit.Model.Person;
import com.example.mvvmrommretrofit.R;
import com.google.gson.internal.$Gson$Preconditions;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonVHolder> {
    Context context;
    LayoutInflater layoutInflater;
    List<Person> personList;

    public PersonAdapter(List<Person> personList, Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.personList = personList;
    }

    @NonNull
    @Override
    public PersonVHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonVHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public static class PersonVHolder extends RecyclerView.ViewHolder {
        ImageView imageViewPerson;
        TextView textViewName, textViewAge;

        public PersonVHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPerson = itemView.findViewById(R.id.personImageId);
            textViewName = itemView.findViewById(R.id.personNameId);
            textViewAge = itemView.findViewById(R.id.personAgeId);
        }
    }
}
