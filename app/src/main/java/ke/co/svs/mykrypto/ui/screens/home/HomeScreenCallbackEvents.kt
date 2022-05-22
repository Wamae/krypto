package ke.co.svs.mykrypto.ui.screens.home

import ke.co.svs.mykrypto.domain.model.Crypto

sealed class HomeScreenCallbackEvents{
    data class OnCryptoItemClick(val crypto: Crypto) : HomeScreenCallbackEvents()

}

