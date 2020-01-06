package com.example.mywallet

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao

interface InOutLogDao {

    @Insert
    suspend fun insertLog(inOutLog: InOutLog)


    @Query("SELECT * FROM in_out_log")
    fun getLogs():LiveData<List<InOutLog>>   //because we use the live data, so can remove the 'suspend'

    @Query ("SELECT * FROM in_out_log WHERE id = :ID")
    suspend fun getALog(ID: Int): InOutLog

    @Update
    suspend fun updateLog(inOutLog: InOutLog)

    @Delete
    suspend fun deleteLog(inOutLog: InOutLog)

}