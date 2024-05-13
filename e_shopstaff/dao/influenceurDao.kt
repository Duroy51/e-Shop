package com.example.e_shopstaff.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.e_shopstaff.data.influenceur
import kotlinx.coroutines.flow.Flow


@Dao
interface influenceurDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertInfluenceur(item: influenceur)

    @Update
    suspend fun updateInfluenceur(item: influenceur)

    @Delete
    suspend fun deleteInfluenceur(item: influenceur)

    @Query("SELECT * from influenceur WHERE idInf = :id")
    fun getInfluenceur(id: Int): Flow<influenceur>

    @Query("SELECT * from influenceur ORDER BY nom ASC")
    fun getAllInfluenceur(): Flow<List<influenceur>>
}