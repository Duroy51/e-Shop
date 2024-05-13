package com.example.e_shopstaff.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal


@Entity
data class lignefacture(
    @PrimaryKey(autoGenerate = true)
    val idLFac: Int = 0,
    val codePro: Int,
    val idFac: Int,
    val prix: Long,
    val qte: Short
)
