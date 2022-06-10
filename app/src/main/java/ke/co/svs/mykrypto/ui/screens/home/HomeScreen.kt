package ke.co.svs.mykrypto.ui.screens.home

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
import ke.co.svs.mykrypto.utils.Resource
import org.koin.androidx.compose.getViewModel
import org.koin.androidx.compose.inject


@Composable
fun HomeScreen(
    navController: NavController,
) {
    val scaffoldHostState = rememberScaffoldState()
//   val viewModel by inject<HomeScreenViewModel>()
    val viewModel = getViewModel<HomeScreenViewModel>()


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
//            lifecycleScope.launch {
//                viewModel.stateFlow.collect { resource ->
//                    when (resource.status) {
//                        Resource.Status.SUCCESS -> Text(text = "Success")
//                        Resource.Status.LOADING -> Text(text = "Loading")
//                        Resource.Status.ERROR -> Text(text =resource.message!!)
//                    }
//                }
//            }

        }
    }

}