package com.example.e_shopstaff.dao

import android.content.ClipData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Delete
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.e_shopstaff.data.achatFournisseur
import kotlinx.coroutines.flow.Flow



@Dao
    interface achatFournisseurDao {
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insertAchatFournisseur(item: achatFournisseur)

        @Update
        suspend fun updateAchatFournisseur(item: achatFournisseur)

        @Delete
        suspend fun deleteAchatFournisseur(item: achatFournisseur)

        @Query("SELECT * from achatFournisseur WHERE idAchat = :id")
        fun getAchatFournisseur(id: Int): Flow<achatFournisseur>

        @Query("SELECT * from achatFournisseur ORDER BY idAchat ASC")
        fun getAllAchatFournisseur(): Flow<List<achatFournisseur>>
    }
