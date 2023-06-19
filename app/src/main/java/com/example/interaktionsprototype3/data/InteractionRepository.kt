package com.example.interaktionsprototype3.data
import kotlinx.coroutines.flow.Flow
//Repository that provides retrieve of [Interaction] from a given data source.

interface InteractionRepository {
    /**
     * Retrieve interaction between two drugs from the the given data source.
     */
    fun getInteractionStream(stofA: String, stofB: String): Flow<List<Interaction>>

    /**
     * Retrieve a drug with all its interaction from the given data source that matches with the [stofA].
     */
    fun getDrugStream(stofA: String): Flow<Interaction?>
}