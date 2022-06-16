package ke.co.svs.mykrypto.ui.screens.home

import ke.co.svs.mykrypto.domain.model.CryptoDetails

sealed class HomeScreenCallbackEvents{
    data class OnCryptoItemClick(val crypto: CryptoDetails) : HomeScreenCallbackEvents()

}

