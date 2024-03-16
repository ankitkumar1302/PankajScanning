package com.example.pankajscanning.views

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pankajscanning.Screen
import com.example.pankajscanning.ui.theme.secondaryBackground


@Composable
fun BottomNavigationBar(
    items: List<Screen>,
    navController: NavHostController,
    onItemClick: (Screen) -> Unit
) {
    BottomNavigation(
        backgroundColor = secondaryBackground,
//        contentColor = Color.White,
    ) {
        items.forEach { item ->
            val isSelected =
                navController.currentDestination?.hierarchy?.any { it.route == item.route } == true
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.iconId), contentDescription = null) },
                label = { Text(text = stringResource(id = item.resourceId)) },
                alwaysShowLabel = true,
                selected = isSelected,
                onClick = {
                    navController.navigate(item.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                    onItemClick(item)
                },
                selectedContentColor = Color(0xFFE0E0E0),
                unselectedContentColor = Color.White.copy(0.4f),
            )
        }
    }
}

@Preview
@Composable
private fun PreviewBottomBar() {
    BottomNavigationBar(
        items = listOf(
            Screen.Home,
            Screen.Search,
            Screen.Location,
            Screen.Profile
        ),
        navController = rememberNavController(),
        onItemClick = {}
    )
}


// This is an animated bottom navigation

/* @ExperimentalAnimationApi
@Composable
fun BottomNavigation(
    screens: List<Screen>,
//    navigate: (Screen) -> Unit
) {
    var selectedScreen by remember { mutableStateOf(0) }
    Box(
        Modifier
            .shadow(5.dp)
            .background(color = MaterialTheme.colors.surface)
            .height(72.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            for (item in screens) {
                val isSelected = item == screens[selectedScreen]
                val animatedWeight by animateFloatAsState(targetValue = if (isSelected) 1.5f else 1f,
                    label = ""
                )
                Box(
                    modifier = Modifier.weight(animatedWeight),
                    contentAlignment = Alignment.Center,
                ) {
                    val interactionSource = remember { MutableInteractionSource() }
                    BottomNavItem(
                        modifier = Modifier
                            .clickable(
                                interactionSource = interactionSource,
                                indication = null
                            ) {
                                selectedScreen = screens.indexOf(item)
//                                navigate(item)

                            },
                        item = item,
                        isSelected = isSelected,
                        onClick = {
                            selectedScreen = screens.indexOf(item)
                            navigate(item)
                        }
                    )
                }
            }
        }
    }
}


@ExperimentalAnimationApi
@Composable
private fun BottomNavItem(
    modifier: Modifier = Modifier,
    item: Screen,
    isSelected: Boolean,
    onClick: () -> Unit ={

    }
) {

    val animatedHeight by animateDpAsState(
        targetValue = if (isSelected) 36.dp else 26.dp,
        label = ""
    )
    val animatedElevation by animateDpAsState(
        targetValue = if (isSelected) 15.dp else 0.dp,
        label = ""
    )
    val animatedAlpha by animateFloatAsState(
        targetValue = if (isSelected) 1f else .5f,
        label = ""
    )
    val animatedIconSize by animateDpAsState(
        targetValue = if (isSelected) 26.dp else 20.dp,
        animationSpec = spring(
            stiffness = Spring.StiffnessLow,
            dampingRatio = Spring.DampingRatioMediumBouncy
        ), label = ""
    )
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Row(
            modifier = Modifier
                .height(animatedHeight)
                .shadow(
                    elevation = animatedElevation,
                    shape = RoundedCornerShape(20.dp)
                )
                .background(
                    color = MaterialTheme.colors.surface,
                    shape = RoundedCornerShape(20.dp)
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            FlipIcon(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxHeight()
                    .padding(start = 11.dp)
                    .alpha(animatedAlpha)
                    .size(animatedIconSize),
                isActive = isSelected,
                activeIcon = item.iconId,
                inactiveIcon = item.iconId,
                contentDescription = item.resourceId.toString(),
            )

            AnimatedVisibility(visible = isSelected) {
                Text(
                    text =stringResource(id = item.resourceId),
                    modifier = Modifier.padding(start = 8.dp, end = 10.dp),
                    maxLines = 1,
                )
            }
        }
    }
}


@Composable
fun FlipIcon(
    modifier: Modifier = Modifier,
    isActive: Boolean,
    activeIcon: Int,
    inactiveIcon: Int,
    contentDescription: String,
) {
    val animationRotation by animateFloatAsState(
        targetValue = if (isActive) 180f else 0f,
        animationSpec = spring(
            stiffness = Spring.StiffnessLow,
            dampingRatio = Spring.DampingRatioMediumBouncy
        ), label = ""
    )
    Box(
        modifier = modifier
            .graphicsLayer { rotationY = animationRotation },
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            painter = rememberVectorPainter(
                image = if (animationRotation > 90f) ImageVector.vectorResource(
                    id = activeIcon
                ) else ImageVector.vectorResource(id = inactiveIcon)
            ),
            contentDescription = contentDescription,
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Preview
@Composable
fun DefaultBottomNav() {
    //BottomNavigation(listOf(Screen.Home,Screen.Search,Screen.Wellness,Screen.Settings))
}

 */
