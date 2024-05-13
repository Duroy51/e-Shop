package com.example.e_shopstaff.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity
data class Fournisseur(

    @PrimaryKey(autoGenerate = true)
    val idFour: Int = 0,
    val nom :String,
    val adresse: String,
    val ville :String,
    val pays: String,
    val mobile1: String,
    val mobile2: String,
    val dateCreation: String,
    val type: Boolean
)