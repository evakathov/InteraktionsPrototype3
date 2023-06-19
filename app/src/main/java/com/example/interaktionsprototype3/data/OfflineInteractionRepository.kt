package com.example.interaktionsprototype3.data

import kotlinx.coroutines.flow.Flow

class OfflineInteractionRepository(private val interactionDao: InteractionDao): InteractionRepository {
    override fun getInteractionStream(stofA: String, stofB: String): Flow<List<Interaction>> = interactionDao.getInteraction(stofA,stofB)
    override fun getDrugStream(stofA: String): Flow<Interaction?> = interactionDao.getDrug(stofA)
    //evt. skal det bare være den samme metode, der kan tage ét eller flere parametre
}