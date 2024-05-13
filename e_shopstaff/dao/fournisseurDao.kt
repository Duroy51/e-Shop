package com.example.e_shopstaff.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.e_shopstaff.data.Fournisseur
import kotlinx.coroutines.flow.Flow


@Dao
interface fournisseurDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFournisseur(item: Fournisseur)

    @Update
    suspend fun updateFournisseur(item: Fournisseur)

    @Delete
    suspend fun deleteFournisseur(item: Fournisseur)

    @Query("SELECT * from Fournisseur WHERE idFour = :id")
    fun getFournisseur(id: Int): Flow<Fournisseur>

    @Query("SELECT * from Fournisseur ORDER BY nom ASC")
    fun getAllFournisseur(): Flow<List<Fournisseur>>
}