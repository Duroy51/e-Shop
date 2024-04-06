package com.example.e_shopstaff.data

data class Utilisateur(
    val numero: String,
    val motDePasse: String

)

val ListeCaissier = mutableListOf<Utilisateur>(
    Utilisateur("1", motDePasse = "c"),
)

val ListeSuperAdmin = mutableListOf<Utilisateur>(
    Utilisateur("1", motDePasse = "s"),
)

val ListeMagasinier = mutableListOf<Utilisateur>(
    Utilisateur("1", motDePasse = "m"),
)
