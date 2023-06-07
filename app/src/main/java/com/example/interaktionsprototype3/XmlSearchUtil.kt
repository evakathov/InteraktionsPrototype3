package com.example.interaktionsprototype3

import android.content.Context
import android.util.Xml
import org.xmlpull.v1.XmlPullParser
import java.io.InputStream

fun searchInXmlFile(context: Context, fileName: String, query: String): Boolean {
    var inputStream: InputStream? = null
    var parser: XmlPullParser? = null

    try {
        inputStream = context.resources.openRawResource(context.resources.getIdentifier(fileName, "xml", context.packageName))
        parser = Xml.newPullParser()
        parser.setInput(inputStream, null)

        var eventType = parser.eventType
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG && parser.name == "drug") {
                val drugName = parser.getAttributeValue(null, "name")
                val interaction = parser.getAttributeValue(null, "interaction")

                if (drugName.contains(query, ignoreCase = true) || interaction.contains(query, ignoreCase = true)) {
                    // Match found, perform necessary action
                    return true
                }
            }

            eventType = parser.next()
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        inputStream?.close()
    }

    return false
}
