
package com.sena.bibliotecacompose.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.bibliotecacompose.model.Reservation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyReservationsScreen(
    onReservationClick: (Int) -> Unit,
    onBack: () -> Unit
) {
    val reservations = listOf(
        Reservation(
            id = 1,
            bookId = 1,
            bookTitle = "Clean Code",
            author = "Robert C. Martin",
            reservationDate = "29/10/2026",
            reservationCode = "RES-001"
        ),
        Reservation(
            id = 2,
            bookId = 2,
            bookTitle = "El programador pragmático",
            author = "Andrew Hunt y David Thomas",
            reservationDate = "30/10/2026",
            reservationCode = "RES-002"
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mis reservas") },
                navigationIcon = {
                    TextButton(onClick = onBack) {
                        Text("Volver")
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(reservations) { reservation ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            onReservationClick(reservation.id)
                        }
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = reservation.bookTitle,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text("Autor: ${reservation.author}")
                        Text("Código: ${reservation.reservationCode}")
                        Text("Fecha: ${reservation.reservationDate}")
                        Text(
                            "Estado: ${
                                if (reservation.isActive) "Activa" else "Cancelada"
                            }"
                        )
                    }
                }
            }
        }
    }
}
