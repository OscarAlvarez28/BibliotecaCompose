package com.sena.bibliotecacompose.section

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sena.bibliotecacompose.composable.BookCard
import com.sena.bibliotecacompose.model.Book

@Composable
fun BookSection(
    books: List<Book>,
    onBookClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = SectionStyles.screenPadding,
        verticalArrangement = SectionStyles.itemSpacing
    ) {
        items(books) { book ->
            BookCard(
                book = book,
                onClick = { onBookClick(book.id) }
            )
        }
    }
}
