package com.example.e_shopstaff.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class lignecommande(

    @PrimaryKey(autoGenerate = true)
    val idLigneCom: Int = 0,
    val idCommande: Int,
    val codePro: Int,
    val quantite: Int,
    val taille:String,
    val couleur: String,
    val disponible: Boolean
)
