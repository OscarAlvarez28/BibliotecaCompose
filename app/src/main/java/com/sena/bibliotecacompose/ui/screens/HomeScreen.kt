package com.sena.bibliotecacompose.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import com.sena.bibliotecacompose.composable.PrimaryButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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