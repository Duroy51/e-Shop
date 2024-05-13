package com.example.e_shopstaff

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.e_shopstaff.models.modelSuperAdmin.GestionCategorieViewModel


object AppViewModelProvider {
    val Factory = viewModelFactory {

        initializer {
            this.createSavedStateHandle()
            GestionCategorieViewModel(eShopApplication().container.categorieRepository)
        }
    }
}

fun CreationExtras.eShopApplication(): eShopApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as eShopApplication)