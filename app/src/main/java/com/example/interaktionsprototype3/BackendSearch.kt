package com.example.interaktionsprototype3

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
                val tagName = parser.name
                if (tagName == "Navn") {
                    currentMedication = parser.nextText()
                } else if (tagName == "ID_Stof") {
                    currentIDStof = parser.nextText()
                }
            }
            XmlPullParser.END_TAG -> {
                val tagName = parser.name
                if (tagName == "STOF" && currentMedication == medicationName) {
                    return currentIDStof
                }
            }
        }
        eventType = parser.next()
    }

    xmlInputStream.close()
    return null
}

