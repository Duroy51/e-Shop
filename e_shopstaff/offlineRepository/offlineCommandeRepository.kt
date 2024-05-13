package com.example.e_shopstaff.offlineRepository

import com.example.e_shopstaff.dao.commandeDao
import com.example.e_shopstaff.data.commande
import com.example.e_shopstaff.repository.commandeRepository
import kotlinx.coroutines.flow.Flow



class offlineCommandeRepository(private val commandeDao: commandeDao) : commandeRepository {

    override fun getAllCommandeStream(): Flow<List<commande>> = commandeDao.getAllCommande()

    override fun getCommandeStream(id: Int): Flow<commande?> = commandeDao.getCommande(id)

    override suspend fun insertCommande(item: commande) = commandeDao.insertCommande(item)

    override suspend fun deleteCommande(item: commande) = commandeDao.deleteCommande(item)

    override suspend fun updateCommande(item: commande) = commandeDao.updateCommande(item)
}