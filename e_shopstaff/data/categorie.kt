package com.example.e_shopstaff.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class categorie (
    @PrimaryKey(autoGenerate = true)
    val idCat: Int = 0,
    val nomCat: String ,
)






val categorietest = categorie(1, " Vetement Homme")
val categories = mutableListOf<categorie>(
    categorie(1, "Vetement Homme1"),
    categorie(2, "Vetement Homme2"),
    categorie(3, "Vetement Homme3"),
    categorie(4, "Vetement Homme4"),
    categorie(5, "Vetement Homme5"),
    categorie(6, "Vetement Homme6"),
    categorie(7, "Vetement Homme7"),
)