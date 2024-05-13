package com.example.e_shopstaff.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.e_shopstaff.data.commande
import kotlinx.coroutines.flow.Flow

@Dao
interface commandeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCommande(item: commande)

    @Update
    suspend fun updateCommande(item: commande)

    @Delete
    suspend fun deleteCommande(item: commande)

    @Query("SELECT * from commande WHERE idCommande = :id")
    fun getCommande(id: Int): Flow<commande>

    @Query("SELECT * from commande ORDER BY nomClient ASC")
    fun getAllCommande(): Flow<List<commande>>
}