package com.example.e_shopstaff.repository


import com.example.e_shopstaff.data.commande
import kotlinx.coroutines.flow.Flow




interface commandeRepository {

    fun getAllCommandeStream(): Flow<List<commande>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getCommandeStream(id: Int): Flow<commande?>

    /**
     * Insert item in the data source
     */
    suspend fun insertCommande(item: commande)

    /**
     * Delete item from the data source
     */
    suspend fun deleteCommande(item: commande)

    /**
     * Update item in the data source
     */
    suspend fun updateCommande(item: commande)
}