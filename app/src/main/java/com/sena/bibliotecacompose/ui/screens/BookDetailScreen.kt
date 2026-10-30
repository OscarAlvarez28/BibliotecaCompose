package com.sena.bibliotecacompose.ui.screens



import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.bibliotecacompose.model.getBookById
import com.sena.bibliotecacompose.composable.PrimaryButton

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun BookDetailScreen(
    bookId: Int,
    onReserve: () -> Unit,
    onBack: () -> Unit
) {
    val book = getBookById(bookId)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Detalle del libro") },
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
            if (book != null) {
                Text(
                    text = book.title,
                    style = MaterialTheme.typography.headlineMedium
                )
                Text("Autor: ${book.author}")
                Text("Categoría: ${book.category}")
                Text(book.description)

                PrimaryButton(
                    text = "Reservar libro",
                    onClick = onReserve
                )
            } else {
                Text("No se encontró el libro.")
            }
        }
    }
}