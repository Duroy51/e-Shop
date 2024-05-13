package com.example.e_shopstaff.repository

import com.example.e_shopstaff.data.Expedition
import kotlinx.coroutines.flow.Flow

interface expeditionRepository {

    fun getAllExpeditionStream(): Flow<List<Expedition>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getExpeditionStream(id: Int): Flow<Expedition?>

    /**
     * Insert item in the data source
     */
    suspend fun insertExpedition(item: Expedition)

    /**
     * Delete item from the data source
     */
    suspend fun deleteExpedition(item: Expedition)

    /**
     * Update item in the data source
     */
    suspend fun updateExpedition(item: Expedition)
}