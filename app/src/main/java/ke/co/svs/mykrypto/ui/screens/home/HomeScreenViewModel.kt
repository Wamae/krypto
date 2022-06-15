package ke.co.svs.mykrypto.ui.screens.home


import ke.co.svs.mykrypto.base.BaseListRepository
import ke.co.svs.mykrypto.base.BaseViewModel
import ke.co.svs.mykrypto.domain.model.Crypto

class HomeScreenViewModel(
    repository: BaseListRepository<Crypto>,
) : BaseViewModel<List<Crypto>>(repository){

}

