package com.example.e_shopstaff.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ville(
    @PrimaryKey(autoGenerate = true)
    val idVille: Int =0,
    val libelle: String
)
