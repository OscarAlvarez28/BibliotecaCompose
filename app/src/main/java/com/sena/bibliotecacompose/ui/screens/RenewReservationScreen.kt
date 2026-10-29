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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RenewReservationScreen(
    reservationId: Int,
    onRenewed: () -> Unit,
    onBack: () -> Unit
) {
    val selectedDays = remember { mutableStateOf(7) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Renovar reserva") },
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
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Reserva #$reservationId",
                style = MaterialTheme.typography.titleLarge
            )

            Text("Selecciona el tiempo adicional:")

            listOf(7, 14, 21).forEach { days ->
                OutlinedButton(
                    onClick = { selectedDays.value = days },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = if (selectedDays.value == days) {
                            "✓ $days días"
                        } else {
                            "$days días"
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text("Tiempo seleccionado: ${selectedDays.value} días")

            Button(
                onClick = onRenewed,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Confirmar renovación")
            }
        }
    }
}
