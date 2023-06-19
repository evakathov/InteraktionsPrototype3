package com.example.interaktionsprototype3.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

//DAO klasse
@Dao
interface InteractionDao {
    //metode til at søge efter ét præparat i databasen og dets interaktioner med andre præparater
    @Query("SELECT * from interaction WHERE stofA = :stofA")
    fun getDrug(stofA: String): Flow<Interaction> //With Flow as the return type, you receive notification whenever the data in the database changes.

    //metode til at søge efter interaktioner mellem to præparater, stofA og stofB
    @Query("SELECT * from interaction WHERE stofA = :stofA AND stofB = :stofB")
    fun getInteraction(stofA:String, stofB:String): Flow<List<Interaction>>


}




