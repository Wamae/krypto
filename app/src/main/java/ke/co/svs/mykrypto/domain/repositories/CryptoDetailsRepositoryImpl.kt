package ke.co.svs.mykrypto.domain.repositories

import android.content.Context
import ke.co.svs.mykrypto.base.BaseListRepository
import ke.co.svs.mykrypto.cryptos.data.data_source.CryptoDetailDao
import ke.co.svs.mykrypto.domain.database.asCryptoDetailsModel
import ke.co.svs.mykrypto.domain.model.CryptoDetail
import ke.co.svs.mykrypto.network.CoinGeckoService
import kotlinx.coroutines.CoroutineDispatcher

class CryptoDetailsRepositoryImpl(
    private val coinGeckoService: CoinGeckoService,
    private val dao: CryptoDetailDao,
    context: Context,
    dispatcher: CoroutineDispatcher

) : BaseListRepository<CryptoDetail>(context, dispatcher) {

    override suspend fun query(): List<CryptoDetail> {
        return dao.getCryptos();
    }

    override suspend fun fetch(limit: Int,currency:String, ids:String): List<CryptoDetail> {
        return coinGeckoService.fetchCryptoDetails(currency = currency, ids = ids).asCryptoDetailsModel()
    }

    override suspend fun saveFetchResult(items: List<CryptoDetail>) {
        dao.insertAll(*items.toTypedArray())
    }

}