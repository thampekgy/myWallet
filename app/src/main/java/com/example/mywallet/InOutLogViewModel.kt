package com.example.mywallet

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class InOutLogViewModel(application: Application):AndroidViewModel(application) {

    //ViewModel to maintain a reference to the repository
    private val repository: InOutLogRespository

    val allLogs : LiveData<List<InOutLog>>

    init{

        // Get reference to DAO
        val inOutLogDao = InOutLogDatabase
            .getDatabase(application)
            .inOutLogDao()

        repository = InOutLogRespository(inOutLogDao)
        allLogs = repository.allLogs
    }

    //ViewModel to use coroutine to perform long process
    fun insertlog(inOutLog: InOutLog) = viewModelScope.launch{
        repository.insertLog(inOutLog)
    }

}