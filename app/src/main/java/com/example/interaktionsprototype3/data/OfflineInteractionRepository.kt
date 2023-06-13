package com.example.interaktionsprototype3.data

import kotlinx.coroutines.flow.Flow

class OfflineInteractionRepository(private val interactionDao: InteractionDao): InteractionRepository {
    override fun getAllItemsStream(): Flow<List<Interaction>> = interactionDao.getAllItems()
    override fun getItemStream(id: Int): Flow<Interaction?> = interactionDao.getItem(id)
    override suspend fun insertItem(item: Interaction) = interactionDao.insert(item)
    override suspend fun deleteItem(item: Interaction) = interactionDao.delete(item)
    override suspend fun updateItem(item: Interaction) = interactionDao.update(item)
}