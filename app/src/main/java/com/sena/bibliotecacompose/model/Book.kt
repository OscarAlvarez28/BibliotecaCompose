package com.sena.bibliotecacompose.model

data class Book(
    val id: Int,
    val title: String,
    val author: String,
    val category: String,
    val description: String,
    val coverColor: Long
)