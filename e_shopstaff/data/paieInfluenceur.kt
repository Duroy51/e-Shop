package com.example.e_shopstaff.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.time.LocalDateTime


@Entity
data class paieInfluenceur(
    @PrimaryKey(autoGenerate = true)
    val idPaiement: Int=0,
    val datePaie: String,
    val montant: Long,
    val idInf: Int,
    val validite: Boolean,
    val commentaire: String
)
