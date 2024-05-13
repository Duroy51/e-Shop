package com.example.e_shopstaff.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal



@Entity
data class influenceur(

    @PrimaryKey(autoGenerate = true)
    val idInf: Int=0,
    val nom :String,
    val mobile: String,
    val codePromo: String,
    val actif: Boolean,
    val montant: Long,
    var pwd: String
)
