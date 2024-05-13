package com.example.e_shopstaff.offlineRepository

import com.example.e_shopstaff.dao.expeditionDao
import com.example.e_shopstaff.data.Expedition
import com.example.e_shopstaff.repository.expeditionRepository
import kotlinx.coroutines.flow.Flow


class offlineExpeditionRepository(private val expeditionDao: expeditionDao) : expeditionRepository {

    override fun getAllExpeditionStream(): Flow<List<Expedition>> = expeditionDao.getAllExpedition()

    override fun getExpeditionStream(id: Int): Flow<Expedition?> = expeditionDao.getExpedition(id)

    override suspend fun insertExpedition(item: Expedition) = expeditionDao.insertExpedition(item)

    override suspend fun deleteExpedition(item: Expedition) = expeditionDao.deleteExpedition(item)

    override suspend fun updateExpedition(item: Expedition) = expeditionDao.updateExpedition(item)

}