package com.example.e_shopstaff.data
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal
import java.time.LocalDateTime


@Entity
data class achatFournisseur(

    @PrimaryKey(autoGenerate = true)
    val idAchat: Int = 0,
    val lienFac: String,
    val dateInsertion: String,
    val montantFac: Long,
    val montantCargo: Long,
    val totalKg: Long,
    val montantGlobal: Long,
    val idGest: Int,
    val codePro: Int
)

/*{
    init {
        require(idGest >= 0) { "Le paramètre doit être un entier positif." }
        require(codePro >= 0) { "Le paramètre doit être un entier positif." }
        require(idAchat >= 0) { "Le paramètre doit être un entier positif." }
    }
}*/
