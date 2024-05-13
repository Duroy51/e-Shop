package com.example.e_shopstaff.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.e_shopstaff.data.gestionnaire
import kotlinx.coroutines.flow.Flow


@Dao
interface gestionnaireDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGestionnaire(item: gestionnaire)

    @Update
    suspend fun updateGestionnaire(item: gestionnaire)

    @Delete
    suspend fun deleteGestionnaire(item: gestionnaire)

    @Query("SELECT * from gestionnaire WHERE idGest = :id")
    fun getGestionnaire(id: Int): Flow<gestionnaire>

    @Query("SELECT * from gestionnaire ORDER BY nomGest ASC")
    fun getAllGestionnaire(): Flow<List<gestionnaire>>
}