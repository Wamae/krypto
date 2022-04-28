package ke.co.svs.mykrypto.domain.repositories

import ke.co.svs.mykrypto.domain.model.CryptoDataModel
import ke.co.svs.mykrypto.network.Resource
import kotlinx.coroutines.flow.Flow

interface CryptoRepository {
    fun getCryptos(limit: Int): Flow<List<CryptoDataModel>>

    suspend fun fetchCryptos(): Resource<Flow<List<CryptoDataModel>>>

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