package com.example.e_shopstaff.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.e_shopstaff.data.achatFournisseur
import com.example.e_shopstaff.data.categorie
import kotlinx.coroutines.flow.Flow

    @Dao
    interface categorieDao {

        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insertCategorie(item: categorie)

        @Update
        suspend fun updateCategorie(item: categorie)

        @Delete
        suspend fun deleteCategorie(item: categorie)

        @Query("SELECT * from categorie WHERE idCat = :id")
        fun getCategorie(id: Int): Flow<categorie>

        @Query("SELECT * from categorie ORDER BY nomCat ASC")
        fun getAllCategorie(): Flow<List<categorie>>
    }
