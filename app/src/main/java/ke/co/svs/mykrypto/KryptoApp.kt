package ke.co.svs.mykrypto

import android.app.Application
import ke.co.svs.mykrypto.di.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class KryptoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // start Koin
        startKoin {
            // declare used Android context
            androidContext(this@KryptoApp)
            // declare modules
            modules(listOf(retrofitModule))
        }
    }
}