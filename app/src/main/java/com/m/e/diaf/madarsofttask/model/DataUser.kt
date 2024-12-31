package com.m.e.diaf.madarsofttask.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DataUserTable" )
data class DataUser (
    @PrimaryKey(autoGenerate = true)
    val id :Short ,
    val user_name :String ,
    val Age:Short ,
    val job_title :String ,
    val gender:String
)