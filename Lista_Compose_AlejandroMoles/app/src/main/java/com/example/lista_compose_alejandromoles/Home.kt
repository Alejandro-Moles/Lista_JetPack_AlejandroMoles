package com.example.lista_compose_alejandromoles

import android.annotation.SuppressLint
import android.content.Context
import android.text.style.BackgroundColorSpan
import android.widget.Toast
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.lista_compose_alejandromoles.Modelo.Juegos

@ExperimentalAnimationApi
@SuppressLint("RememberReturnType")
@ExperimentalFoundationApi
@Composable
fun Home(navController: NavController) {

    fun navegacion(juegos: Juegos) {
        navController.navigate("SegundaPantalla/${juegos.nombre}/${juegos.descripcion}/${juegos.url}/${juegos.nota}/${juegos.genero}")
    }
    fun navegacion2(juegos: Juegos){
        navController.navigate("TerceraPantalla/${juegos.autor}/${juegos.compania}/${juegos.descripComp}")
    }

    fun borrar(juegos: Juegos, ListaJuegos:MutableList<Juegos>, context: Context){
        ListaJuegos.remove(juegos)
        Toast.makeText(context, "Borrado el juego " + juegos.nombre, Toast.LENGTH_SHORT).show()
    }


    Column(
        modifier = Modifier.padding(16.dp)
            .fillMaxSize()
            .background(Color(76, 66, 63))
    )
    {
        textoInicio(titulo = "Lista de Videojuegos")
        val context = LocalContext.current
        val deletedItem = remember { mutableStateListOf<Juegos>()}

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(76, 66, 63))
        ){
            itemsIndexed(
                items = RellenarArray(),
                itemContent = {_,juego ->
                    AnimatedVisibility(visible = !deletedItem.contains(juego), enter = expandVertically(),
                        exit = shrinkHorizontally(animationSpec = tween(durationMillis = 700))
                    ) {

                        Card(
                            modifier = Modifier
                                .combinedClickable(
                                    onClick = {
                                        navegacion(juego)
                                    },
                                    onLongClick = {
                                        navegacion2(juego)
                                    })
                                .fillMaxWidth()
                            ) {
                                Column(modifier = Modifier.fillMaxWidth()) {
                                    Row(
                                        modifier = Modifier.fillMaxWidth()
                                            .background(Color(156, 52, 52)),
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically
                                    ){
                                        cargarTexto(nombre = juego.nombre)
                                        IconButton(onClick={
                                            borrar(juego, RellenarArray(), context)
                                            deletedItem.add(juego)
                                        }){
                                            Icon(imageVector = Icons.Filled.Delete, contentDescription = "Borrar")
                                        }
                                    }

                                    cargarImagen(url = juego.url)
                                }
                            }
                        }
                    }
                )
            }
        }

    }

fun RellenarArray(): MutableList<Juegos> {
    var juego1 = Juegos(
            "https://areajugones.sport.es/wp-content/uploads/2016/04/original-9-1560x880.jpg".replace("/","\\"),
       "Dark Soul 3",
        "-El jugador asume el control en tercera persona de un personaje llamado Ser de la Ceniza, a quien se le encomienda la tarea de ‘enlazar’ a la Primera Llama para que siga encendida. La llama se alimenta de los sacrificios de héroes y campeones, quienes sacrifican sus almas por la llama voluntariamente, convirtiéndose así en Señores de la Ceniza.",
        9.1F,
        "Rol-Accion",
        "Hidetaka Miyazaki",
        "From Software",
        "FromSoftware, Inc. es una compañía japonesa de videojuegos fundada en noviembre de 1986 conocida principalmente por ser los creadores de las series Armored Core, Demon's Souls, King's Field, Otogi, Tenchu, Dark Souls, Bloodborne y Sekiro: Shadows Die Twice"
    )
    var juego2 = Juegos(
        "https://fondosmil.com/fondo/5058.jpg".replace("/","\\"),
        "League of Legends",
        "-League of Legends es un juego de estrategia por equipos en el que dos equipos de cinco campeones se enfrentan para ver quién destruye antes la base del otro. Elige de entre un elenco de 140 campeones para realizar jugadas épicas, asesinar rivales y derribar torretas para alzarte con la victoria.",
        7.2F,
        "MOBA",
        "Graham McNeill",
        "Riot Games",
        "Riot Games, Inc. es una desarrolladora y editora de videojuegos y organizador de torneos de deportes electrónicos estadounidense con sede en West Los Angeles, California. La empresa se fundó en septiembre de 2006 para desarrollar League of Legends, un videojuego multijugador de arena de batalla en línea."
    )

    var juego3 = Juegos(
        "https://e00-marca.uecdn.es/assets/multimedia/imagenes/2019/12/20/15768710649696.jpg".replace("/","\\"),
        "Minecraft",
        "Minecraft es un videojuego de mundo abierto donde la exploración y las construcciones son fundamentales. ... Al ser un videojuego de mundo abierto, no tiene una misión concreta (salvo alguno de sus modos de juego) y consiste en la construcción libre mediante el uso de cubos con texturas tridimensionales.",
        9.2F,
        "Mundo Abierto",
        "Markus Persson",
        "Mojang Studios",
        "Mojang Studios es un desarrollador de videojuegos sueco y un estudio de Xbox Game Studios con sede en Estocolmo. El estudio fue fundado por Markus Persson en 2009 como Mojang Specifications, heredando el nombre de una empresa del mismo nombre que dejó dos años antes."
    )

    var juego4 = Juegos(
        "https://cdn02.nintendo-europe.com/media/images/10_share_images/games_15/nintendo_ds_22/H2x1_NDS_PokemonPlatinum_esES.jpg".replace("/","\\"),
        "Pokemon Platino",
        "El juego contiene varias mejoras con respecto a Diamante y Perla: El Poké-reloj tendrá nuevo aspecto y nuevas funciones. La Pokédex pasa a tener 210 Pokémon, siendo Giratina el último. En algunos Centros Pokémon habrá batallas todos los días de la semana en ciertas ciudades.",
        8.0F,
        "Jrol-Videojuego de Aventura",
        "Junichi Masuda",
        "Game Freak",
        "Game Freak es una empresa japonesa desarrolladora de videojuegos fundada en abril de 1989 por Satoshi Tajiro. Desde su fundación, Game Freak ha desarrollado más de veinte títulos para empresas como Hudson, Sony, Sega, NEC y Nintendo, desarrollando para esta última sus productos más exitosos: la serie de juegos Pokémon para Game Boy, Game Boy Color, Game Boy Advance, Nintendo DS, Nintendo 3DS y Nintendo Switch los cuales se han vendido hasta finales de 2016 más de 280.000.000 de unidades, sin contar los años posteriores."
    )

    var ListaJuegos: MutableList<Juegos> = mutableListOf(juego1, juego2, juego3, juego4)
    return ListaJuegos
}


@Composable
fun cargarImagen(url: String) {
    Image(
        painter = rememberImagePainter(url),
        contentDescription = "Imagen",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp),

        contentScale = ContentScale.FillWidth
    )
}

@Composable
fun cargarTexto(nombre: String) {
    Text(
        text = nombre,
        textAlign = TextAlign.Center,
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        modifier = Modifier
            .background(Color(156, 52, 52))


    )
}

@Composable
fun textoInicio(titulo: String) {
    Text(
        text = titulo,
        fontSize = 35.sp,
        fontFamily = FontFamily.SansSerif,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        modifier = Modifier
            .padding(7.dp)
            .fillMaxWidth()
    )
}

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun PreviewGreeting() {
    Home(
        navController = rememberNavController()
    )
}