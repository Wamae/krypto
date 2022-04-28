package ke.co.svs.mykrypto.domain.repositories

import ke.co.svs.mykrypto.cryptos.data.data_source.CryptoDao
import ke.co.svs.mykrypto.domain.model.CryptoDataModel
import ke.co.svs.mykrypto.network.CoinGeckoService
import ke.co.svs.mykrypto.network.responses.CryptoResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class CryptoRepositoryImpl(
    private val coinGeckoService: CoinGeckoService,
    private val dao: CryptoDao,
) : CryptoRepository {
    override fun getAllCryptos(): Flow<List<CryptoDataModel>> {
        return dao.getCryptos()
    }

    override suspend fun fetchCryptos(limit: Int): Flow<List<CryptoResponse>> {
        return coinGeckoService.getMyCryptos(limit = limit)
    }

}