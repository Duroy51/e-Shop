package com.example.e_shopstaff.data


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime



@Entity
data class gestionstock(

    @PrimaryKey(autoGenerate = true)
    val idStock: Int=0,
    val qte: Int,
    val dateStock: String,
    val operation: Boolean,
    val idGest: Int,
    val codePro: Int
)
