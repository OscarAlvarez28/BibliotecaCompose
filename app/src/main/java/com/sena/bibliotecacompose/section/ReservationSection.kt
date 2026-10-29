package com.sena.bibliotecacompose.section

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.bibliotecacompose.model.Reservation

@Composable
fun ReservationSection(
    reservations: List<Reservation>,
    onReservationClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = SectionStyles.screenPadding,
        verticalArrangement = SectionStyles.itemSpacing
    ) {
        items(reservations) { reservation ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onReservationClick(reservation.id) }
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
                    Text(if (reservation.isActive) "Estado: Activa" else "Estado: Inactiva")
                    Text("Toca para ver los detalles →")
                }
            }
        }
    }
}
