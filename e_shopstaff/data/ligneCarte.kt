package com.example.e_shopstaff.data

import android.icu.math.BigDecimal
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class ligneCarte(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val idFac: Int,
    val idCarte: Int,
    val point: Int,
    val dateOpera: String,
    val montantFac: Long
)
