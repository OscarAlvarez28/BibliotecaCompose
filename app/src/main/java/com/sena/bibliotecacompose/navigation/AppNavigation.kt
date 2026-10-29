package com.sena.bibliotecacompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

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
                onBack = { navController.popBackStack() }
            )
        }

        composable(
            route = Routes.BOOK_DETAIL,
            arguments = listOf(navArgument("bookId") {
                type = NavType.IntType
            })
        ) { entry ->
            val bookId = entry.arguments?.getInt("bookId") ?: return@composable

            BookDetailScreen(
                bookId = bookId,
                onReserve = {
                    navController.navigate(Routes.reservationSuccess(bookId))
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable(
            route = Routes.RESERVATION_SUCCESS,
            arguments = listOf(navArgument("bookId") {
                type = NavType.IntType
            })
        ) { entry ->
            val bookId = entry.arguments?.getInt("bookId") ?: return@composable

            ReservationSuccessScreen(
                bookId = bookId,
                onGoToReservations = {
                    navController.navigate(Routes.MY_RESERVATIONS)
                },
                onBackHome = {
                    navController.popBackStack(Routes.HOME, inclusive = false)
                }
            )
        }

        composable(Routes.MY_RESERVATIONS) {
            MyReservationsScreen(
                onReservationClick = { reservationId ->
                    navController.navigate(
                        Routes.reservationDetail(reservationId)
                    )
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable(
            route = Routes.RESERVATION_DETAIL,
            arguments = listOf(navArgument("reservationId") {
                type = NavType.IntType
            })
        ) { entry ->
            val reservationId =
                entry.arguments?.getInt("reservationId") ?: return@composable

            ReservationDetailScreen(
                reservationId = reservationId,
                onRenew = {
                    navController.navigate(
                        Routes.renewReservation(reservationId)
                    )
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable(
            route = Routes.RENEW_RESERVATION,
            arguments = listOf(navArgument("reservationId") {
                type = NavType.IntType
            })
        ) { entry ->
            val reservationId =
                entry.arguments?.getInt("reservationId") ?: return@composable

            RenewReservationScreen(
                reservationId = reservationId,
                onRenewed = {
                    navController.navigate(
                        Routes.renewalSuccess(reservationId)
                    )
                },
                onBack = { navController.popBackStack() }
            )
        }

        composable(
            route = Routes.RENEWAL_SUCCESS,
            arguments = listOf(navArgument("reservationId") {
                type = NavType.IntType
            })
        ) { entry ->
            val reservationId =
                entry.arguments?.getInt("reservationId") ?: return@composable

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