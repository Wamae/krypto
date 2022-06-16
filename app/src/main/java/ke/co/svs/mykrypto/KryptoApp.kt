package ke.co.svs.mykrypto

import android.app.Application
import androidx.lifecycle.ViewModel
import ke.co.svs.mykrypto.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.androidx.viewmodel.ViewModelOwner
import org.koin.core.context.GlobalContext
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.qualifier.Qualifier
import org.koin.core.scope.Scope
import timber.log.Timber

class KryptoApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // start Koin
        startKoin {
            // declare used Android context
            androidContext(this@KryptoApp)

            // declare modules
            modules(
                apiModule,
                retrofitModule,
                repositoryModule,
                viewModelModule,
                databaseModule,
                dispatcherModule
            )
        }

        //Timber set up
        Timber.plant(Timber.DebugTree())
    }


}

