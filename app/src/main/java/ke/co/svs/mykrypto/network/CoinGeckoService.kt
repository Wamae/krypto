package ke.co.svs.mykrypto.network

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import ke.co.svs.mykrypto.network.responses.CryptoResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface CoinGeckoService {
    @GET("ticker")
    fun getMyCryptos(@Query("limit") limit: Int):
            List<CryptoResponse>

    @GET("coins/markets")
    fun getCryptoInfo(@Query("per_page") perPage: Int,
                      @Query("vs_currency") currency: String,
                      @Query("sparkline") sparkLine: Boolean): Flow<JsonArray>

    @GET
    fun getCryptoDetails(@Url url: String): Flow<JsonObject>

    @GET
    fun getCurrencies(@Url url: String): Flow<JsonObject>
}