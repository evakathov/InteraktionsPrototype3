package com.example.interaktionsprototype3

import androidx.compose.ui.text.toLowerCase
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.InputStream

fun getIDStofByMedicationName(xmlInputStream: InputStream, medicationName: String): String? {
    val factory = XmlPullParserFactory.newInstance()
    val parser = factory.newPullParser()
    parser.setInput(xmlInputStream, null)

    var eventType = parser.eventType
    var currentMedication: String? = null
    var currentIDStof: String? = null

    while (eventType != XmlPullParser.END_DOCUMENT) {
        when (eventType) {
            XmlPullParser.START_TAG -> {
                // søger efter startags der hedder Navn
                val tagName = parser.name
                if (tagName == "Navn") {
                    // tildeler variablen currentMedication værdien af indholdet i Navn tagget med parser.nextText()
                    currentMedication = parser.nextText()
                } else if (tagName == "ID_Stof") {
                    //tildeler variablen currentIDStof værdien af indholdet i ID_Stof tagget
                    currentIDStof = parser.nextText()
                }
            }
            XmlPullParser.END_TAG -> {
                val tagName = parser.name
                //Hvis end tagget er STOF og currentMedication er det samme som det brugerindtastede præparat returner tilsvarende ID_Stof
                if (tagName == "STOF" && currentMedication == medicationName.toLowerCase()) {
                    return currentIDStof
                }
            }
        }
        eventType = parser.next()
    }

    xmlInputStream.close()
    return null
}

