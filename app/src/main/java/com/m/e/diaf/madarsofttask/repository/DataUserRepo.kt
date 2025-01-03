package com.m.e.diaf.madarsofttask.repository

import com.m.e.diaf.madarsofttask.model.DataUser

interface DataUserRepo {
    suspend fun insertApplicant(dataUser: DataUser)
    suspend fun getAllApplicant():List<DataUser>
}