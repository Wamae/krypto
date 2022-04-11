package com.example.basicmvvm.ui.screens.settings

import ke.co.svs.mykrypto.domain.model.Crypto

sealed class HomeScreenCallbackEvents{
    data class OnCryptoItemClick(val crypto: Crypto) : HomeScreenCallbackEvents()

}

