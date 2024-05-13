package com.example.e_shopstaff.models.modelSuperAdmin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.e_shopstaff.dao.categorieDao
import com.example.e_shopstaff.data.categorie
import com.example.e_shopstaff.eShopApplication
import com.example.e_shopstaff.repository.categorieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class GestionCategorieViewModel(private val categorieRepository: categorieRepository) : ViewModel() {


    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val gestionCategorieUiState: StateFlow<GestionCategorieUiState> =
        categorieRepository.getAllCategorieStream().map { GestionCategorieUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = GestionCategorieUiState()
            )

}

data class GestionCategorieUiState(val categories: List<categorie> = listOf())