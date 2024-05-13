package com.example.e_shopstaff.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime


@Entity
data class messagerie(
    @PrimaryKey(autoGenerate = true)
    val idmsg: Int = 0,
    val mobile: String,
    val wsms: String,
    val dateEnvoie: String,
    val type: Int,
    val service: Int
)
