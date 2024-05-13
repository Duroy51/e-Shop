package com.example.e_shopstaff.offlineRepository

import com.example.e_shopstaff.dao.factureDao
import com.example.e_shopstaff.data.facture
import com.example.e_shopstaff.repository.factureRepository
import kotlinx.coroutines.flow.Flow


class offlineFactureRepository(private val factureDao: factureDao): factureRepository {

    override fun getAllFactureStream(): Flow<List<facture>> = factureDao.getAllFacture()

    override fun getFactureStream(id: Int): Flow<facture?> = factureDao.getFacture(id)

    override suspend fun insertFacture(item: facture) = factureDao.insertFacture(item)

    override suspend fun deleteFacture(item: facture) = factureDao.deleteFacture(item)

    override suspend fun updateFacture(item: facture) = factureDao.updateFacture(item)

}