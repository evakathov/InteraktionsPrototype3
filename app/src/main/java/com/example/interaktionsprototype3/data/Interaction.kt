package com.example.interaktionsprototype3.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//Entity data class


@Entity
data class Interaction(
    //autoGenerate sikrer at id er unikt  for at hvert item
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val stofA: String,
    val stofB: String,
    val dokumentationsgrad: String,
    val kliniskBetydning: String,
    val rekommandation: String,
    val forholdsregler: String,
    val problemer: String
)
