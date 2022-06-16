package ke.co.svs.mykrypto.domain.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ke.co.svs.mykrypto.cryptos.data.data_source.CryptoDao
import ke.co.svs.mykrypto.domain.model.Crypto
import ke.co.svs.mykrypto.domain.model.CryptoDetails
import ke.co.svs.mykrypto.network.responses.CryptoDetailsResponse
import ke.co.svs.mykrypto.network.responses.CryptoResponse

@Database(
    entities = [CryptoDetails::class, Crypto::class],
    version = 1,
    exportSchema = false,
)
abstract class RoomDB : RoomDatabase() {
    abstract val cryptoDao: CryptoDao
}


fun List<CryptoDetailsResponse>.asCryptoDetailsModel(): List<CryptoDetails> {
    return map {
        CryptoDetails(
            id = it.id!!,
            name = it.name,
//            myQuantity = it.myQuantity,
            symbol = it.symbol,
            logo = it.imageUrl,
            price = it.priceUSD,
            priceChange24h = it.percentChange_24h, // todo
            percentChange24h = it.percentChange_24h,
            lastUpdated = it.lastUpdated.toString()
        )
    }
}

fun List<CryptoResponse>.asCryptoModel(): List<Crypto> {
    return map {
        Crypto(
            id = it.id,
            name = it.name,
            symbol = it.symbol
        )
    }
}