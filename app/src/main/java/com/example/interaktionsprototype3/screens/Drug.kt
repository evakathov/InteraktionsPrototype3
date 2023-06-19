package com.example.interaktionsprototype3.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.interaktionsprototype3.MainAppBar
import com.example.interaktionsprototype3.MainViewModel
import com.example.interaktionsprototype3.SearchWidgetState
import com.example.interaktionsprototype3.R
import com.example.interaktionsprototype3.getIDStofByMedicationName

@Composable
fun HomeScreen(mainViewModel: MainViewModel) {
    val searchWidgetState by mainViewModel.searchWidgetState
    val searchTextState by mainViewModel.searchTextState

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
                mainViewModel.updateSearchTextState(newValue = it)
            },
            onCloseClicked = {
                mainViewModel.updateSearchWidgetState(newValue = SearchWidgetState.CLOSED)
            },
            onSearchClicked = {
                //call some function

                Log.d("Searched Text", it)

            },
            onSearchTriggered = {
                mainViewModel.updateSearchWidgetState(newValue = SearchWidgetState.OPENED)
            }
        )

        Spacer(modifier = Modifier.size(100.dp))

        /*Button(onClick = { /*TODO*/ }) {Text(text="Søg", color =Color.Black)
        }*/
        MyImageColumn()

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
fun HomeScreenPreview() {
    val mainViewModel: MainViewModel = viewModel()
    HomeScreen(mainViewModel = mainViewModel)
}


