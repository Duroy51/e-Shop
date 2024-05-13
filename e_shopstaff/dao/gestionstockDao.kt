package com.example.e_shopstaff.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.e_shopstaff.data.gestionstock
import kotlinx.coroutines.flow.Flow


@Dao
interface gestionstockDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGestionStock(item: gestionstock)

    @Update
    suspend fun updateGestionStock(item: gestionstock)

    @Delete
    suspend fun deleteGestionStock(item: gestionstock)

    @Query("SELECT * from gestionstock WHERE idStock = :id")
    fun getGestionStock(id: Int): Flow<gestionstock>

    @Query("SELECT * from gestionstock ORDER BY qte ASC")
    fun getAllGestionStock(): Flow<List<gestionstock>>
}