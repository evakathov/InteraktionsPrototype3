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
    @Insert(onConflict = OnConflictStrategy.IGNORE) //OnConflictStrategy sættes til ignorer, fordi der ikke kan opstå kodekonflikter, da der kun kan indsættes data ét sted i app'en
    suspend fun insert(interaction: Interaction) //indsæt metode der tager en instans af Entitets klassen Interaction som parameter

    @Update
    suspend fun update(interaction: Interaction) //suspend gør at Room flytter arbejdet "arbejdet" til en background thread

    @Delete
    suspend fun delete(interaction: Interaction)

    @Query("SELECT * from interaction WHERE id = :id")
    fun getItem(id: Int): Flow<Interaction> //With Flow as the return type, you receive notification whenever the data in the database changes.

    @Query("SELECT * from interaction ORDER BY id ASC")
    fun getAllItems(): Flow<List<Interaction>> //Room keeps this Flow updated for you, which means you only need to explicitly get the data once.
    //denne metode giver en notifikation, når data i databasen ændres

}




