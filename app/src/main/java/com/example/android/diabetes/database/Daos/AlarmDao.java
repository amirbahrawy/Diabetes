package com.example.android.diabetes.database.Daos;

import com.example.android.diabetes.database.Models.Alarm;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
@Dao
public interface AlarmDao {
    @Insert
    void AddInfo(Alarm alarm);

    @Update
    void UpdateInfo(List<Alarm> alarmList);

    @Query("select * from alarm")
    List <Alarm> getAllInformation();

    @Query("select name_medicene from Alarm")
    List <String> getMediceneName();
}
