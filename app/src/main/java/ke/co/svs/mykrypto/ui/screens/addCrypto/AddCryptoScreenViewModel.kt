package ke.co.svs.mykrypto.ui.screens.addCrypto

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ke.co.svs.mykrypto.domain.model.CryptoDataModel
import ke.co.svs.mykrypto.domain.repositories.CryptoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AddCryptoScreenViewModel(
    val cryptoRepository: CryptoRepository,
) : ViewModel() {

    val TAG = "ADD CRYPTO VIEWMODEL"

    private val _uiState = MutableStateFlow<AddCryptoUiState>(AddCryptoUiState.Empty)
    val uiState: StateFlow<AddCryptoUiState> = _uiState

    val cryptosFlow = cryptoRepository.getCryptos(limit = 10)

    init {
        viewModelScope.launch {
            _uiState.value = AddCryptoUiState.Loading
            cryptosFlow.collect {
                AddCryptoUiState.Loaded(it)
            }
        }
    }

    fun onEvent(event: AddCryptoScreenCallbackEvents) {
        when (event) {

            is AddCryptoScreenCallbackEvents.OnCryptoItemClick -> {
                Log.i(TAG, "CLICKED")
            }
        }
    }

    sealed class AddCryptoUiState {
        object Empty : AddCryptoUiState()
        object Loading : AddCryptoUiState()
        class Loaded(val data: List<CryptoDataModel>) : AddCryptoUiState()
        class Error(val message: String) : AddCryptoUiState()
    }

}