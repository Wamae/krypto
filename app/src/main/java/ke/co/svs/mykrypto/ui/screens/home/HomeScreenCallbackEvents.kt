package ke.co.svs.mykrypto.ui.screens.home

import ke.co.svs.mykrypto.domain.model.CryptoDataModel

sealed class HomeScreenCallbackEvents{
    data class OnCryptoItemClick(val cryptoDataModel: CryptoDataModel) : HomeScreenCallbackEvents()

}

