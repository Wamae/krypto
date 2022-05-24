package ke.co.svs.mykrypto.di


import ke.co.svs.mykrypto.ui.screens.alerts.AlertsScreenViewModel
import ke.co.svs.mykrypto.ui.screens.charts.ChartsScreenViewModel
import ke.co.svs.mykrypto.ui.screens.home.HomeScreenViewModel
// import ke.co.svs.mykrypto.ui.screens.home.HomeScreenViewModel
import ke.co.svs.mykrypto.ui.screens.settings.SettingsScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeScreenViewModel(get()) }
    viewModel { ChartsScreenViewModel() }
    viewModel { AlertsScreenViewModel() }
    viewModel { SettingsScreenViewModel() }
}

