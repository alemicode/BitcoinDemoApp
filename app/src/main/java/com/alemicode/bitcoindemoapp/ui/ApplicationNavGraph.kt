package com.alemicode.bitcoindemoapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.alemicode.bitcoindemoapp.ui.walletDetails.WalletDetailsScreen
import com.alemicode.bitcoindemoapp.ui.walletsList.WalletsListScreen

@Composable
fun AppNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    mainViewModel: MainViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = WalletsListDestination.route
    ) {
        composable(route = WalletsListDestination.route) {
            WalletsListScreen(modifier = modifier) { walletAddress ->
                navController.navigate(WalletDetailsDestination.createRoute(walletAddress))
            }
        }

        composable(
            route = WalletDetailsDestination.route,
            arguments = listOf(navArgument("walletAddress") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            // It's best practice not to use whole viewmodel as method parameter to avoid recomposition and improve performance
            val uiState = mainViewModel.walletInformationUiState.collectAsStateWithLifecycle()
            val refreshData = mainViewModel::refreshData
            WalletDetailsScreen(
                modifier = modifier,
                uiState = uiState,
                refreshData = refreshData
            )
        }
    }
}

object WalletsListDestination {
    const val route = "wallets_list"
}

object WalletDetailsDestination {
    const val route = "wallet_details/{walletAddress}"

    fun createRoute(walletAddress: String) = "wallet_details/$walletAddress"
}
