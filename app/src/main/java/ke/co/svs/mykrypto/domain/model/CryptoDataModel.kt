package ke.co.svs.mykrypto.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.JsonArray

@Entity(tableName = "cryptos")
data class CryptoDataModel(
    @PrimaryKey val id: String,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "symbol") val symbol: String?,
    @ColumnInfo(name = "logo") val logo: String?,
//    @ColumnInfo(name = "myQuantity") @Transient val myQuantity: Double? = 0.00,
    @ColumnInfo(name = "price") val price: Double?,
    @ColumnInfo(name = "priceChange24h") val priceChange24h: Double?,
    @ColumnInfo(name = "percentChange24h") val percentChange24h: Double?,
    @ColumnInfo(name = "lastUpdated") val lastUpdated: String?,
)

//    val sparkData: JsonArray?