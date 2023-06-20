package com.example.interaktionsprototype3.screens
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.interaktionsprototype3.CustomSurface


@Composable
fun InteractionScreen() {

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
        CustomSurface {
            TextField(
                value = "Skriv præparat 1...",
                onValueChange = {
                },
                modifier = Modifier.padding(horizontal = 16.dp),
                leadingIcon = {
                    IconButton(
                        modifier = Modifier
                            .alpha(ContentAlpha.medium),
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Search Icon",
                            tint = Color.White
                        )
                    }
                }
            )
        }
        Spacer(modifier = Modifier.size(20.dp))

        CustomSurface {
            TextField(
                value = "Skriv præparat 2...",
                onValueChange = {
                },
                modifier = Modifier.padding(horizontal = 16.dp),
                leadingIcon = {
                    IconButton(
                        modifier = Modifier
                            .alpha(ContentAlpha.medium),
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Search Icon",
                            tint = Color.White
                        )
                    }
                }
            )
        }
        Button(
            onClick = {
            },
            modifier = Modifier.padding(top = 30.dp).width(70.dp).height(50.dp)
       
        ) {
            Text("Søg")
           
        }
    }
}


@Composable
@Preview
fun InteractionScreenPreview() {

    InteractionScreen()
}