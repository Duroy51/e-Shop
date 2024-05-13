package com.example.e_shopstaff.offlineRepository

import com.example.e_shopstaff.dao.gestionstockDao
import com.example.e_shopstaff.data.gestionstock
import com.example.e_shopstaff.repository.gestionStockRepository
import kotlinx.coroutines.flow.Flow


class offlineGestionStockRepository(private val gestionstockDao: gestionstockDao) : gestionStockRepository {

    override fun getAllGestionStockStream(): Flow<List<gestionstock>> = gestionstockDao.getAllGestionStock()

    override fun getGestionStockStream(id: Int): Flow<gestionstock?> = gestionstockDao.getGestionStock(id)

    override suspend fun insertGestionStock(item: gestionstock) = gestionstockDao.insertGestionStock(item)

    override suspend fun deleteGestionStock(item: gestionstock) = gestionstockDao.deleteGestionStock(item)

    override suspend fun updateGestionStock(item: gestionstock) = gestionstockDao.updateGestionStock(item)
}