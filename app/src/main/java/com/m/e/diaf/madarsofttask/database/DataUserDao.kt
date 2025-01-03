package com.m.e.diaf.madarsofttask.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.m.e.diaf.madarsofttask.model.DataUser

@Dao
interface DataUserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDataUser(dataUser: DataUser)

    @Query("SELECT * FROM DataUser")
    suspend fun getAllDataUser():List<DataUser>

}