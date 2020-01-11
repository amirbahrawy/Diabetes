package com.example.android.diabetes.database.Daos;

import com.example.android.diabetes.database.Models.Personal;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface PersonalDao {
    @Insert
    void AddInfo(Personal personal);

    @Update
    void UpdateInfo(List<Personal> personalList);

    @Query("select * from Personal")
    List <Personal> getAllInformation();


}
