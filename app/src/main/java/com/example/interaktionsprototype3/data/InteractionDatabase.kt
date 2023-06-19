package com.example.interaktionsprototype3.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//Database class with a singleton Instance object.
//laver en abstrakt RoomDatabase klasse
//InteractionDatabase er en abstrakt klasse der extender RoomDatabase klassen
//når man ændrer skemaet for database tabellen, så skal versionsnummeret øges
// exportShema=false betyder, at der ikke laves backup af versioner

@Database(entities = [Interaction::class], version = 1, exportSchema = false)
abstract class InteractionDatabase: RoomDatabase() {
    abstract fun interactionDao(): InteractionDao //abstract function that returns the ItemDao so that the database knows about the DAO.

    //companion object allows access to the methods to create or get the database and uses the class name as the qualifier.
    companion object {
        @Volatile //means that changes made by one thread to Instance are immediately visible to all other threads.
        private var Instance: InteractionDatabase? =
            null //a private nullable variable Instance for the database, initialized to null.
        //keeps a reference to the database, when one has been created. This helps maintain a single instance of the database opened at a given time

        fun getDatabase(context: Context): InteractionDatabase {
            // if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                //Pass in the application context, the database class, and a name for the database to the Room.databaseBuilder
                Room.databaseBuilder(
                    context,
                    InteractionDatabase::class.java,
                    "interaction_database"
                )
                    .build()
                    .also { Instance = it }
            }
        }

    }

}
