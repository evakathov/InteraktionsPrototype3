package com.example.interaktionsprototype3

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.interaktionsprototype3.ui.theme.InteraktionsPrototype3Theme

import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.WindowCompat
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream



class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            InteraktionsPrototype3Theme {

                //MainScreen(mainViewModel = mainViewModel)
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }


        val resourceId = resources.getIdentifier("xml_download", "raw", packageName)
        if (resourceId != 0) {
            val inputStream = resources.openRawResource(resourceId)

            val medicationName = "diflunisal"

            val idStof = getIDStofByMedicationName(inputStream, medicationName)
            if (idStof != null) {
                println("Medication: $medicationName, ID_Stof: $idStof")
            } else {
                println("Medication not found in XML.")
            }
        } else {
            println("XML file not found in res/raw directory.")
        }


    }
}





/*
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        println("Hello fish!")
*/
        //val resourceId = R.raw.xml_download
        //val inputStream = resources.openRawResource(resourceId)

        /*val resourceId = resources.getIdentifier("xml_download", "raw", packageName)
        if (resourceId != 0) {
            println("XML file found in res/raw directory.")
        } else {
            println("XML file not found in res/raw directory.")
        }

         ###################
        val resourceId = resources.getIdentifier("xml_download", "raw", packageName)
        if (resourceId != 0) {
            val inputStream = resources.openRawResource(resourceId)
            val xmlFile = File.createTempFile("temp", null)
            xmlFile.deleteOnExit()

            inputStream.use { input ->
                FileOutputStream(xmlFile).use { output ->
                    input.copyTo(output)
                }
            }

            val fileLength = xmlFile.length()
            println("XML file length: $fileLength bytes")
        } else {
            println("XML file not found in res/raw directory.")
        }
        #####################*/
/*
        val resourceId = resources.getIdentifier("xml_download", "raw", packageName)
        if (resourceId != 0) {
            val inputStream = resources.openRawResource(resourceId)

            val factory = XmlPullParserFactory.newInstance()
            val parser = factory.newPullParser()
            parser.setInput(inputStream, null)

            var eventType = parser.eventType
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG && parser.name == "STOFFER") {
                    while (eventType != XmlPullParser.END_TAG || parser.name != "STOFFER") {
                        if (eventType == XmlPullParser.START_TAG) {
                            val tagName = parser.name
                            println("Start tag: $tagName")
                        } else if (eventType == XmlPullParser.TEXT) {
                            val text = parser.text
                            if (!text.isNullOrBlank()) {
                                println("Text: $text")
                            }
                        }
                        eventType = parser.next()
                    }
                    // Skip the END_TAG for "Interaktioner"
                    eventType = parser.next()
                } else {
                    eventType = parser.next()
                }
            }

            inputStream.close()
        } else {
            println("XML file not found in res/raw directory.")
        }


        println("HelloWorld")

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


fun getIDStofByMedicationNames(
    xmlInputStream: InputStream,
    medicationName1: String,
    medicationName2: String
): Pair<String?, String?> {
    val factory = XmlPullParserFactory.newInstance()
    val parser = factory.newPullParser()
    parser.setInput(xmlInputStream, null)

    var eventType = parser.eventType
    var currentMedication: String? = null
    var currentIDStof: String? = null

    var idStof1: String? = null
    var idStof2: String? = null

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
                if (tagName == "STOF") {
                    if (currentMedication == medicationName1) {
                        idStof1 = currentIDStof
                    } else if (currentMedication == medicationName2) {
                        idStof2 = currentIDStof
                    }
                }
            }
        }
        eventType = parser.next()
    }

    xmlInputStream.close()
    return Pair(idStof1, idStof2)
}
*/