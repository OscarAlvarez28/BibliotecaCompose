package com.sena.bibliotecacompose.model

val books = listOf(
    Book(
        id = 1,
        title = "Clean Code",
        author = "Robert C. Martin",
        category = "Programación",
        description = "Aprende principios y buenas prácticas para escribir código limpio, legible y fácil de mantener.",
        coverColor = 0xFF263238
    ),
    Book(
        id = 2,
        title = "El programador pragmático",
        author = "Andrew Hunt y David Thomas",
        category = "Desarrollo de software",
        description = "Un libro sobre técnicas, hábitos y decisiones para mejorar como desarrollador.",
        coverColor = 0xFF43A047
    ),
    Book(
        id = 3,
        title = "Código completo",
        author = "Steve McConnell",
        category = "Ingeniería de software",
        description = "Conceptos y técnicas para construir software de calidad.",
        coverColor = 0xFFEF6C00
    ),
    Book(
        id = 4,
        title = "Kotlin en acción",
        author = "Dmitry Jemerov y Svetlana Isakova",
        category = "Programación",
        description = "Una introducción al lenguaje Kotlin y sus herramientas.",
        coverColor = 0xFF1565C0
    )
)

fun getBookById(id: Int): Book? {
    return books.find { it.id == id }
}
