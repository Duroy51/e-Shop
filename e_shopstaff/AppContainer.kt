package com.example.e_shopstaff

import android.content.Context
import com.example.e_shopstaff.data.categorie
import com.example.e_shopstaff.data.eShopDatabase
import com.example.e_shopstaff.offlineRepository.offlineAchatFournisseurRepository
import com.example.e_shopstaff.offlineRepository.offlineCategorieRepository
import com.example.e_shopstaff.offlineRepository.offlineClientCarteRepository
import com.example.e_shopstaff.offlineRepository.offlineCommandeRepository
import com.example.e_shopstaff.offlineRepository.offlineExpeditionRepository
import com.example.e_shopstaff.offlineRepository.offlineFactureRepository
import com.example.e_shopstaff.offlineRepository.offlineFournisseurRepository
import com.example.e_shopstaff.offlineRepository.offlineGestionnaireRepository
import com.example.e_shopstaff.offlineRepository.offlineInfluenceurRepository
import com.example.e_shopstaff.repository.achatFournisseurRepository
import com.example.e_shopstaff.repository.categorieRepository
import com.example.e_shopstaff.repository.clientCarteRepository
import com.example.e_shopstaff.repository.commandeRepository
import com.example.e_shopstaff.repository.expeditionRepository
import com.example.e_shopstaff.repository.factureRepository
import com.example.e_shopstaff.repository.fournisseurRepository
import com.example.e_shopstaff.repository.gestionnaireRepository
import com.example.e_shopstaff.repository.influenceurRepository

interface AppContainer {
    val achatFournisseurRepository: achatFournisseurRepository
    val clientCarteRepository: clientCarteRepository
    val commandeRepository: commandeRepository
    val expeditionRepository: expeditionRepository
    val factureRepository: factureRepository
    val fournisseurRepository: fournisseurRepository
    val gestionnaireRepository: gestionnaireRepository
    val influenceurRepository: influenceurRepository
    val categorieRepository: categorieRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineItemsRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [ItemsRepository]
     */
    override val achatFournisseurRepository: achatFournisseurRepository by lazy {
        offlineAchatFournisseurRepository(eShopDatabase.getDatabase(context).achatFournisseurDao())
    }

    override val clientCarteRepository: clientCarteRepository by lazy {
        offlineClientCarteRepository(eShopDatabase.getDatabase(context).clientCarteDao())
    }

    override val commandeRepository: commandeRepository by lazy {
        offlineCommandeRepository(eShopDatabase.getDatabase(context).commandeDao())
    }

    override val expeditionRepository: expeditionRepository by lazy {
        offlineExpeditionRepository(eShopDatabase.getDatabase(context).expeditionDao())
    }

    override val factureRepository: factureRepository by lazy {
        offlineFactureRepository(eShopDatabase.getDatabase(context).factureDao())
    }

    override val fournisseurRepository: fournisseurRepository by lazy {
        offlineFournisseurRepository(eShopDatabase.getDatabase(context).fournisseurDao())
    }

    override val gestionnaireRepository: gestionnaireRepository by lazy {
        offlineGestionnaireRepository(eShopDatabase.getDatabase(context).gestionnaireDao())
    }

    override val influenceurRepository: influenceurRepository by lazy {
        offlineInfluenceurRepository(eShopDatabase.getDatabase(context).influenceurDao())
    }

    override val categorieRepository: categorieRepository by lazy {
        offlineCategorieRepository(eShopDatabase.getDatabase(context).categorieDao())
    }
}