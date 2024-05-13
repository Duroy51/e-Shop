package com.example.e_shopstaff.offlineRepository

import com.example.e_shopstaff.dao.fournisseurDao
import com.example.e_shopstaff.data.Fournisseur
import com.example.e_shopstaff.repository.fournisseurRepository
import kotlinx.coroutines.flow.Flow



class offlineFournisseurRepository(private val fournisseurDao: fournisseurDao): fournisseurRepository {


    override fun getAllFournisseurStream(): Flow<List<Fournisseur>> = fournisseurDao.getAllFournisseur()

    override fun getFournisseurStream(id: Int): Flow<Fournisseur?> = fournisseurDao.getFournisseur(id)

    override  suspend fun insertFournisseur(item: Fournisseur) = fournisseurDao.insertFournisseur(item)

    override suspend fun deleteFournisseur(item: Fournisseur) = fournisseurDao.deleteFournisseur(item)

    override suspend fun updateFournisseur(item: Fournisseur) = fournisseurDao.updateFournisseur(item)


}