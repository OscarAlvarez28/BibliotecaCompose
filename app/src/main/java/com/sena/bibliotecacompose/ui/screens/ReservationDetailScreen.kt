package com.sena.bibliotecacompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
fun ReservationDetailScreen(
    reservationId: Int,
    onRenew: () -> Unit,
    onBack: () -> Unit
) {
    val reservation = when (reservationId) {
        1 -> Reservation(
            id = 1,
            bookId = 1,
            bookTitle = "Clean Code",
            author = "Robert C. Martin",
            reservationDate = "29/10/2026",
            reservationCode = "RES-001"
        )
        2 -> Reservation(
            id = 2,
            bookId = 2,
            bookTitle = "El programador pragmático",
            author = "Andrew Hunt y David Thomas",
            reservationDate = "30/10/2026",
            reservationCode = "RES-002"
        )
        else -> null
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle de reserva") },
                navigationIcon = {
                    TextButton(onClick = onBack) {
                        Text("Volver")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            if (reservation != null) {
                Text(
                    text = reservation.bookTitle,
                    style = MaterialTheme.typography.headlineSmall
                )
                Text("Autor: ${reservation.author}")
                Text("Código: ${reservation.reservationCode}")
                Text("Fecha de reserva: ${reservation.reservationDate}")
                Text(
                    "Estado: ${
                        if (reservation.isActive) "Activa" else "Cancelada"
                    }"
                )

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = onRenew,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Renovar reserva")
                }

                OutlinedButton(
                    onClick = onBack,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Volver a mis reservas")
                }
            } else {
                Text("No se encontró la reserva.")
            }
        }
    }
}
