package com.example.pankajscanning

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pankajscanning.ui.theme.PankajScanningTheme
import com.example.pankajscanning.views.BottomNavigationBar
import com.example.pankajscanning.views.DrawerLayout
import com.example.pankajscanning.views.HomeTopBar
import kotlinx.coroutines.launch

@Composable
fun PankajScanningApp() {
    PankajScanningTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            AppContent()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun AppContent() {
    val navController = rememberNavController()
    val routes = listOf(
        Screen.MySubscriptions,
        Screen.MyOrders,
        Screen.ReportAnIssue,
        Screen.Wallet,
        Screen.Faq,
        Screen.Settings,
        Screen.Wellness
    )
    val bottomNav = listOf(
        Screen.Home,
        Screen.Search,
        Screen.Location,
        Screen.Profile
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    val currentRoute = navBackStackEntry?.destination?.route
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val isScrolling by remember { mutableStateOf(true) }

    ModalNavigationDrawer(
        gesturesEnabled = true,
        drawerState = drawerState,
        drawerContent = {
            DrawerLayout(
                userName = "Ankit",
                resume = "Android Developer",
                avatarModel = R.drawable.logo.toString(),
                routes = routes,
                navController = navController,
                currentDestination = currentDestination,
                onCloseDrawer = { scope.launch { drawerState.close() } }
            )
        },
        content = {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    if (isVisible(currentRoute, isScrolling)) {
                        HomeTopBar(
                            onOpenCart = {
                                navController.navigate(Screen.CartScreen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                }
                            },
                            onOpenDrawer = {
                                scope.launch { drawerState.open() }
                            },
                            currentDestination = navBackStackEntry
                        )
                    }
                },
                bottomBar =
                {
                    if (isVisible(currentRoute, isScrolling)) {
                        BottomNavigationBar(
                            items = bottomNav,
                            navController = navController
                        ) { screen ->
                            if (screen == Screen.Search) {
                                navController.navigate(screen.route) {
                                    popUpTo(navController.graph.findStartDestination().id) {
                                        saveState = true
                                    }
                                }
                            }
                        }
                    }
                },
            ) { innerPadding ->
                NavHostApp(
                    modifier = Modifier.padding(innerPadding),
                    navController = navController,
                    innerPaddings = innerPadding
                )
            }
        },
    )
}

fun isVisible(
    currentRoute: String?,
    isScrolling: Boolean
): Boolean {
    val fullScreens = listOf(Screen.Service)
    return if (fullScreens.any { currentRoute?.startsWith(it.route) == true }) {
        false
    } else {
        isScrolling
    }
}

@Preview
@Composable
fun DPreview() {
    PankajScanningApp()
}
