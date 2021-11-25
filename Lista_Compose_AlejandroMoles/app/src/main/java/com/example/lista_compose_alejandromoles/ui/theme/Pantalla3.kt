package com.example.lista_compose_alejandromoles.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun Pantalla3(autor: String, compania: String, descripcion: String) {

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color(118, 115, 114))
    ) {
            Text(text = "AUTOR : ",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline,
                color = Color(255, 0, 50),
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .fillMaxWidth(),)

            Text(
                text = autor,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 15.dp)

            )
            Text(text = "COMPAÑIA : ",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                textDecoration = TextDecoration.Underline,
                color = Color(255, 0, 50),
                fontFamily = FontFamily.Serif,
                modifier = Modifier
                    .fillMaxWidth(),)

            Text(
                text = compania,
                fontSize = 25.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
            )

        Text(
            text = descripcion,
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.SansSerif,
            //color = Color(130, 62, 70),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)

        )
    }
}