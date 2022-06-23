package ke.co.svs.mykrypto.domain.repositories

import android.content.Context
import ke.co.svs.mykrypto.base.BaseListRepository
import ke.co.svs.mykrypto.cryptos.data.data_source.CryptoDao
import ke.co.svs.mykrypto.domain.database.asCryptoModel
import ke.co.svs.mykrypto.domain.model.Crypto
import ke.co.svs.mykrypto.network.CoinGeckoService
import kotlinx.coroutines.CoroutineDispatcher

class CryptoRepositoryImpl(
    private val coinGeckoService: CoinGeckoService,
    private val dao: CryptoDao,
    context: Context,
    dispatcher: CoroutineDispatcher

) : BaseListRepository<Crypto>(context, dispatcher) {

    override suspend fun query(): List<Crypto> {
        return dao.getCryptos()
    }

    override suspend fun fetch(limit: Int,currency:String, ids:String): List<Crypto> {
        return coinGeckoService.fetchBasicCryptoList(limit = limit).asCryptoModel()
    }

    override suspend fun saveFetchResult(items: List<Crypto>) {
        dao.insertAll(*items.toTypedArray())
    }

}