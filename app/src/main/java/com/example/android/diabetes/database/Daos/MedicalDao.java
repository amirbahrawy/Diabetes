package com.example.android.diabetes.database.Daos;

import com.example.android.diabetes.database.Models.Medical;
import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
@Dao
public interface MedicalDao {
    @Insert
    void AddInfo(Medical medical);

    @Update
    void UpdateInfo(List<Medical> medicalList);

    @Query("select * from Medical")
    List <Medical> getAllInformation();
}
