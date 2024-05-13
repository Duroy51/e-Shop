package com.example.e_shopstaff.repository

import com.example.e_shopstaff.data.gestionnaire
import kotlinx.coroutines.flow.Flow

interface gestionnaireRepository {

    fun getAllGestionnaireStream(): Flow<List<gestionnaire>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getGestionnaireStream(id: Int): Flow<gestionnaire?>

    /**
     * Insert item in the data source
     */
    suspend fun insertGestionnaire(item: gestionnaire)

    /**
     * Delete item from the data source
     */
    suspend fun deleteGestionnaire(item: gestionnaire)

    /**
     * Update item in the data source
     */
    suspend fun updateGestionnaire(item: gestionnaire)
}