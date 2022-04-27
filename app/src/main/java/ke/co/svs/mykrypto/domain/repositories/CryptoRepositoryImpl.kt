package ke.co.svs.mykrypto.domain.repositories

import ke.co.svs.mykrypto.cryptos.data.data_source.CryptoDao
import ke.co.svs.mykrypto.domain.model.Crypto
import ke.co.svs.mykrypto.network.CoinGeckoService
import kotlinx.coroutines.flow.Flow

class CryptoRepositoryImpl(
    private val coinGeckoService: CoinGeckoService,
    private val dao: CryptoDao,
) : CryptoRepository {
    override fun getAllCryptos(): Flow<List<Crypto>> {
        return dao.getCryptos()
    }
}