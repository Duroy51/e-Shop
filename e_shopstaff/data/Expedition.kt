package com.example.e_shopstaff.data


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity
data class Expedition(

    @PrimaryKey(autoGenerate = true)
    val idExp: Int = 0,
    val idville: Int,
    val transporteur: String,
    val prix: Long,
    val mobile1: String,
    val mobile2: String
)
