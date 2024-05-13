package com.example.e_shopstaff.repository

import com.example.e_shopstaff.data.influenceur
import kotlinx.coroutines.flow.Flow

interface influenceurRepository {

    fun getAllInfluenceurStream(): Flow<List<influenceur>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getInfluenceurStream(id: Int): Flow<influenceur?>

    /**
     * Insert item in the data source
     */
    suspend fun insertInfluenceur(item: influenceur)

    /**
     * Delete item from the data source
     */
    suspend fun deleteInfluenceur(item: influenceur)

    /**
     * Update item in the data source
     */
    suspend fun updateInfluenceur(item: influenceur)
}