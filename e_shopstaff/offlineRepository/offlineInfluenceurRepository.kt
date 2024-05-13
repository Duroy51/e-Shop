package com.example.e_shopstaff.offlineRepository

import com.example.e_shopstaff.dao.influenceurDao
import com.example.e_shopstaff.data.gestionstock
import com.example.e_shopstaff.data.influenceur
import com.example.e_shopstaff.repository.influenceurRepository
import kotlinx.coroutines.flow.Flow



class offlineInfluenceurRepository(private val influenceurDao: influenceurDao) : influenceurRepository {

    override fun getAllInfluenceurStream(): Flow<List<influenceur>> = influenceurDao.getAllInfluenceur()

    override fun getInfluenceurStream(id: Int): Flow<influenceur?> = influenceurDao.getInfluenceur(id)

    override suspend fun insertInfluenceur(item: influenceur) = influenceurDao.insertInfluenceur(item)

    override suspend fun deleteInfluenceur(item: influenceur) = influenceurDao.deleteInfluenceur(item)

    override suspend fun  updateInfluenceur(item: influenceur) = influenceurDao.updateInfluenceur(item)
}