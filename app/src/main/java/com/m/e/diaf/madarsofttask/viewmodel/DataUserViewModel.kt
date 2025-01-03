package com.m.e.diaf.madarsofttask.viewmodel

import androidx.lifecycle.ViewModel
import com.m.e.diaf.madarsofttask.model.DataUser
import com.m.e.diaf.madarsofttask.repository.DataUserRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DataUserViewModel @Inject constructor(private val dataUserRepo: DataUserRepo): ViewModel(){
    private val _allApplicant : MutableStateFlow<List<DataUser>?> = MutableStateFlow(null)
    val allApplicant : StateFlow<List<DataUser>?> = _allApplicant

    suspend fun insertApplicant(dataUser: DataUser){
        dataUserRepo.insertApplicant(dataUser)
    }

    suspend fun getAllApplicant(){
        _allApplicant.value =  dataUserRepo.getAllApplicant()
    }

}