package ke.co.svs.mykrypto.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ke.co.svs.mykrypto.utils.Routes


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomNavigationBar(
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClicked: (BottomNavItem) -> Unit,
) {
    //To access to current route
    val backStackEntry = navController.currentBackStackEntryAsState()

    //Items
    val items = listOf(
        BottomNavItem(
            name = "Home",
            route = Routes.ROUTE_HOME,
            icon = Icons.Filled.Home
        ),
        BottomNavItem(
            name = "Charts",
            route = Routes.ROUTE_CHARTS,
            icon = Icons.Filled.PieChart ,
        ),
        BottomNavItem(
            name = "Alerts",
            route = Routes.ROUTE_ALERTS,
            icon = Icons.Filled.Notifications,
            badgeCount = 2
        ),
        BottomNavItem(
            name = "Settings",
            route = Routes.ROUTE_SETTINGS,
            icon = Icons.Filled.Settings
        ),
    )


    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.White,
                onClick = { onItemClicked(item) },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (item.badgeCount > 0) {
                            BadgeBox(badgeContent = {
                                Text(text = item.badgeCount.toString())
                            }) {
                                Icon(imageVector = item.icon, contentDescription = item.name)
                            }
                        } else {
                            Icon(imageVector = item.icon, contentDescription = item.name)
                        }

                        if (selected) {
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 10.sp

                            )
                        }
                    }
                }
            )
        }
    }
}

class BottomNavItem(
    val name: String,
    val route: String,
    val icon: ImageVector,
    val badgeCount: Int = 0,
)
