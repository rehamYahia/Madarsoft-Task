package com.m.e.diaf.madarsofttask.database

import androidx.room.*
import com.m.e.diaf.madarsofttask.model.DataUser

@Database(entities = [DataUser::class ] , version = 2 , exportSchema = false)

abstract class DataUserDatabase  :RoomDatabase(){
    abstract fun getDao():DataUserDao

}