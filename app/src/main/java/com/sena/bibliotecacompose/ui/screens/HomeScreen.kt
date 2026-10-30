package com.sena.bibliotecacompose.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sena.bibliotecacompose.R
import com.sena.bibliotecacompose.composable.PrimaryButton

@Composable
fun HomeScreen(
    onViewBooks: () -> Unit,
    onMyReservations: () -> Unit
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Biblioteca Digital",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text("Encuentra tu próximo libro favorito")

            Spacer(modifier = Modifier.height(20.dp))

            Image(
                painter = painterResource(
                    id = R.drawable.library_illustration
                ),
                contentDescription = "Ilustración decorativa de una biblioteca",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(24.dp))

            PrimaryButton(
                text = "Ver libros",
                onClick = onViewBooks
            )

            Spacer(modifier = Modifier.height(12.dp))

            PrimaryButton(
                text = "Mis reservas",
                onClick = onMyReservations
            )
        }
    }
}
