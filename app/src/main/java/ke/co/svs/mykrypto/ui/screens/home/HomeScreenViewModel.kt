package ke.co.svs.mykrypto.ui.screens.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ke.co.svs.mykrypto.R
import ke.co.svs.mykrypto.base.BaseListRepository
import ke.co.svs.mykrypto.domain.model.Crypto
import ke.co.svs.mykrypto.domain.model.CryptoDetails
import ke.co.svs.mykrypto.domain.model.UserCrypto
import ke.co.svs.mykrypto.domain.repositories.UserCryptoRepositoryImpl
import ke.co.svs.mykrypto.utils.Resource
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get
import timber.log.Timber

/**
 * When extending BaseViewModel use
 * BaseViewModel<List<CryptoDetails>>(repository)
 * **/
class HomeScreenViewModel(
    private val cryptoDetailsRepository: BaseListRepository<CryptoDetails>,
    private val cryptoRepository: BaseListRepository<Crypto>,
    private val userCryptoRepository: UserCryptoRepositoryImpl,
) : ViewModel() {

    private val _stateFlow = MutableStateFlow<Resource<List<CryptoDetails>>>(Resource.loading())
    val stateFlow: StateFlow<Resource<List<CryptoDetails>>> = _stateFlow

    init {
        //Check if user has userCrypto
        // Check if user has Crypto

        //ToDo combine userCrypto and CryptoDetails

        checkForUserDetails()
    }

    private fun fetch() {
        viewModelScope.launch {
            cryptoDetailsRepository.result.collect {
                _stateFlow.value = it
            }
        }
    }

    private fun checkForUserDetails() {
        viewModelScope.launch {
            userCryptoRepository.query().asFlow().toList()

        }
    }


}

