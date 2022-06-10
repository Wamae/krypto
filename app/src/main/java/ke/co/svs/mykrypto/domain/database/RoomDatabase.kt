package ke.co.svs.mykrypto.domain.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ke.co.svs.mykrypto.cryptos.data.data_source.CryptoDao
import ke.co.svs.mykrypto.domain.model.Crypto
import ke.co.svs.mykrypto.network.responses.CryptoResponse

@Database(
    entities = [Crypto::class],
    version = 1,
    exportSchema = false,
)
abstract class RoomDB : RoomDatabase() {
    abstract val cryptoDao: CryptoDao
}


fun List<CryptoResponse>.asDomainModel(): List<Crypto> {
    return map {
        Crypto(
            id = it.id!!,
            name = it.name,
            myQuantity = it.myQuantity,
            symbol = it.symbol,
            logo = it.imageUrl,
            price = it.priceUSD,
            priceChange24h = it.percentChange_24h, // todo
            percentChange24h = it.percentChange_24h,
            lastUpdated = it.lastUpdated.toString()
        )
    }
}