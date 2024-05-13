package com.example.e_shopstaff.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.sql.Timestamp


@Entity
data class commande(

    @PrimaryKey(autoGenerate = true)
    /*val dateCom: Timestamp,*/
    val idCommande: Int,
    val montant: Long,
    val nomClient: String,
    val mobile: String,
    val adresse: String,
    val commentaire: String,
    val livrer: Byte,
    val avance: Long,
    val remise: Long,
    val type: Boolean,
    val idVille: Int
)
