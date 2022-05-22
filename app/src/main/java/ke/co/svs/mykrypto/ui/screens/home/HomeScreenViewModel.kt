package ke.co.svs.mykrypto.ui.screens.home


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ke.co.svs.mykrypto.domain.model.Crypto
import ke.co.svs.mykrypto.domain.repositories.CryptoRepository
import ke.co.svs.mykrypto.domain.repositories.CryptoRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import retrofit2.HttpException


class HomeScreenViewModel() : ViewModel() {

    private val TAG = "CHARTS VIEWMODEL"

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Empty)
    val uiState: StateFlow<HomeUiState> = _uiState

    val cryptoRepository: CryptoRepositoryImpl by inject(CryptoRepositoryImpl::class.java)

    // Locally saved
    val cryptosFlow = cryptoRepository.getAllCryptos()


    init {
        viewModelScope.launch {
            _uiState.value = HomeUiState.Loading
            cryptosFlow.collect { it: List<Crypto> ->
                HomeUiState.Loaded(it)
            }
        }

        //Fetching from Network
        fetchCryptos()

    }

    fun onEvent(event: HomeScreenCallbackEvents) {
        when (event) {
            is HomeScreenCallbackEvents.OnCryptoItemClick -> {
                Log.i(TAG, "CLICKED")
            }
        }
    }

    fun fetchCryptos() {
        try {
            /** Tell HomeState the state */
            _uiState.value = HomeUiState.Loading



            viewModelScope.launch {
                cryptoRepository.fetchCryptos(limit = 30).collect {
                    //How to change for CryptoResponse to Crypto
//                    HomeUiState.Loaded(it)
                }

            }


        } catch (e: HttpException) {
            e.message()?.let { Log.e(TAG, it) }
            _uiState.value = HomeUiState.Error(e.message())
        } catch (e: Exception) {
            e.message?.let { Log.e(TAG, it) }
            _uiState.value = e.message?.let { HomeUiState.Error(it) }!!
        }
    }


    sealed class HomeUiState {
        object Empty : HomeUiState()
        object Loading : HomeUiState()
        class Loaded(val data: List<Crypto>) : HomeUiState()
        class Error(val message: String) : HomeUiState()
    }

}