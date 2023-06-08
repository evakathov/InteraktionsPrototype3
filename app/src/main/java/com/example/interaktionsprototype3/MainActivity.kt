package com.example.interaktionsprototype3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.interaktionsprototype3.ui.theme.InteraktionsPrototype3Theme
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.example.interaktionsprototype3.data.ViewModelInteractions

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InteraktionsPrototype3Theme {
                MainScreen()
                // A surface container using the 'background' color from the theme
                /*Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    //tilføj MainScreen() her evt. når det virker
                }*/
            }
        }
    }
}

/*@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    InteraktionsPrototype3Theme {
        Greeting("Android")
    }
}*/

class MyActivity : AppCompatActivity() {
    private lateinit var viewModel: ViewModelInteractions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialiser ViewModel (f.eks. ved hjælp af ViewModelProvider)

        val xmlData = viewModel.getInteractionsXmlData()
        // Brug XML-dataene efter behov
    }
}