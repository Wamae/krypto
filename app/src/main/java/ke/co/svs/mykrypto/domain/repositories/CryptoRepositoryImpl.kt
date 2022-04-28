package ke.co.svs.mykrypto.domain.repositories

import ke.co.svs.mykrypto.cryptos.data.data_source.CryptoDao
import ke.co.svs.mykrypto.domain.model.CryptoDataModel
import ke.co.svs.mykrypto.network.CoinGeckoService
import ke.co.svs.mykrypto.network.Resource
import ke.co.svs.mykrypto.network.responses.CryptoResponse
import kotlinx.coroutines.flow.Flow

class CryptoRepositoryImpl(
    private val coinGeckoService: CoinGeckoService,
    private val dao: CryptoDao,
) : CryptoRepository {

    override fun getCryptos(limit: Int): Flow<List<CryptoDataModel>> {
        return dao.getCryptos()
    }

    override suspend fun fetchCryptos(): Resource<Flow<List<CryptoDataModel>>> {

        val myResponseList: List<CryptoResponse>? =
            coinGeckoService.getCryptos().data


        val cryptos = myResponseList?.map {
            CryptoDataModel(
                id = it.id!!,
                name = it.name,
                symbol = it.symbol,
                logo = it.imageUrl,
//                myQuantity = it.myQuantity,
                price = it.priceBTC,
                priceChange24h = it.volumeUSD_24h,
                percentChange24h = it.percentChange_24h,
                lastUpdated = it.lastUpdated.toString()
//                    sparkData = it.
            )
        }

        cryptos?.forEach { it -> dao.insertCrypto(it) }

        /**
         * Despite return, data has already been save to zoom
         * */

        return (cryptos
            ?.let { return@let Resource.success(it) }
            ?: Resource.error(null, "Could not get Cryptos")) as Resource<Flow<List<CryptoDataModel>>>

    }

}