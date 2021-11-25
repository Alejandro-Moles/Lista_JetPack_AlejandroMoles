package com.example.lista_compose_alejandromoles

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

@Composable
fun Pantalla2(nombre: String, descripcion: String, url:String, nota : Float, generos : String) {

    Column (
        modifier = Modifier
            .fillMaxHeight()
            .background(Color.Gray)
    ){
        cargarImagen(url = url)

        Text(
            text = nombre,
            fontSize= 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 15.dp)

        )

        Text(
            text = descripcion,
            fontSize= 20.sp,
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .padding(bottom=20.dp)


        )

        Text(text = "VALORACION : " +nota,
            fontSize= 25.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif,
            color = Color(130,62,70),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)

        )

        Text(text = "GENEROS : " +generos,
            fontSize= 25.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif,
            color = Color(130,62,70),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)

        )


    }
    @Composable
    fun cargarImagen(url: String) {
        Image(
            painter = rememberImagePainter(url),
            contentDescription = "Imagen",
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .height(200.dp),

            contentScale = ContentScale.FillWidth
        )
    }


}