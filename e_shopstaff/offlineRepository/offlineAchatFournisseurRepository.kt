package com.example.e_shopstaff.offlineRepository

import com.example.e_shopstaff.dao.achatFournisseurDao
import com.example.e_shopstaff.repository.achatFournisseurRepository
import com.example.e_shopstaff.data.achatFournisseur
import kotlinx.coroutines.flow.Flow



  class offlineAchatFournisseurRepository(private val achatFournisseurDao: achatFournisseurDao): achatFournisseurRepository {

       override fun getAllAchatFournisseurStream(): Flow<List<achatFournisseur>> = achatFournisseurDao.getAllAchatFournisseur()

       override fun getAchatFournisseurStream(id: Int): Flow<achatFournisseur?> = achatFournisseurDao.getAchatFournisseur(id)

        override suspend fun insertAchatFournisseur(item: achatFournisseur) = achatFournisseurDao.insertAchatFournisseur(item)

        override suspend fun deleteAchatFournisseur(item: achatFournisseur) = achatFournisseurDao.deleteAchatFournisseur(item)

        override suspend fun updateAchatFournisseur(item: achatFournisseur) = achatFournisseurDao.updateAchatFournisseur(item)
}