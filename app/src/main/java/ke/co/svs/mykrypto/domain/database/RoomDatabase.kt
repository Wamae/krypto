package ke.co.svs.mykrypto.domain.database

import androidx.room.Database
import androidx.room.RoomDatabase
import ke.co.svs.mykrypto.cryptos.data.data_source.CryptoDao
import ke.co.svs.mykrypto.cryptos.data.data_source.CryptoDetailsDao
import ke.co.svs.mykrypto.cryptos.data.data_source.UserCryptoDao
import ke.co.svs.mykrypto.domain.model.Crypto
import ke.co.svs.mykrypto.domain.model.CryptoDetails
import ke.co.svs.mykrypto.domain.model.UserCrypto
import ke.co.svs.mykrypto.network.responses.CryptoDetailsResponse

@Database(
    entities = [Crypto::class, UserCrypto::class, CryptoDetails::class],
    version = 1,
    exportSchema = false,
)
abstract class RoomDB : RoomDatabase() {
    abstract val cryptoDao: CryptoDao
    abstract val cryptoDetailsDao: CryptoDetailsDao
    abstract val userCryptoDetailsDao: UserCryptoDao
}

fun List<CryptoDetailsResponse>.asUserCryptoModel(): List<UserCrypto> {
    return map {
        UserCrypto(
            id = it.id!!
        )
    }
}

fun List<CryptoDetailsResponse>.asCryptoModel(): List<Crypto> {
    return map {
        Crypto(
            id = it.id!!,
            name = it.name,
            symbol = it.symbol,
        )
    }
}

fun List<CryptoDetailsResponse>.asCryptoDetailsModel(): List<CryptoDetails> {
    return map {
        CryptoDetails(
            id = it.id!!,
            name = it.name,
            symbol = it.symbol,
            logo = it.imageUrl,
            price = it.priceUSD,
            priceChange24h = it.percentChange_24h, // todo
            percentChange24h = it.percentChange_24h,
            lastUpdated = it.lastUpdated.toString()
        )
    }
}