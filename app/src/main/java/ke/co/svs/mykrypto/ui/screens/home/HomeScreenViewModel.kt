package ke.co.svs.mykrypto.ui.screens.home


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ke.co.svs.mykrypto.domain.model.CryptoDataModel
import ke.co.svs.mykrypto.domain.repositories.CryptoRepository
import ke.co.svs.mykrypto.network.Status
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException


class HomeScreenViewModel(
    val cryptoRepository: CryptoRepository,
) : ViewModel() {

    val TAG = "HOME VIEWMODEL"

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Empty)
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
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
                val resource = cryptoRepository.fetchCryptos()
                when (resource.status) {
                    Status.ERROR -> _uiState.value = HomeUiState.Error(resource.message!!)
                    else -> {}
                }
            }

        } catch (e: HttpException) {
            e.message().let { Log.e(TAG, it) }
            _uiState.value = HomeUiState.Error(e.message())
        } catch (e: Exception) {
            e.message?.let { Log.e(TAG, it) }
            _uiState.value = e.message?.let { HomeUiState.Error(it) }!!
        }
    }


    sealed class HomeUiState {
        object Empty : HomeUiState()
        object Loading : HomeUiState()
        class Loaded(val data: List<CryptoDataModel>) : HomeUiState()
        class Error(val message: String) : HomeUiState()
    }

}