package com.example.interaktionsprototype3.data

import android.content.Context
import java.io.InputStream

// dataadgangsklasse der håndterer adgangen til XML-filen
// ¨Context¨ bruges til at få adgang til resourcerne

class InteractionsRepository (private val context: Context) {
    fun getInteractionsXmlInputStream(): InputStream {
        val xmlResourceId = context.resources.getIdentifier("interactions", "xml", context.packageName)
        return context.resources.openRawResource(xmlResourceId)
    }
}