
package com.sena.bibliotecacompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

import com.sena.bibliotecacompose.model.books
import com.sena.bibliotecacompose.model.getBookById
import com.sena.bibliotecacompose.model.Reservation
import com.sena.bibliotecacompose.ui.screens.HomeScreen
import com.sena.bibliotecacompose.ui.screens.BookListScreen
import com.sena.bibliotecacompose.ui.screens.BookDetailScreen
import com.sena.bibliotecacompose.ui.screens.ReservationSuccessScreen
import com.sena.bibliotecacompose.ui.screens.MyReservationsScreen
import com.sena.bibliotecacompose.ui.screens.ReservationDetailScreen
import com.sena.bibliotecacompose.ui.screens.RenewReservationScreen
import com.sena.bibliotecacompose.ui.screens.RenewalSuccessScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val reservations = remember {
        mutableStateListOf<Reservation>()
    }

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {

        composable(Routes.HOME) {
            HomeScreen(
                onViewBooks = {
                    navController.navigate(Routes.BOOK_LIST)
                },
                onMyReservations = {
                    navController.navigate(Routes.MY_RESERVATIONS)
                }
            )
        }

        composable(Routes.BOOK_LIST) {
            BookListScreen(
                onBookClick = { bookId ->
                    navController.navigate(Routes.bookDetail(bookId))
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Routes.BOOK_DETAIL,
            arguments = listOf(
                navArgument("bookId") {
                    type = NavType.IntType
                }
            )
        ) { entry ->

            val bookId =
                entry.arguments?.getInt("bookId")
                    ?: return@composable

            BookDetailScreen(
                bookId = bookId,
                onReserve = {
                    val book = getBookById(bookId)

                    if (book != null) {
                        val dateFormat = SimpleDateFormat(
                            "dd/MM/yyyy",
                            Locale.getDefault()
                        )

                        val today = Calendar.getInstance()
                        val dueDate = Calendar.getInstance()
                        dueDate.add(Calendar.DAY_OF_YEAR, 14)

                        val reservation = Reservation(
                            id = (reservations.maxOfOrNull { it.id } ?: 0) + 1,
                            bookId = book.id,
                            bookTitle = book.title,
                            author = book.author,
                            reservationDate = dateFormat.format(today.time),
                            dueDate = dateFormat.format(dueDate.time),
                            reservationCode = "RES-${(reservations.size + 1).toString().padStart(3, '0')}"
                        )

                        reservations.add(reservation)

                        navController.navigate(
                            Routes.reservationSuccess(bookId)
                        )
                    }
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Routes.RESERVATION_SUCCESS,
            arguments = listOf(
                navArgument("bookId") {
                    type = NavType.IntType
                }
            )
        ) { entry ->

            val bookId =
                entry.arguments?.getInt("bookId")
                    ?: return@composable

            ReservationSuccessScreen(
                bookId = bookId,
                onGoToReservations = {
                    navController.navigate(Routes.MY_RESERVATIONS)
                },
                onBackHome = {
                    navController.popBackStack(
                        Routes.HOME,
                        inclusive = false
                    )
                }
            )
        }

        composable(Routes.MY_RESERVATIONS) {
            MyReservationsScreen(
                reservations = reservations,
                onReservationClick = { reservationId ->
                    navController.navigate(
                        Routes.reservationDetail(reservationId)
                    )
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Routes.RESERVATION_DETAIL,
            arguments = listOf(
                navArgument("reservationId") {
                    type = NavType.IntType
                }
            )
        ) { entry ->

            val reservationId =
                entry.arguments?.getInt("reservationId")
                    ?: return@composable

            val reservation = reservations.find {
                it.id == reservationId
            }

            ReservationDetailScreen(
                reservation = reservation,
                onRenew = {
                    navController.navigate(
                        Routes.renewReservation(reservationId)
                    )
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Routes.RENEW_RESERVATION,
            arguments = listOf(
                navArgument("reservationId") {
                    type = NavType.IntType
                }
            )
        ) { entry ->

            val reservationId =
                entry.arguments?.getInt("reservationId")
                    ?: return@composable

            RenewReservationScreen(
                reservationId = reservationId,
                onRenewed = { days ->

                    val index = reservations.indexOfFirst {
                        it.id == reservationId
                    }

                    if (index != -1) {
                        val reservation = reservations[index]

                        val dateFormat = SimpleDateFormat(
                            "dd/MM/yyyy",
                            Locale.getDefault()
                        )

                        val calendar = Calendar.getInstance()
                        calendar.time = dateFormat.parse(
                            reservation.dueDate
                        ) ?: calendar.time

                        calendar.add(Calendar.DAY_OF_YEAR, days)

                        reservations[index] = reservation.copy(
                            dueDate = dateFormat.format(calendar.time)
                        )
                    }

                    navController.navigate(
                        Routes.renewalSuccess(reservationId)
                    )
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Routes.RENEWAL_SUCCESS,
            arguments = listOf(
                navArgument("reservationId") {
                    type = NavType.IntType
                }
            )
        ) { entry ->

            val reservationId =
                entry.arguments?.getInt("reservationId")
                    ?: return@composable

            RenewalSuccessScreen(
                reservationId = reservationId,
                onBackToReservations = {
                    navController.popBackStack(
                        Routes.MY_RESERVATIONS,
                        inclusive = false
                    )
                }
            )
        }
    }
}
