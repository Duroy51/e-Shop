package com.example.e_shopstaff.offlineRepository

import com.example.e_shopstaff.dao.clientCarteDao
import com.example.e_shopstaff.data.ClientCarte
import com.example.e_shopstaff.repository.clientCarteRepository
import kotlinx.coroutines.flow.Flow

class offlineClientCarteRepository(private val clientCarteDao: clientCarteDao):
    clientCarteRepository {

    override fun getAllClientCarteStream(): Flow<List<ClientCarte>> = clientCarteDao.getAllClientCarte()

    override fun getClientCarteStream(id: Int): Flow<ClientCarte?> = clientCarteDao.getClientCarte(id)

    override suspend fun insertClientCarte(item: ClientCarte) = clientCarteDao.insertClientCarte(item)

    override suspend fun deleteClientCarte(item: ClientCarte) = clientCarteDao.deleteClientCarte(item)

    override suspend fun updateClientCarte(item: ClientCarte) = clientCarteDao.updateClientCarte(item)

}