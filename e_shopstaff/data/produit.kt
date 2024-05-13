package com.example.e_shopstaff.data

import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID
import kotlin.random.Random

data class produit(
    val codePro: Int ,
    val nomPro: String,
    val description: String,
    val idCategorie: Int,
    val prix: Double,
    val qte: UInt,
    val size1: Int,
    val size2: Int,

)

fun generateSixDigitCode(): Int {
    // Génère un nombre aléatoire entre 100000 et 999999
    return Random.nextInt(from = 100000, until = 1000000).toInt()
}


val produitTest = produit(nomPro = "Habit", description = "une description",  idCategorie = 1, codePro = 11, prix =15000.0, qte = 15u, size1= 10, size2 = 40)
val produits  = mutableListOf<produit>(
    produit(nomPro = "habit", description = "une description",  idCategorie = 1, codePro = 11, prix = 15000.0, qte = 15u, size1 = 10, size2 = 40 ),
    produit(nomPro = "habit", description = "une description",  idCategorie = 1, codePro = 12, prix = 15000.0,qte = 15u, size1 = 10, size2 = 40  ),
    produit(nomPro = "habit", description = "une description",  idCategorie = 2, codePro = 13, prix = 15000.0, qte = 15u, size1= 10, size2 = 40),
    produit(nomPro = "habit", description = "une description",  idCategorie = 1, codePro = 14, prix = 15000.0, qte = 15u, size1= 10, size2 = 40 ),
    produit(nomPro = "habit", description = "une description",  idCategorie = 2, codePro = 15, prix = 15000.0, qte = 15u, size1= 10, size2 = 40 ),
    produit(nomPro = "habit", description = "une description",  idCategorie = 2, codePro = 16, prix = 15000.0, qte = 15u,size1= 10, size2 = 40  ),
    produit(nomPro = "habit", description = "une description",  idCategorie = 1, codePro = 17, prix = 15000.0, qte = 15u, size1= 10, size2 = 40 ),
    produit(nomPro = "habit", description = "une description",  idCategorie = 2, codePro = 18, prix = 15000.0, qte = 15u, size1= 10, size2 = 40 ),
    produit(nomPro = "habit", description = "une description",  idCategorie = 3, codePro = 19, prix = 15000.0, qte = 15u, size1= 10, size2 = 40 ),
    produit(nomPro = "habit", description = "une description",  idCategorie = 3, codePro = 20, prix = 15000.0, qte = 15u, size1= 10, size2 = 40 ),
    produit(nomPro = "habit", description = "une description",  idCategorie = 3, codePro = 21, prix = 15000.0,qte = 15u, size1= 10, size2 = 40  ),
)