package com.m.e.diaf.madarsofttask.repository

import com.m.e.diaf.madarsofttask.database.DataUserDao
import com.m.e.diaf.madarsofttask.model.DataUser

class DataUserRepoImp(val dataUserDao: DataUserDao) : DataUserRepo {
    override suspend fun insertApplicant(dataUser: DataUser) {
        dataUserDao.insertDataUser(dataUser)
    }

    override suspend fun getAllApplicant(): List<DataUser> {
       return  dataUserDao.getAllDataUser()
    }

}

