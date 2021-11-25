package com.example.lista_compose_alejandromoles

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lista_compose_alejandromoles.ui.theme.Pantalla3

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun Navegacion(navController : NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "PrimeraPantalla"
    )
    {
        composable("PrimeraPantalla") { Home(navController) }
        composable("SegundaPantalla/{nombre}/{descripcion}/{url}/{nota}/{generos}",
            arguments = listOf(navArgument("nombre"){
                type= NavType.StringType
            },
                navArgument("descripcion"){
                    type= NavType.StringType
                },
                navArgument("url"){
                    type= NavType.StringType
                },
                navArgument("nota"){
                    type= NavType.FloatType
                },
                navArgument("generos"){
                    type = NavType.StringType
                })
        ) { navBackStackEntry ->
            Pantalla2(navBackStackEntry.arguments?.getString("nombre")!!,navBackStackEntry.arguments?.getString("descripcion")!!,navBackStackEntry.arguments?.getString("url")!!,navBackStackEntry.arguments?.getFloat("nota")!!,navBackStackEntry.arguments?.getString("generos")!!)
        }
        composable("TerceraPantalla/{autor}/{compania}/{descrip}",
            arguments = listOf(navArgument("autor"){
                type = NavType.StringType
            },
            navArgument("compania"){
                type = NavType.StringType
            },
            navArgument("descrip"){
                type = NavType.StringType
            })
        ){  navBackStackEntry ->
            Pantalla3(navBackStackEntry.arguments?.getString("autor")!!,navBackStackEntry.arguments?.getString("compania")!!,navBackStackEntry.arguments?.getString("descrip")!!)
        }
    }
}