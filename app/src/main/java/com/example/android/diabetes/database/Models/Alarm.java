package com.example.android.diabetes.database.Models;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Alarm {
    @PrimaryKey(autoGenerate = true)
    int Userid ;
    String name_medicene;
    int daily_dose;
    String daily_time;

    public Alarm() {
    }
    @Ignore
    public Alarm(String name_medicene, int daily_dose, String daily_time) {
        this.name_medicene = name_medicene;
        this.daily_dose = daily_dose;
        this.daily_time = daily_time;
    }


    @Ignore
    public Alarm(String name_medicene) {
        this.name_medicene = name_medicene;
    }

    public int getUserid() {
        return Userid;
    }

    public void setUserid(int userid) {
        Userid = userid;
    }
    public String getName_medicene() {
        return name_medicene;
    }

    public void setName_medicene(String name_medicene) {
        this.name_medicene = name_medicene;
    }

    public int getDaily_dose() {
        return daily_dose;
    }

    public void setDaily_dose(int daily_dose) {
        this.daily_dose = daily_dose;
    }

    public String getDaily_time() {
        return daily_time;
    }

    public void setDaily_time(String daily_time) {
        this.daily_time = daily_time;
    }


}
