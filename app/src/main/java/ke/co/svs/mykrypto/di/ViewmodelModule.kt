package ke.co.svs.mykrypto.di

import com.example.basicmvvm.ui.screens.settings.AlertsScreenViewModel
import com.example.basicmvvm.ui.screens.settings.ChartsScreenViewModel
import com.example.basicmvvm.ui.screens.settings.HomeScreenViewModel
import com.example.basicmvvm.ui.screens.settings.SettingsScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewmodelModule = module {
    viewModel { HomeScreenViewModel() }
    viewModel { ChartsScreenViewModel() }
    viewModel { AlertsScreenViewModel() }
    viewModel { SettingsScreenViewModel() }
}

