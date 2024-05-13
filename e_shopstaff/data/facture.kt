package com.example.e_shopstaff.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.time.LocalDateTime


@Entity
data class facture(
    @PrimaryKey(autoGenerate = true)
    val idFac: Int=0,
    /*val dateFac: LocalDateTime,*/
    val remise: Long,
    val montant: Long,
    val tel: String,
    val tupeFac: Short,
    val idCaissire: Int,
    val capital: Long,
    val tva: Long,
    val codePromo: String
)
