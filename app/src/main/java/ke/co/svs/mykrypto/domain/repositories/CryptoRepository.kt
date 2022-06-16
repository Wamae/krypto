package ke.co.svs.mykrypto.domain.repositories

import ke.co.svs.mykrypto.domain.model.CryptoDetails
import ke.co.svs.mykrypto.network.responses.CryptoDetailsResponse
import kotlinx.coroutines.flow.Flow

interface CryptoRepository {
    fun getAllCryptos(): Flow<List<CryptoDetails>>
    suspend fun fetchCryptos(limit: Int): Flow<List<CryptoDetailsResponse>>

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