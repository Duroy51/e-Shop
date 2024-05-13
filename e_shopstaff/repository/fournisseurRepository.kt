package com.example.e_shopstaff.repository

import com.example.e_shopstaff.data.Fournisseur
import kotlinx.coroutines.flow.Flow

interface fournisseurRepository {

    fun getAllFournisseurStream(): Flow<List<Fournisseur>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getFournisseurStream(id: Int): Flow<Fournisseur?>

    /**
     * Insert item in the data source
     */
    suspend fun insertFournisseur(item: Fournisseur)

    /**
     * Delete item from the data source
     */
    suspend fun deleteFournisseur(item: Fournisseur)

    /**
     * Update item in the data source
     */
    suspend fun updateFournisseur(item: Fournisseur)
}