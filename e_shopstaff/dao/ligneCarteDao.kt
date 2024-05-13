package com.example.e_shopstaff.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.e_shopstaff.data.influenceur
import com.example.e_shopstaff.data.ligneCarte
import kotlinx.coroutines.flow.Flow


@Dao
interface ligneCarteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLigneCarte(item: ligneCarte)

    @Update
    suspend fun updateLigneCarte(item: ligneCarte)

    @Delete
    suspend fun deleteLigneCarte(item: ligneCarte)

    @Query("SELECT * from influenceur WHERE idInf = :id")
    fun getCommande(id: Int): Flow<commandeDao>

    @Query("SELECT * from influenceur ORDER BY nom ASC")
    fun getAllCommande(): Flow<List<influenceur>>
}