package com.example.android.diabetes.database;

import android.content.Context;

import com.example.android.diabetes.database.Daos.AlarmDao;
import com.example.android.diabetes.database.Daos.MedicalDao;
import com.example.android.diabetes.database.Daos.PersonalDao;
import com.example.android.diabetes.database.Models.Alarm;
import com.example.android.diabetes.database.Models.Medical;
import com.example.android.diabetes.database.Models.Personal;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {Personal.class, Medical.class, Alarm.class},version = 6,exportSchema = false)
public abstract class MyDataBase extends RoomDatabase {
    private static MyDataBase  myDataBase;
    private final static String DataBaseName = "diabtedatabase";
    public abstract PersonalDao personalDao();
    public abstract MedicalDao medicalDao();
    public abstract AlarmDao alarmDao();
    public static MyDataBase getInstance(Context context){
        if(myDataBase == null)
        {
            myDataBase =  Room.databaseBuilder(context ,
                    MyDataBase.class,DataBaseName).fallbackToDestructiveMigration()
                    .allowMainThreadQueries().build();


        }
        return  myDataBase ;
    }
}
