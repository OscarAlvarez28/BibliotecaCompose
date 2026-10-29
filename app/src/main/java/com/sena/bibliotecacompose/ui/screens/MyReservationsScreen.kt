
package com.sena.bibliotecacompose.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.bibliotecacompose.model.Reservation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyReservationsScreen(
    reservations: List<Reservation>,
    onReservationClick: (Int) -> Unit,
    onBack: () -> Unit
) {
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

        if (reservations.isEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text("Todavía no tienes reservas.")
                Text("Ve al catálogo y reserva un libro.")
            }
        } else {
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
                            Text("Fecha de reserva: ${reservation.reservationDate}")
                            Text("Fecha límite: ${reservation.dueDate}")

                            Text(
                                if (reservation.isActive) {
                                    "Estado: Activa"
                                } else {
                                    "Estado: Inactiva"
                                }
                            )

                            Text("Toca para ver los detalles →")
                        }
                    }
                }
            }
        }
    }
}
