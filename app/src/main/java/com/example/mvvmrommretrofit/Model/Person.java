package com.example.mvvmrommretrofit.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;
@Entity
public class Person {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @SerializedName("id")
    @ColumnInfo(name = "personId")
    private int pId;

    @SerializedName("name")
    @ColumnInfo(name = "personName")
    private String pName;

    @SerializedName("image")
    @ColumnInfo(name = "personImage")
    private String pImage;

    @SerializedName("age")
    @ColumnInfo(name = "personAge")
    private int pAge;

    public Person(int id, int pId, String pName, String pImage, int pAge) {
        this.id = id;
        this.pId = pId;
        this.pName = pName;
        this.pImage = pImage;
        this.pAge = pAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpImage() {
        return pImage;
    }

    public void setpImage(String pImage) {
        this.pImage = pImage;
    }

    public int getpAge() {
        return pAge;
    }

    public void setpAge(int pAge) {
        this.pAge = pAge;
    }

    // this is show result in logcat
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", pId=" + pId +
                ", pName='" + pName + '\'' +
                ", pImage='" + pImage + '\'' +
                ", pAge=" + pAge +
                '}';
    }
}
