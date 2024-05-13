package com.example.e_shopstaff.data
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.math.BigDecimal


@Entity
data class tontine(

    @PrimaryKey(autoGenerate = true)
    val idTontine: Int=0,
    val dateCotisation: String,
    val montant: Long,
    val commentaire: String,
    val idGest: Int,
    val validite: Boolean,
    val idCarte: Int,
    val action: Boolean
)
