package ke.co.svs.mykrypto.domain.repositories

import android.content.Context
import ke.co.svs.mykrypto.base.BaseListRepository
import ke.co.svs.mykrypto.cryptos.data.data_source.CryptoDao
import ke.co.svs.mykrypto.cryptos.data.data_source.CryptoDetailsDao
import ke.co.svs.mykrypto.domain.database.asCryptoDetailsModel
import ke.co.svs.mykrypto.domain.database.asCryptoModel
import ke.co.svs.mykrypto.domain.model.Crypto
import ke.co.svs.mykrypto.domain.model.CryptoDetails
import ke.co.svs.mykrypto.network.CoinGeckoService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class CryptoDetailsRepositoryImpl(
    private val coinGeckoService: CoinGeckoService,
    private val dao: CryptoDetailsDao,
    context: Context,
    dispatcher: CoroutineDispatcher

) : BaseListRepository<CryptoDetails>(context, dispatcher) {

    override suspend fun query(): List<CryptoDetails> {
        return dao.getCryptos();
    }

    override suspend fun fetch(limit: Int,currency:String, ids:String): List<CryptoDetails> {
        return coinGeckoService.fetchCryptoDetails(currency = currency, ids = ids).asCryptoDetailsModel()
    }

    override suspend fun saveFetchResult(items: List<CryptoDetails>) {
        dao.insertAll(*items.toTypedArray())
    }

}