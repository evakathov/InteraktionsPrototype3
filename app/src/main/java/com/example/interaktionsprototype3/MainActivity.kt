package com.example.interaktionsprototype3

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.example.interaktionsprototype3.ui.theme.InteraktionsPrototype3Theme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            InteraktionsPrototype3Theme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    //color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }

        }
/*
        //Tester adgang til XML fil
        val resourceId = resources.getIdentifier("xml_download", "raw", packageName)
        if (resourceId != 0) {
            println("XML file found in res/raw directory.")
        } else {
            println("XML file not found in res/raw directory.")
        }
*/
/*
        //Tester søg af præparatnavn i XML fil
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
 */

    }
}





