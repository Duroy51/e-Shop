package com.example.e_shopstaff.offlineRepository

import com.example.e_shopstaff.dao.gestionnaireDao
import com.example.e_shopstaff.data.gestionnaire
import com.example.e_shopstaff.repository.gestionnaireRepository
import kotlinx.coroutines.flow.Flow

class offlineGestionnaireRepository(private val gestionnaireDao: gestionnaireDao):
    gestionnaireRepository {

    override fun getAllGestionnaireStream(): Flow<List<gestionnaire>> = gestionnaireDao.getAllGestionnaire()

    override fun getGestionnaireStream(id: Int): Flow<gestionnaire?> = gestionnaireDao.getGestionnaire(id)

    override suspend fun insertGestionnaire(item: gestionnaire) = gestionnaireDao.insertGestionnaire(item)

    override suspend fun deleteGestionnaire(item: gestionnaire) = gestionnaireDao.deleteGestionnaire(item)

    override suspend fun updateGestionnaire(item: gestionnaire) = gestionnaireDao.updateGestionnaire(item)
}