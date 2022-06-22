package ke.co.svs.mykrypto.ui.screens.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import ke.co.svs.mykrypto.base.BaseListRepository
import ke.co.svs.mykrypto.domain.model.Crypto
import ke.co.svs.mykrypto.domain.model.CryptoDetail
import ke.co.svs.mykrypto.domain.model.UserCrypto
import ke.co.svs.mykrypto.domain.model.UserCryptoDetail
import ke.co.svs.mykrypto.domain.repositories.UserCryptoRepositoryImpl
import ke.co.svs.mykrypto.utils.Resource
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber

/**
 * When extending BaseViewModel use
 * BaseViewModel<List<CryptoDetails>>(repository)
 * **/
class HomeScreenViewModel(
    private val cryptoDetailsRepository: BaseListRepository<CryptoDetail>,
    private val cryptoRepository: BaseListRepository<Crypto>,
    private val userCryptoRepository: UserCryptoRepositoryImpl,
) : ViewModel() {

    private val _stateFlow = MutableStateFlow<Resource<List<UserCryptoDetail>>>(Resource.loading())
    val stateFlow = _stateFlow.asStateFlow()

    init {
        //Check if user has userCrypto
        // Check if user has Crypto

        //ToDo combine userCrypto and CryptoDetails

        checkForUserCrypto()
    }

    private fun fetch() {
        viewModelScope.launch {
//            cryptoDetailsRepository.result.collect {
//                _stateFlow.value = it
//            }
        }
    }

    private fun checkForUserCrypto() {
        viewModelScope.launch {
            userCryptoRepository.query().collect { resource ->
                if (!resource.data.isNullOrEmpty()) {
                    _stateFlow.value = Resource.error("No Cryptos found")
                } else {
                    ///row data
                    val list = (1..5).map {
                        UserCrypto(id = "bitcoin", myQuantity = 0.5)
                    }
//                    val list = resource.data!!.joinToString { item -> item.id }
                    val idsList = list.joinToString { item -> item.id }

                    _stateFlow.value = Resource.success(
                        cryptoDetailsRepository.fetch(limit = 50, ids = idsList)
                            .map {
                                UserCryptoDetail(
                                    id = it.id,
                                    myQuantity = list.first { item -> item.id == it.id }.myQuantity,
                                    name = it.name,
                                    symbol = it.symbol,
                                    logo = it.logo,
                                    price = it.price,
                                    priceChange24h = it.priceChange24h,
                                    percentChange24h = it.percentChange24h,
                                    lastUpdated = it.lastUpdated,
                                    value = it.percentChange24h?.let { it1 ->
                                        (list.first { item -> item.id == it.id }.myQuantity)?.times(
                                            it1)
                                    }
                                )
                            }
                    )


                }
            }
        }
    }


}

