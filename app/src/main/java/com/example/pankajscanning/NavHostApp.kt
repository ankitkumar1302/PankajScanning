package com.example.pankajscanning

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pankajscanning.screens.CartScreen
import com.example.pankajscanning.screens.EditProfileScreen
import com.example.pankajscanning.screens.FaqScreen
import com.example.pankajscanning.screens.HomeScreen
import com.example.pankajscanning.screens.LocationScreen
import com.example.pankajscanning.screens.LoginScreen
import com.example.pankajscanning.screens.MyOrdersScreen
import com.example.pankajscanning.screens.MySubscriptionsScreen
import com.example.pankajscanning.screens.ProfileScreen
import com.example.pankajscanning.screens.ReportAnIssueScreen
import com.example.pankajscanning.screens.SearchScreen
import com.example.pankajscanning.screens.ServiceScreen
import com.example.pankajscanning.screens.SettingsScreen
import com.example.pankajscanning.screens.WalletScreen
import com.example.pankajscanning.screens.WellnessScreen


@Composable
fun NavHostApp(
    modifier: Modifier,
    navController: NavHostController,
    innerPaddings: PaddingValues,
    startDestination: String = Screen.Home.route,
//    onShowBottomSheet: () -> Unit,
//    onRepost: () -> Unit,
//    onScrollStateChange: (Boolean) -> Unit
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination,
        enterTransition = { fadeIn() },
        exitTransition = { fadeOut() }
    ) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.Search.route) {
            SearchScreen()
        }
        composable(Screen.CartScreen.route) {
            CartScreen()
        }
        composable(Screen.MySubscriptions.route) {
            MySubscriptionsScreen()
        }
        composable(Screen.MyOrders.route) {
            MyOrdersScreen()
        }
        composable(Screen.Settings.route) {
            SettingsScreen()
        }
        composable(Screen.ReportAnIssue.route) {
            ReportAnIssueScreen()
        }
        composable(Screen.Faq.route) {
            FaqScreen()
        }
        composable(Screen.Wallet.route) {
            WalletScreen()
        }
        composable(Screen.Wellness.route) {
            WellnessScreen()
        }
        composable(Screen.Location.route) {
            LocationScreen()
        }
        composable(Screen.Profile.route) {
            ProfileScreen(navController)
        }
        composable(Screen.Service.route) {
            ServiceScreen(navController)
        }
        composable(Screen.Login.route) {
            LoginScreen()
        }
        composable(Screen.EditProfile.route) {
            EditProfileScreen()
        }
    }
}

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    @DrawableRes val iconId: Int
) {
    object Home : Screen("home", R.string.home, R.drawable.ic_home_filled)
    object MySubscriptions :
        Screen("my_subscriptions", R.string.my_subscriptions, R.drawable.ic_subscriptions)

    object MyOrders : Screen("my_orders", R.string.my_orders, R.drawable.ic_order)
    object Wellness : Screen("wellness", R.string.wellness, R.drawable.ic_wellness)
    object Settings : Screen("settings", R.string.settings, R.drawable.ic_settings)
    object ReportAnIssue :
        Screen("report_an_issue", R.string.report_an_issue, R.drawable.ic_report_an_issue)

    object Faq : Screen("faq", R.string.faq, R.drawable.ic_faq)
    object Search : Screen("search", R.string.search, R.drawable.ic_search)
    object CartScreen : Screen("cart", R.string.cart, R.drawable.ic_cart)
    object Wallet : Screen("wallet", R.string.wallet, R.drawable.ic_wallet)
    object Location : Screen("location", R.string.location, R.drawable.ic_location)
    object Profile : Screen("profile", R.string.profile, R.drawable.ic_profile)
    object Service : Screen("service", R.string.service, R.drawable.ic_service)
    object Login : Screen("login", R.string.login, R.drawable.ic_lock)
    object EditProfile : Screen("edit_profile", R.string.edit_profile, R.drawable.ic_profile)
}

