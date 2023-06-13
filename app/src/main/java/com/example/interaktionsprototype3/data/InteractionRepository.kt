package com.example.interaktionsprototype3.data
import kotlinx.coroutines.flow.Flow
//Repository that provides insert, update, delete, and retrieve of [Interaction] from a given data source.
interface InteractionRepository{
    /**
     * Retrieve all the items from the the given data source.
     */
    fun getAllItemsStream(): Flow<List<Interaction>>

    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
    fun getItemStream(id: Int): Flow<Interaction?>

    /**
     * Insert interaction in the data source
     */
    suspend fun insertItem(interaction: Interaction)

    /**
     * Delete item from the data source
     */
    suspend fun deleteItem(item: Interaction)

    /**
     * Update item in the data source
     */
    suspend fun updateItem(item: Interaction)
}