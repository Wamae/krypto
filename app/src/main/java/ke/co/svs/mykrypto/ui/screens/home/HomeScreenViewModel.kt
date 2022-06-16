package ke.co.svs.mykrypto.ui.screens.home


import ke.co.svs.mykrypto.base.BaseListRepository
import ke.co.svs.mykrypto.base.BaseViewModel
import ke.co.svs.mykrypto.domain.model.CryptoDetails

class HomeScreenViewModel(
    repository: BaseListRepository<CryptoDetails>,
) : BaseViewModel<List<CryptoDetails>>(repository){

}

