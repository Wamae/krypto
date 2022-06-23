package ke.co.svs.mykrypto.ui.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import ke.co.svs.mykrypto.ui.components.BottomNavigationBar
import ke.co.svs.mykrypto.ui.components.CollapsingToolBar
import ke.co.svs.mykrypto.utils.Resource
import org.koin.androidx.compose.getViewModel


@Composable
fun HomeScreen(
    navController: NavController,
) {
    val scaffoldHostState = rememberScaffoldState()
    val viewModel = getViewModel<HomeScreenViewModel>()

    Scaffold(
        scaffoldState = scaffoldHostState,
        topBar = { CollapsingToolBar(navController = navController) },

        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                onItemClicked = {
                    navController.navigate(it.route)
                }
            )

        }
    ) {

        Box(modifier = Modifier.fillMaxSize()) {
            val resourceState by remember(viewModel) { viewModel.stateFlow }.collectAsState()

            when (resourceState.status) {
                Resource.Status.SUCCESS -> CryptoDetailList(list = resourceState.data!!,
                    modifier = Modifier)
                Resource.Status.LOADING -> Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center) { Text(text = "Loading") }
                Resource.Status.ERROR -> Box(modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center) { Text(text = resourceState.message!!) }
            }

        }
    }

}