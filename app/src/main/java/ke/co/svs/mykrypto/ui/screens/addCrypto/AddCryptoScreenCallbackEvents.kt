package ke.co.svs.mykrypto.ui.screens.addCrypto

import ke.co.svs.mykrypto.domain.model.CryptoDataModel

sealed class AddCryptoScreenCallbackEvents{
    data class OnCryptoItemClick(val cryptoDataModel: CryptoDataModel) : AddCryptoScreenCallbackEvents()
    object OnBackArrowClick: AddCryptoScreenCallbackEvents()

}