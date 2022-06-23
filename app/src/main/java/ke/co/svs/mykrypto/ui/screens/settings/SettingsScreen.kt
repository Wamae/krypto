package ke.co.svs.mykrypto.ui.screens.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ke.co.svs.mykrypto.ui.components.BottomNavigationBar

@Composable
fun SettingsScreen(
    navController: NavController,
) {
//    val viewModel = get<SettingsScreenViewModel>()
    val scaffoldHostState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldHostState,
//        topBar = { TopBar(navController = navController) },

        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                onItemClicked = {
                    navController.navigate(it.route)
                }
            )

        }
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Settings Screen")
        }
    }
}