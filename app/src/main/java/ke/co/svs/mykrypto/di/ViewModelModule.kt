package ke.co.svs.mykrypto.di


import ke.co.svs.mykrypto.ui.screens.alerts.AlertsScreenViewModel
import ke.co.svs.mykrypto.ui.screens.charts.ChartsScreenViewModel
import ke.co.svs.mykrypto.ui.screens.home.HomeScreenViewModel
// import ke.co.svs.mykrypto.ui.screens.home.HomeScreenViewModel
import ke.co.svs.mykrypto.ui.screens.settings.SettingsScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelModule = module {
//    viewModel { HomeScreenViewModel(get(named("cryptoDetails")), get(named("crypto")), get(named("userCrypto"))) }

    viewModel { HomeScreenViewModel(get(), get(named("crypto")), get()) }
    viewModel { ChartsScreenViewModel() }
    viewModel { AlertsScreenViewModel() }
    viewModel { SettingsScreenViewModel() }
}

