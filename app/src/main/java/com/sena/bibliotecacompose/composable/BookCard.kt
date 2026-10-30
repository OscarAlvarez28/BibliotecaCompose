package com.sena.bibliotecacompose.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sena.bibliotecacompose.R
import com.sena.bibliotecacompose.model.Book

@Composable
fun BookCard(
    book: Book,
    onClick: () -> Unit
) {
    val bookImage = when (book.id) {
        1 -> R.drawable.clean_code
        2 -> R.drawable.programador_pragmatico
        3 -> R.drawable.codigo_completo
        4 -> R.drawable.kotlin_en_accion
        else -> null
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            bookImage?.let { image ->
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Portada de ${book.title}",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = book.title,
                style = MaterialTheme.typography.titleMedium
            )

            Text("Autor: ${book.author}")
            Text("Categoría: ${book.category}")

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Ver detalles →",
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
