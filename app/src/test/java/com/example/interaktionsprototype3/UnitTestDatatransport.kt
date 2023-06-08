package com.example.interaktionsprototype3
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.InputStream

class UnitTestDatatransport {
}

    @Test
    fun testInteractionsFileAccess() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val inputStream: InputStream? = context.assets.open("interactions.xml")

        // Test, om filen er åbnet korrekt
        assertEquals(true, inputStream != null)

        // Gør noget med filen eller dens indhold her
        // f.eks. læs og analyser XML-dataene

        // Luk filstrømmen efter brug
        inputStream?.close()
    }
