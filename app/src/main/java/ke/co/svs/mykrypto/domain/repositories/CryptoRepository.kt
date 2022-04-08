package ke.co.svs.mykrypto.domain.repositories

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import ke.co.svs.mykrypto.domain.model.Crypto
import kotlinx.coroutines.flow.Flow

interface CryptoRepository {
    fun getAllCryptos(): Flow<List<Crypto>>

    // fun getAllCryptoInfo(perPage: Int): Flow<JsonArray>

    // fun getAllCryptoDetails(): Flow<JsonObject>

    // fun getUsersCryptos():Flow<DataSnapshot>

    // fun saveCrypto(symbol: String?,quantity: Double?): Completable

    // fun editCrypto(crypto: BasicCrypto):Completable

    // fun removeCrypto(crypto: BasicCrypto):Completable
    //Alerts
    // fun getUsersAlerts(): Observable<DataSnapshot>
    // fun getAlertsQuery(): Query
}