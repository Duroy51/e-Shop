package com.example.e_shopstaff.offlineRepository

import com.example.e_shopstaff.dao.achatFournisseurDao
import com.example.e_shopstaff.dao.categorieDao
import com.example.e_shopstaff.data.achatFournisseur
import com.example.e_shopstaff.data.categorie
import com.example.e_shopstaff.repository.achatFournisseurRepository
import com.example.e_shopstaff.repository.categorieRepository
import kotlinx.coroutines.flow.Flow

class offlineCategorieRepository(private val categorieDao: categorieDao):
    categorieRepository {

    override fun getAllCategorieStream(): Flow<List<categorie>> = categorieDao.getAllCategorie()

    override fun getCategorieStream(id: Int): Flow<categorie?> = categorieDao.getCategorie(id)

    override suspend fun insertCategorie(item: categorie) = categorieDao.insertCategorie(item)

    override suspend fun deleteCategorie(item: categorie) = categorieDao.deleteCategorie(item)

    override suspend fun updateCategorie(item: categorie) = categorieDao.updateCategorie(item)}