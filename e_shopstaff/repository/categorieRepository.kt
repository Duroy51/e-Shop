package com.example.e_shopstaff.repository

import com.example.e_shopstaff.data.achatFournisseur
import com.example.e_shopstaff.data.categorie
import kotlinx.coroutines.flow.Flow

interface categorieRepository {
    fun getAllCategorieStream(): Flow<List<categorie>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getCategorieStream(id: Int): Flow<categorie?>

    /**
     * Insert item in the data source
     */
    suspend fun insertCategorie(item: categorie)

    /**
     * Delete item from the data source
     */
    suspend fun deleteCategorie(item: categorie)

    /**
     * Update item in the data source
     */
    suspend fun updateCategorie(item: categorie)
}