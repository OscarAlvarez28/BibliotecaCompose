package com.sena.bibliotecacompose.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.bibliotecacompose.data.BookRepository

@Composable
fun ReservationSuccessScreen(
    bookId: Int,
    onGoToReservations: () -> Unit,
    onBackHome: () -> Unit
) {
    val book = BookRepository.getBookById(bookId)

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "¡Reserva exitosa!",
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text("Tu solicitud de reserva fue registrada.")

            book?.let {
                Text("Libro: ${it.title}")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = onGoToReservations,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Ver mis reservas")
            }

            OutlinedButton(
                onClick = onBackHome,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Volver al inicio")
            }
        }
    }
}