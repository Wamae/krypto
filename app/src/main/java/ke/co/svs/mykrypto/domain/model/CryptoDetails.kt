package ke.co.svs.mykrypto.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cryptos_details")
class CryptoDetails (
    @PrimaryKey
    val id: String,
    val name: String?,
    val symbol: String?,
    val logo: String?,
    val price: Double?,
    val priceChange24h: Double?,
    val percentChange24h: Double?,
    val lastUpdated: String?,
)