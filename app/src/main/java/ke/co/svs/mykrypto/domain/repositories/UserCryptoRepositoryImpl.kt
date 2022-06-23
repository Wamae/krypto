package ke.co.svs.mykrypto.domain.repositories

import android.content.Context
import ke.co.svs.mykrypto.base.BaseListRepository
import ke.co.svs.mykrypto.cryptos.data.data_source.UserCryptoDao
import ke.co.svs.mykrypto.domain.database.asUserCryptoModel
import ke.co.svs.mykrypto.domain.model.UserCrypto
import ke.co.svs.mykrypto.network.CoinGeckoService
import ke.co.svs.mykrypto.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow

class UserCryptoRepositoryImpl(
    private val coinGeckoService: CoinGeckoService,
    private val dao: UserCryptoDao,
    context: Context,
    dispatcher: CoroutineDispatcher
)  {

     suspend fun query(): Flow<Resource<List<UserCrypto>>> {
        return flow { emit( Resource.success(dao.getCryptos())) }
    }

}