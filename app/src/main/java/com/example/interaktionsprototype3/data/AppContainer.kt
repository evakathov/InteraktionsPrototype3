package com.example.interaktionsprototype3.data

import android.content.Context

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val interactionRepository: InteractionRepository
}
/**
 * [AppContainer] implementation that provides instance of [OfflineInteractionRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [InteractionRepository]
     */
    override val interactionRepository: InteractionRepository by lazy {
        OfflineInteractionRepository(InteractionDatabase.getDatabase(context).interactionDao())
    }
}
