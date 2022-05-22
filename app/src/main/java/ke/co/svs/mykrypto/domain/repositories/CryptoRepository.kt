package ke.co.svs.mykrypto.domain.repositories

import ke.co.svs.mykrypto.domain.model.Crypto
import ke.co.svs.mykrypto.network.responses.CryptoResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface CryptoRepository {
    fun getAllCryptos(): Flow<List<Crypto>>
    suspend fun fetchCryptos(limit: Int): Flow<List<CryptoResponse>>

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