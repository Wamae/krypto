package ke.co.svs.mykrypto.di

import ke.co.svs.mykrypto.domain.repositories.CryptoRepositoryImpl
import org.koin.dsl.module


val repositoryModule = module {
    single { CryptoRepositoryImpl(get(),get()) }
}