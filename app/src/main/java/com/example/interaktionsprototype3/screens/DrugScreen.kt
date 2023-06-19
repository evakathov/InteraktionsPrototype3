package com.example.interaktionsprototype3.screens

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.interaktionsprototype3.MainAppBar
import com.example.interaktionsprototype3.DrugViewModel
import com.example.interaktionsprototype3.MainActivity
import com.example.interaktionsprototype3.SearchWidgetState
import com.example.interaktionsprototype3.R
import com.example.interaktionsprototype3.ResourceUtils
import com.example.interaktionsprototype3.getIDStofByMedicationName


fun reachResourceXML(context: Context) {
    val xmlResourceName = "xml_download"
    val resourceId = ResourceUtils.getXmlResourceIdentifier(context, xmlResourceName)

    if (resourceId != 0) {
        // Tilgå XML filen ved resourceID
        val inputStream = context.resources.openRawResource(resourceId)

        println("du har åbnet xml filen ")
        // Rest of your code
    } else {
        println("XML file not found in res/xml directory.")
    }
}




@Composable
fun DrugScreen(drugViewModel: DrugViewModel) {
    val searchWidgetState by drugViewModel.searchWidgetState
    val searchTextState by drugViewModel.searchTextState
    val medicationNameState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.size(70.dp))
        Text(
            text = "Søg på ét præparat",
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.size(170.dp))

        MainAppBar(
            searchWidgetState = searchWidgetState,
            searchTextState = searchTextState,
            onTextChange = {
                drugViewModel.updateSearchTextState(newValue = it)
            },
            onCloseClicked = {
                drugViewModel.updateSearchWidgetState(newValue = SearchWidgetState.CLOSED)
            },
            onSearchClicked = {
                medicationNameState.value = it
            },
            onSearchTriggered = {
                drugViewModel.updateSearchWidgetState(newValue = SearchWidgetState.OPENED)
            }
        )

        Spacer(modifier = Modifier.size(100.dp))

        performXmlSearch(medicationNameState.value)
        MyImageColumn()
    }
}
@Composable
fun performXmlSearch(medicationName: String) {
    val context: Context = LocalContext.current

    LaunchedEffect(medicationName) {
        val resourceId = context.resources.getIdentifier("xml_download", "raw", context.packageName)
        if (resourceId != 0) {
            val inputStream = context.resources.openRawResource(resourceId)
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

@Composable
fun MyImageColumn() {
    Column() {

        Row(modifier = Modifier.padding(15.dp)) {
            Image(
                painter = painterResource(id = R.drawable.img1),
                contentDescription = "Image1",
                modifier = Modifier
                    .width(60.dp)
            )
            Text(text = "RØD betyder, at kombinationen bør undgås, evt. henvises til forventet klasseeffekt ved mangel på publicerede studier.")

        }
        Row(modifier = Modifier.padding(15.dp)) {
            Image(
                painter = painterResource(id = R.drawable.img2),
                contentDescription = "Image2",
                modifier = Modifier
                    .width(60.dp)
            )
            Text(text = "GUL betyder, at kombinationen kan anvendes med dosisjustering, med forskudt indtagelsestidspunkt, eller hvis der tages visse nærmere beskrevne forholdsregler.")

        }
        Row(modifier = Modifier.padding(15.dp)) {
            Image(
                painter = painterResource(id = R.drawable.img3),
                contentDescription = "Image3",
                modifier = Modifier
                    .width(60.dp)
            )
            Text(text = "GRØN betyder, at kombinationen kan anvendes.")

        }
    }
}

@Composable
@Preview
fun DrugScreenPreview() {
    val drugViewModel: DrugViewModel = viewModel()
    DrugScreen(drugViewModel = drugViewModel)
}


