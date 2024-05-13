package com.example.e_shopstaff.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.e_shopstaff.data.facture
import kotlinx.coroutines.flow.Flow


@Dao
interface factureDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFacture(item: facture)

    @Update
    suspend fun updateFacture(item: facture)

    @Delete
    suspend fun deleteFacture(item: facture)

    @Query("SELECT * from facture WHERE idFac = :id")
    fun getFacture(id: Int): Flow<facture>

    @Query("SELECT * from facture ORDER BY idFac ASC")
    fun getAllFacture(): Flow<List<facture>>
}