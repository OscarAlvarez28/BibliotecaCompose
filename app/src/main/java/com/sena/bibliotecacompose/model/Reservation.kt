package com.sena.bibliotecacompose.model

data class Reservation(
    val id: Int,
    val bookId: Int,
    val bookTitle: String,
    val author: String,
    val reservationDate: String,
    val reservationCode: String,
    val isActive: Boolean = true
)