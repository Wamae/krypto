package ke.co.svs.mykrypto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ke.co.svs.mykrypto.ui.screens.addCrypto.AddCryptoScreen
import ke.co.svs.mykrypto.ui.screens.alerts.AlertsScreen
import ke.co.svs.mykrypto.ui.screens.charts.ChartsScreen
import ke.co.svs.mykrypto.ui.screens.home.HomeScreen
import ke.co.svs.mykrypto.ui.screens.settings.SettingsScreen
import ke.co.svs.mykrypto.ui.screens.splash.SplashScreen
import ke.co.svs.mykrypto.ui.theme.MyKryptoTheme
import ke.co.svs.mykrypto.utils.Routes
import kotlinx.coroutines.CoroutineScope


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            val navHostController = rememberNavController()
            val coroutineHostScope = rememberCoroutineScope()

            MyKryptoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),

                    ) {
                    Navigation(
                        navHostController = navHostController,
                        coroutineHostScope = coroutineHostScope,
                    )
                }
            }
        }
    }
}


@Composable
fun Navigation(
    navHostController: NavHostController,
    coroutineHostScope: CoroutineScope,
) {

    NavHost(
        navController = navHostController,
        startDestination = Routes.ROUTE_SPLASH
    ) {

        composable(Routes.ROUTE_SPLASH) {
            SplashScreen(navController = navHostController)
        }

        composable(Routes.ROUTE_HOME) {
            HomeScreen(navController = navHostController)
        }

        composable(route = Routes.ROUTE_CHARTS) {
            ChartsScreen(navController = navHostController)
        }

        composable(Routes.ROUTE_ALERTS) {
            AlertsScreen(navController = navHostController)

        }

        composable(Routes.ROUTE_SETTINGS) {
            SettingsScreen(navController = navHostController)
        }

        composable(Routes.ROUTE_ADD_CRYPTO) {
            AddCryptoScreen(
                coroutineScope = coroutineHostScope,
                navController = navHostController
            )
        }
    }
}