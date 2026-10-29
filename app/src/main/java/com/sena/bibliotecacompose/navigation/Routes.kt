package com.sena.bibliotecacompose.navigation

object Routes {
    const val HOME = "home"
    const val BOOK_LIST = "book_list"
    const val BOOK_DETAIL = "book_detail/{bookId}"
    const val RESERVATION_SUCCESS = "reservation_success/{bookId}"

    const val MY_RESERVATIONS = "my_reservations"
    const val RESERVATION_DETAIL = "reservation_detail/{reservationId}"
    const val RENEW_RESERVATION = "renew_reservation/{reservationId}"
    const val RENEWAL_SUCCESS = "renewal_success/{reservationId}"

    fun bookDetail(bookId: Int): String = "book_detail/$bookId"

    fun reservationSuccess(bookId: Int): String =
        "reservation_success/$bookId"

    fun reservationDetail(reservationId: Int): String =
        "reservation_detail/$reservationId"

    fun renewReservation(reservationId: Int): String =
        "renew_reservation/$reservationId"

    fun renewalSuccess(reservationId: Int): String =
        "renewal_success/$reservationId"
}