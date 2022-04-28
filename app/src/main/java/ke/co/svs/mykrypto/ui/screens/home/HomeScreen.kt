package ke.co.svs.mykrypto.ui.screens.home

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ke.co.svs.mykrypto.ui.components.BottomNavigationBar
import ke.co.svs.mykrypto.ui.theme.AppBlue
import ke.co.svs.mykrypto.ui.theme.TextGray
import ke.co.svs.mykrypto.ui.theme.TextGreen
import ke.co.svs.mykrypto.ui.theme.TextWhite
import ke.co.svs.mykrypto.utils.Routes
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.viewModel

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeScreenViewModel = getViewModel<HomeScreenViewModel>()
) {
    val scaffoldHostState = rememberScaffoldState()
//    val homeViewModel =  getViewModel<HomeScreenViewModel>()
//    val homeViewModel: HomeScreenViewModel by viewModel()

    println(homeViewModel.TAG)

    Scaffold(
        scaffoldState = scaffoldHostState,
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
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .clip(
                            RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
                        .background(AppBlue),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Spacer(modifier = Modifier.height(50.dp))
                    Text(text = "TOTAL", fontSize = 13.sp, color = TextGray)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "$ 1000", fontSize = 25.sp, color = TextWhite)
                    Spacer(modifier = Modifier.height(50.dp))
                    OutlinedButton(
                        onClick = { navController.navigate(Routes.ROUTE_ADD_CRYPTO) },
                        border = BorderStroke(1.dp, TextGreen),
                        shape = RoundedCornerShape(50), // = 50% percent
                        // or shape = CircleShape
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = TextWhite,
                            backgroundColor = TextGreen)
                    ) {
                        Text(text = "Add Coin")
                    }

                }
            }
        }
    }

}