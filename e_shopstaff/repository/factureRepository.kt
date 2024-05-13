package com.example.e_shopstaff.repository

import com.example.e_shopstaff.data.facture
import kotlinx.coroutines.flow.Flow

interface factureRepository {

    fun getAllFactureStream(): Flow<List<facture>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getFactureStream(id: Int): Flow<facture?>

    /**
     * Insert item in the data source
     */
    suspend fun insertFacture(item: facture)

    /**
     * Delete item from the data source
     */
    suspend fun deleteFacture(item: facture)

    /**
     * Update item in the data source
     */
    suspend fun updateFacture(item: facture)
}