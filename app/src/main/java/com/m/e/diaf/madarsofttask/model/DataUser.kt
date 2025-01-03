package com.m.e.diaf.madarsofttask.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DataUser" )
data class DataUser (
    @PrimaryKey(autoGenerate = true)
    val id :Int ,
    val user_name :String ,
    val Age:String ,
    val job_title :String ,
    val gender:String
)