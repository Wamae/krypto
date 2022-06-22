package ke.co.svs.mykrypto.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

class UserCryptoDetail (
    val id: String,
    val myQuantity: Double? = 0.00,
    val name: String?,
    val symbol: String?,
    val logo: String?,
    val price: Double?,
    val priceChange24h: Double?,
    val percentChange24h: Double?,
    val lastUpdated: String?,
    val value: Double?,

)