package com.example.e_shopstaff.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.e_shopstaff.dao.achatFournisseurDao
import com.example.e_shopstaff.dao.categorieDao
import com.example.e_shopstaff.dao.clientCarteDao
import com.example.e_shopstaff.dao.commandeDao
import com.example.e_shopstaff.dao.expeditionDao
import com.example.e_shopstaff.dao.factureDao
import com.example.e_shopstaff.dao.fournisseurDao
import com.example.e_shopstaff.dao.gestionnaireDao
import com.example.e_shopstaff.dao.gestionstockDao
import com.example.e_shopstaff.dao.influenceurDao
import kotlin.reflect.KParameter

@Database(entities = [
    achatFournisseur::class, ClientCarte::class,
    commande::class, Expedition::class,
facture::class, Fournisseur::class,
gestionnaire::class,
gestionstock::class,
influenceur::class,
    categorie::class,
ligneCarte::class,
lignefacture::class,
messagerie::class,
paieInfluenceur::class],
    version = 1, exportSchema = false
)
abstract class eShopDatabase : RoomDatabase() {

    abstract fun achatFournisseurDao(): achatFournisseurDao
    abstract fun clientCarteDao(): clientCarteDao
    abstract fun commandeDao(): commandeDao
    abstract fun expeditionDao(): expeditionDao
    abstract fun factureDao(): factureDao
    abstract fun fournisseurDao(): fournisseurDao
    abstract fun gestionnaireDao(): gestionnaireDao
    abstract fun gestionstockDao(): gestionstockDao
    abstract fun influenceurDao(): influenceurDao
    abstract fun categorieDao(): categorieDao

    companion object {

        @Volatile
        private var Instance: eShopDatabase? = null

        fun getDatabase(context: Context): eShopDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, eShopDatabase::class.java, "eShopDatabase")
                    .build()
                    .also { Instance = it }
            }
        }
    }
        }

        /*@Volatile
        private var Instance: eShopDatabase? = null
        fun getDatabase(context: Context): eShopDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, eShopDatabase::class.java, "item_database")
                    .build()
                    .also { Instance = it }
            }
        }*/




