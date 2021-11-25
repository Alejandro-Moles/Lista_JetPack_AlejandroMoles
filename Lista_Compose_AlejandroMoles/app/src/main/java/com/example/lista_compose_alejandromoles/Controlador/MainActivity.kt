package com.example.lista_compose_alejandromoles.Controlador

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.lista_compose_alejandromoles.Home
import com.example.lista_compose_alejandromoles.Navegacion
import com.example.lista_compose_alejandromoles.ui.theme.Lista_Compose_AlejandroMolesTheme

class MainActivity : ComponentActivity() {
    lateinit var navControler: NavHostController

    @ExperimentalAnimationApi
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lista_Compose_AlejandroMolesTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = Color(76, 66, 63)) {
                    navControler = rememberNavController()
                    Navegacion(navController = navControler)

                }
            }
        }
    }
}

