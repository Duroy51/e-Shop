package com.example.e_shopstaff.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.time.LocalDateTime


@Entity
data class ClientCarte(

    @PrimaryKey(autoGenerate = true)
    val matr: Int=0,
    val nom: String,
    val sexe: Boolean,
    val dateNaiss: String,
    val idVille: Int,
    val mobile: String,
    val whatsapp: Boolean,
    val creation: String,
    val point: Int,
    val montantTontine: Long
)
