package com.example.interaktionsprototype3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.interaktionsprototype3.ui.theme.InteraktionsPrototype3Theme

class MainActivity : ComponentActivity() {

    //private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InteraktionsPrototype3Theme {
                MainScreen()
                //MainScreen(mainViewModel = mainViewModel)
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