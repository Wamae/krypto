package ke.co.svs.mykrypto.network.responses

import androidx.annotation.Keep

@Keep
data class CryptoResponse (val id: String, val name: String, val symbol: String)