package ke.co.svs.mykrypto.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.JsonArray

@Entity(tableName = "cryptos")
class Crypto(
    @PrimaryKey
    val id: String?,
    val name: String?,
    val symbol: String?,
    val logo: String?,
    @Transient val myQuantity: Double? = 0.00,
    val price: Double?,
    val priceChange24h: Double?,
    val percentChange24h: Double?,
    val lastUpdated: String?,
    val sparkData: JsonArray?
)