package ke.co.svs.mykrypto.ui.components

import android.util.Log
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ke.co.svs.mykrypto.utils.Routes


@Composable
fun TopBar(navController: NavController) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    var title: String = "Cryponite"
    when (currentRoute) {
        Routes.ROUTE_HOME -> title = "Cryponite"
        Routes.ROUTE_CHARTS -> title = "Charts"
        Routes.ROUTE_ALERTS -> title = "Alerts"
        Routes.ROUTE_SETTINGS -> title = "Settings"
        else -> title = "Cryponite"
    }


    TopAppBar(
        title = {
            Text(text = title)
        },
//        navigationIcon = {
//            IconButton(onClick = {}) {
//                Icon(Icons.Filled.ArrowBack, "backIcon")
//            }
//        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White,
        elevation = 10.dp
    )
}