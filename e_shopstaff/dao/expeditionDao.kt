package com.example.e_shopstaff.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.e_shopstaff.data.Expedition
import kotlinx.coroutines.flow.Flow


@Dao
interface expeditionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertExpedition(item: Expedition)

    @Update
    suspend fun updateExpedition(item: Expedition)

    @Delete
    suspend fun deleteExpedition(item: Expedition)

    @Query("SELECT * from Expedition WHERE idExp = :id")
    fun getExpedition(id: Int): Flow<Expedition>

    @Query("SELECT * from Expedition ORDER BY idExp ASC")
    fun getAllExpedition(): Flow<List<Expedition>>


}