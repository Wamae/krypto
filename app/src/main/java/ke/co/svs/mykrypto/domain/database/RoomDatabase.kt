package ke.co.svs.mykrypto.domain.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.google.gson.Gson
import ke.co.svs.mykrypto.cryptos.data.data_source.CryptoDao
import ke.co.svs.mykrypto.cryptos.data.data_source.CryptoDetailDao
import ke.co.svs.mykrypto.cryptos.data.data_source.UserCryptoDao
import ke.co.svs.mykrypto.domain.model.Crypto
import ke.co.svs.mykrypto.domain.model.CryptoDetail
import ke.co.svs.mykrypto.domain.model.UserCrypto
import ke.co.svs.mykrypto.network.responses.CryptoDetailResponse

@Database(
    entities = [Crypto::class, UserCrypto::class, CryptoDetail::class],
    version = 1,
    exportSchema = false,
)
abstract class RoomDB : RoomDatabase() {
    abstract val cryptoDao: CryptoDao
    abstract val cryptoDetailsDao: CryptoDetailDao
    abstract val userCryptoDetailsDao: UserCryptoDao
}

fun List<CryptoDetailResponse>.asUserCryptoModel(): List<UserCrypto> {
    return map {
        UserCrypto(
            id = it.id!!
        )
    }
}

fun List<CryptoDetailResponse>.asCryptoModel(): List<Crypto> {
    return map {
        Crypto(
            id = it.id!!,
            name = it.name,
            symbol = it.symbol,
        )
    }
}

fun List<CryptoDetailResponse>.asCryptoDetailsModel(): List<CryptoDetail> {
    val gson = Gson();
    println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
    forEach {
        it -> println(gson.toJson(it))
    }
    return map {
        CryptoDetail(
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